package by.orion.onlinertasks.presentation.main.fragments.profiles.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class ProfilePage {

    public abstract int page();

    public abstract int lastPage();

    @NonNull
    public abstract List<ProfileItem> profiles();

    public static Builder builder() {
        return new AutoValue_ProfilePage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder page(int page);
        public abstract Builder lastPage(int lastPage);
        public abstract Builder profiles(List<ProfileItem> profiles);
        public abstract ProfilePage build();
    }
}
