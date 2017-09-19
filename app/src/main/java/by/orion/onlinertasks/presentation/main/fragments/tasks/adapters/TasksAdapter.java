package by.orion.onlinertasks.presentation.main.fragments.tasks.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.AbstractRecyclerAdapter;
import by.orion.onlinertasks.common.adapters.holders.AbstractRecyclerViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.tasks.adapters.holders.TaskViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskItem;

public class TasksAdapter extends AbstractRecyclerAdapter<TaskItem, AbstractRecyclerViewHolder> {

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbstractRecyclerViewHolder holder = super.onCreateViewHolder(parent, viewType);
        if (holder != null) {
            return holder;
        }

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TaskViewHolder(inflater.inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractRecyclerViewHolder holder, int position) {
        TaskItem taskItem = getItem(position);
        if (taskItem == null) {
            return;
        }

        ((TaskViewHolder)holder).onBindViewHolder(taskItem);
    }

    @Override
    public long getItemId(int position) {
        TaskItem item = getItem(position);
        if (item == null) {
            return -1;
        }

        return item.id();
    }
}
