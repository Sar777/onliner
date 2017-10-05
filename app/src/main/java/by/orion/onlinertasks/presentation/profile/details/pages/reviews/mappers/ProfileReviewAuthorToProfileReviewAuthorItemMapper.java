package by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.reviews.Author;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.AuthorItem;

public class ProfileReviewAuthorToProfileReviewAuthorItemMapper implements GenericObjectMapper<Author, AuthorItem> {

    @NonNull
    @Override
    public AuthorItem map(@NonNull Author author) {
        return AuthorItem.builder()
                .id(author.id())
                .name(author.name())
                .photo(author.photo())
                .build();
    }
}
