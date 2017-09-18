package by.orion.onlinertasks.presentation.main.fragments.adapters.holders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

import butterknife.BindView;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.holders.AbstractViewHolder;
import by.orion.onlinertasks.common.utils.ImageUtils;
import by.orion.onlinertasks.presentation.main.fragments.models.AuthorItem;
import by.orion.onlinertasks.presentation.main.fragments.models.TaskItem;

public class TaskViewHolder extends AbstractViewHolder<TaskItem> {

    @BindView(R.id.imageview_task_preview)
    ImageView imageViewPreview;

    @BindView(R.id.textview_task_title)
    TextView textViewTitle;

    @BindView(R.id.textview_task_description)
    TextView textViewDescription;

    @BindView(R.id.textivew_task_price)
    TextView textViewPrice;

    @BindView(R.id.textivew_task_status)
    TextView textViewStatus;

    @BindView(R.id.textview_task_deadline)
    TextView textViewDeadline;

    @BindView(R.id.textview_task_location)
    TextView textViewLocation;

    @BindView(R.id.textview_task_proposal)
    TextView textViewProposal;

    @BindView(R.id.textview_task_section)
    TextView textViewSection;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBindHolder(@NonNull TaskItem task) {
        Context context = itemView.getContext();

        AuthorItem author = task.author();

        if (!TextUtils.isEmpty(author.photo())) {
            Glide.with(context)
                    .load(author.photo())
                    .apply(new RequestOptions().transform(new CircleCrop()))
                    .into(imageViewPreview);
        } else {
            Bitmap bitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Random rnd = new Random();
            canvas.drawColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            imageViewPreview.setImageDrawable(new BitmapDrawable(context.getResources(), ImageUtils.getCircleBitmap(bitmap)));
        }

        textViewTitle.setText(task.title());
        textViewDescription.setText(task.description());
        textViewDeadline.setText(task.deadline());
        textViewLocation.setText(task.location().town());
        textViewStatus.setText(context.getString(task.status().getResId()));
        textViewSection.setText(task.section().name());

        if (TextUtils.isEmpty(task.price())) {
            textViewPrice.setText(task.price());
        } else {
            textViewPrice.setText(context.getString(R.string.msg_task_contractual));
        }

        if (task.proposalsQty() > 0) {
            textViewProposal.setVisibility(View.VISIBLE);
            textViewProposal.setText(String.valueOf(task.proposalsQty()));
        } else {
            textViewProposal.setVisibility(View.GONE);
        }
    }
}
