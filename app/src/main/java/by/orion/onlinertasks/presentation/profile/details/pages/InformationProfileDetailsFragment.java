package by.orion.onlinertasks.presentation.profile.details.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import by.orion.onlinertasks.R;

public class InformationProfileDetailsFragment extends MvpAppCompatFragment {

    @NonNull
    private static final String BUNDLE_PROFILE_ID = "BUNDLE_PROFILE_ID";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_details_information, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @NonNull
    public static Fragment newInstance(@NonNull Integer id) {
        Fragment fragment = new InformationProfileDetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_PROFILE_ID, id);

        fragment.setArguments(bundle);
        return fragment;
    }
}
