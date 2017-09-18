package by.orion.onlinertasks.common.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.holders.EmptyViewHolder;
import by.orion.onlinertasks.common.adapters.holders.ProgressBarViewHolder;

public abstract class AbstractRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final int ITEM_VIEW_NORMAL = 0;
    protected final int ITEM_VIEW_EMPTY = 1;
    protected final int ITEM_VIEW_PROGRESS = 2;

    @NonNull
    private final List<T> resources = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        if (resources.isEmpty()) {
            return ITEM_VIEW_EMPTY;
        }

        if (getItem(position) == null) {
            return ITEM_VIEW_PROGRESS;
        }

        return ITEM_VIEW_NORMAL;
    }

    @SuppressWarnings("unchecked")
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_VIEW_EMPTY:
                return (VH) new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_empty, parent, false));
            case ITEM_VIEW_PROGRESS:
                return (VH) new ProgressBarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_progress, parent, false));
            default:
                break;
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return resources.size();
    }

    public void setResources(@NonNull List<T> resources) {
        this.resources.clear();
        addAll(resources);
    }

    public void addItem(@Nullable T item) {
        resources.add(item);
        // W/RecyclerView: Cannot call this method in a scroll callback. Scroll callbacks might be run during a measure & layout pass where you cannot change the RecyclerView data. Any method call that might change the structure of the RecyclerView or the adapter contents should be postponed to the next frame.java.lang.IllegalStateException:
        new Handler().post(() -> notifyItemInserted(resources.size() - 1));
    }

    public void addItem(@NonNull T item, int position) {
        resources.add(position, item);
        notifyItemInserted(position);
    }

    public void addAll(@NonNull Collection<T> items) {
        int size = resources.size();
        resources.addAll(items);

        if (size > 0) {
            // Remove progressbar
            if (getItem(size - 1) == null) {
                resources.remove(size - 1);

                if (items.isEmpty()) {
                    notifyItemRemoved(size);
                } else {
                    notifyItemChanged(size);
                }
            }
        }

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

    @Nullable
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
