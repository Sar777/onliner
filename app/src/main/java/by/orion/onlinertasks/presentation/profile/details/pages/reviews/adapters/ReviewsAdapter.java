package by.orion.onlinertasks.presentation.profile.details.pages.reviews.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.AbstractRecyclerAdapter;
import by.orion.onlinertasks.common.adapters.holders.AbstractRecyclerViewHolder;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.adapters.holders.ReviewEmptyViewHolder;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.adapters.holders.ReviewExecutorViewHolder;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

public class ReviewsAdapter extends AbstractRecyclerAdapter<ReviewItem, AbstractRecyclerViewHolder> {

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_VIEW_PROGRESS) {
            AbstractRecyclerViewHolder holder = super.onCreateViewHolder(parent, viewType);
            if (holder != null) {
                return holder;
            }
        } else if (viewType == ITEM_VIEW_EMPTY) {
            return new ReviewEmptyViewHolder(inflater.inflate(R.layout.item_review_empty, parent, false));
        }

        return new ReviewExecutorViewHolder(inflater.inflate(R.layout.item_review_executor, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractRecyclerViewHolder holder, int position) {
        if (!(holder instanceof ReviewExecutorViewHolder)) {
            return;
        }

        ReviewItem item = getItem(position);
        if (item == null) {
            return;
        }

        ((ReviewExecutorViewHolder)holder).onBindViewHolder(item);
    }

    @Override
    public long getItemId(int position) {
        ReviewItem item = getItem(position);
        if (item == null) {
            return -1;
        }

        return item.id();
    }
}
