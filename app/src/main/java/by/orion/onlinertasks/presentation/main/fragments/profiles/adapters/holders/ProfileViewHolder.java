package by.orion.onlinertasks.presentation.main.fragments.profiles.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.holders.AbstractRecyclerViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.profiles.adapters.listeners.OnClickProfileListener;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;

public class ProfileViewHolder extends AbstractRecyclerViewHolder<ProfileItem> {

    @BindView(R.id.imageview_profile_preview)
    ImageView imageViewPreview;

    @BindView(R.id.textivew_profile_title)
    TextView textViewTitle;

    @BindView(R.id.textivew_profile_description)
    TextView textViewDescription;

    @BindView(R.id.textivew_profile_task_completed)
    TextView textViewTaskCompleted;

    @BindView(R.id.textivew_profile_sections)
    TextView textViewSections;

    @BindView(R.id.textview_profile_votes)
    TextView textViewVotes;

    @BindView(R.id.ratingbar_profile_rating)
    RatingBar ratingBarRating;

    @NonNull
    private final OnClickProfileListener listener;

    public ProfileViewHolder(@NonNull OnClickProfileListener listener, @NonNull View itemView) {
        super(itemView);
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileItem profile) {
        Context context = itemView.getContext();

        if (!TextUtils.isEmpty(profile.photo())) {
            Glide.with(context)
                    .load(profile.photo())
                    .apply(new RequestOptions().transform(new CircleCrop()))
                    .into(imageViewPreview);
        }

        itemView.setTag(profile.id());
        itemView.setOnClickListener(v -> listener.onClick((Integer) v.getTag()));

        textViewTitle.setText(profile.displayName());
        textViewDescription.setText(profile.description());
        textViewSections.setText(profile.sections());
        textViewTaskCompleted.setText(profile.completedTasksQty());
        ratingBarRating.setRating(profile.rating().averageRate());
        textViewVotes.setText(String.valueOf(profile.rating().votes()));
    }
}
