package by.orion.onlinertasks.presentation.introduction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.utils.TextCustomUtils;
import by.orion.onlinertasks.di.components.presentation.DaggerIntroductionPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.IntroductionPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.IntroductionPresenterModule;
import by.orion.onlinertasks.presentation.introduction.adapters.IntroductionViewPagerAdapter;
import by.orion.onlinertasks.presentation.main.MainActivity;

public class IntroductionActivity extends MvpAppCompatActivity implements IntroductionView {

    @BindView(R.id.layout_dots_introduction)
    ViewGroup viewGroupDots;

    @BindView(R.id.viewpager_introduction_dots)
    ViewPager viewPager;

    @BindView(R.id.button_introduction_next)
    Button buttonNext;

    @BindView(R.id.button_introduction_skip)
    Button buttonSkip;

    @InjectPresenter
    IntroductionPresenter presenter;

    private IntroductionViewPagerAdapter adapter;

    private TextView[] dots;

    @LayoutRes
    private final int[] layouts = new int[] {
            R.layout.introduction_slide1,
            R.layout.introduction_slide2,
            R.layout.introduction_slide3,
            R.layout.introduction_slide4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_introduction);

        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void setCurrentDot(int page) {
        dots = new TextView[layouts.length];

        viewGroupDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(TextCustomUtils.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            dots[i].setLayoutParams(layoutParams);
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.introduction_dot_light));
            viewGroupDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[page].setTextColor(ContextCompat.getColor(this, R.color.introduction_dot_dark));
        }
    }

    @Override
    public void selectPage(int page) {
        viewPager.setCurrentItem(page);
    }

    @Override
    public void setButtonNextText(@StringRes int resId) {
        buttonNext.setText(getString(resId));
    }

    @Override
    public void showButtonSkip() {
        buttonSkip.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideButtonSkip() {
        buttonSkip.setVisibility(View.GONE);
    }

    @Override
    public void goToMainScreen() {
        startActivity(MainActivity.newIntent(this));
        finish();
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        adapter = new IntroductionViewPagerAdapter(this, layouts);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                presenter.onPageSelected(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        buttonSkip.setOnClickListener(v -> presenter.onSkipClick());
        buttonNext.setOnClickListener(v -> presenter.onNextSlideClick());
    }

    @ProvidePresenter
    IntroductionPresenter providePresenter() {
        IntroductionPresenterComponent introductionPresenterComponent = DaggerIntroductionPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .introductionPresenterModule(new IntroductionPresenterModule(layouts.length))
                .build();

        return introductionPresenterComponent.getPresenter();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        Intent intent = new Intent(context, IntroductionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
