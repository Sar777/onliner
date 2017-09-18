package by.orion.onlinertasks.common.adapters.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class AbstractRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    public AbstractRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public abstract void onBindViewHolder(@NonNull T data);
}
