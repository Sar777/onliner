package by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.reviews.Task;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.TaskItem;

public class ProfileReviewTaskToProfileReviewTaskItemMapper implements GenericObjectMapper<Task, TaskItem> {

    @NonNull
    @Override
    public TaskItem map(@NonNull Task task) {
        return TaskItem.builder()
                .id(task.id())
                .title(task.title())
                .build();
    }
}
