package by.orion.onlinertasks.presentation.main.fragments.tasks.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Image;
import by.orion.onlinertasks.data.models.task.Price;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.presentation.common.models.TaskStatus;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskItem;

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
        Image image = task.image();
        Price price = task.price();
        return TaskItem.builder()
                .id(task.id())
                .title(task.title())
                .description(task.description())
                .imageUrl(image != null ? image._280x280() : null)
                .price(price != null ? String.format("%s %s", price.amount(), price.currency()) : null)
                .status(TaskStatus.get(task.status()))
                .proposalsQty(task.proposals_qty())
                .location(new TaskLocationToTaskLocationItemMapper().map(task.location()))
                .deadline(String.format("%s %s", context.getString(R.string.common_before), task.deadline()))
                .createdAt(task.createdAt())
                .author(new TaskAuthorToTaskAuthorItemMapper().map(task.author()))
                .section(new TaskSectionToTaskSectionItemMapper().map(task.section()))
                .build();
    }
}
