package by.orion.onlinertasks.common.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    @NonNull
    private final List<T> resources = new ArrayList<>();

    @Override
    public int getItemCount() {
        return resources.size();
    }

    public void setResources(@NonNull List<T> resources) {
        this.resources.clear();
        addAll(resources);
    }

    public void addItem(@NonNull T item) {
        resources.add(item);
        notifyItemInserted(resources.size() - 1);
    }

    public void addItem(@NonNull T item, int position) {
        resources.add(position, item);
        notifyItemInserted(position);
    }

    public void addAll(@NonNull Collection<T> items) {
        int size = resources.size();
        resources.addAll(items);
        notifyItemRangeInserted(size, items.size());
    }

    public void removeItem(@NonNull T item) {
        int pos = getItemPosition(item);
        if (pos == -1) {
            return;
        }

        resources.remove(pos);
        notifyItemRemoved(pos);
    }

    public void removeItem(int pos) {
        if (pos >= resources.size()) {
            return;
        }

        resources.remove(pos);
        notifyItemRemoved(pos);
    }

    @NonNull
    public T getItem(int position) {
        return resources.get(position);
    }

    private int getItemPosition(@NonNull T item) {
        for (int i = 0; i < resources.size(); ++i) {
            if (resources.get(i) == item) {
                return i;
            }
        }

        return -1;
    }
}
