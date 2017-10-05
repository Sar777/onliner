package by.orion.onlinertasks.presentation.profile.details.pages.reviews.models;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.Date;

import by.orion.onlinertasks.data.models.common.Role;

@AutoValue
public abstract class ReviewItem {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract Float averageRating();

    @NonNull
    public abstract RatingItem rating();

    @NonNull
    public abstract String review();

    @NonNull
    public abstract AuthorItem author();

    @Nullable
    public abstract TaskItem task();

    @NonNull
    public abstract Date createdAt();

    @NonNull
    public abstract Role profileRole();

    public static Builder builder() {
        return new AutoValue_ReviewItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder averageRating(Float avgRating);
        public abstract Builder rating(RatingItem rating);
        public abstract Builder review(String review);
        public abstract Builder author(AuthorItem author);
        public abstract Builder task(TaskItem task);
        public abstract Builder createdAt(Date date);
        public abstract Builder profileRole(Role role);
        public abstract ReviewItem build();
    }
}
