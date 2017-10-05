package by.orion.onlinertasks.presentation.profile.details.pages.reviews.adapters.holders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

import butterknife.BindView;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.holders.AbstractRecyclerViewHolder;
import by.orion.onlinertasks.common.utils.ImageUtils;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.AuthorItem;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.TaskItem;

public class ReviewExecutorViewHolder extends AbstractRecyclerViewHolder<ReviewItem> {

    @BindView(R.id.imageview_review_executor)
    ImageView imageViewAuthor;

    @BindView(R.id.textview_review_executor_author)
    TextView textViewAuthor;

    @BindView(R.id.textview_review_executor_created_at)
    TextView textViewCreatedAt;

    @BindView(R.id.textview_review_executor_task_title)
    TextView textViewTaskTitle;

    @BindView(R.id.textview_review_executor_review)
    TextView textViewReview;

    @BindView(R.id.ratingbar_review_executor_rating)
    RatingBar ratingBarRating;

    public ReviewExecutorViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewItem reviewItem) {
        Context context = itemView.getContext();
        AuthorItem author = reviewItem.author();
        TaskItem task = reviewItem.task();

        if (!TextUtils.isEmpty(author.photo())) {
            Glide.with(context)
                    .load(author.photo())
                    .apply(new RequestOptions().transform(new CircleCrop()))
                    .into(imageViewAuthor);
        } else {
            Bitmap bitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Random rnd = new Random();
            canvas.drawColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            imageViewAuthor.setImageDrawable(new BitmapDrawable(context.getResources(), ImageUtils.getCircleBitmap(bitmap)));
        }

        textViewCreatedAt.setText(DateUtils.getRelativeTimeSpanString(reviewItem.createdAt().getTime(), System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS));
        textViewAuthor.setText(author.name());
        textViewReview.setText(reviewItem.review());
        ratingBarRating.setRating(reviewItem.averageRating());

        if (task != null) {
            textViewTaskTitle.setText(task.title());
        }
    }
}
