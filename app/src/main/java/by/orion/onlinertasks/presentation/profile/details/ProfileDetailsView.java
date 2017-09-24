package by.orion.onlinertasks.presentation.profile.details;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.presentation.BaseMvpView;

public interface ProfileDetailsView extends BaseMvpView {

    void setBackground(@NonNull String imageUrl);

    void setAvatar(@NonNull String imageUrl);
}
