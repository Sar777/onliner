package by.orion.onlinertasks.presentation.main.fragments.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.presentation.common.models.TaskStatus;
import by.orion.onlinertasks.presentation.main.fragments.models.TaskItem;

public class TaskToTaskItemMapper implements GenericObjectMapper<Task, TaskItem> {

    @NonNull
    private final Context context;

    @Inject
    public TaskToTaskItemMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TaskItem map(@NonNull Task task) {
        return TaskItem.builder()
                .id(task.id())
                .title(task.title())
                .description(task.description())
                .imageUrl(task.image() != null ? task.image()._280x280() : null)
                .price(task.price() != null ? String.format("%s %s", task.price().amount(), task.price().currency()) : null)
                .status(TaskStatus.get(task.status()))
                .proposalsQty(task.proposals_qty())
                .location(new TaskLocationToTaskLocationItemMapper().map(task.location()))
                .deadline(String.format("%s %s", context.getString(R.string.common_before), task.deadline()))
                .createdAt(task.created_at())
                .author(new TaskAuthorToTaskAuthorItemMapper().map(task.author()))
                .section(new TaskSectionToTaskSectionItemMapper().map(task.section()))
                .build();
    }
}
