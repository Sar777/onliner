package by.orion.onlinertasks.presentation.main.fragments.tasks.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskItem;

public class ListTaskToListTaskItemMapper implements GenericObjectMapper<List<Task>, List<TaskItem>> {

    @NonNull
    private final Context context;

    @Inject
    public ListTaskToListTaskItemMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public List<TaskItem> map(@NonNull List<Task> tasks) {
        List<TaskItem> taskItems = new ArrayList<>(tasks.size());
        GenericObjectMapper<Task, TaskItem> mapper = new TaskToTaskItemMapper(context);
        for (Task task : tasks) {
            taskItems.add(mapper.map(task));
        }

        return taskItems;
    }
}
