package by.orion.onlinertasks.presentation.main.fragments.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.AbstractRecyclerAdapter;
import by.orion.onlinertasks.presentation.main.fragments.adapters.holders.TaskViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.models.TaskItem;

public class TasksAdapter extends AbstractRecyclerAdapter<TaskItem, TaskViewHolder> {

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TaskViewHolder(inflater.inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onBindHolder(getItem(position));
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id();
    }
}
