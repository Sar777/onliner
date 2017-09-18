package by.orion.onlinertasks.presentation.main.fragments.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Author;
import by.orion.onlinertasks.presentation.main.fragments.models.AuthorItem;

public class TaskAuthorToTaskAuthorItemMapper implements GenericObjectMapper<Author, AuthorItem> {
    
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
