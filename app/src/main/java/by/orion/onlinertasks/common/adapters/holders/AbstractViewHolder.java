package by.orion.onlinertasks.common.adapters.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public AbstractViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public abstract void onBindHolder(@NonNull T data);
}
