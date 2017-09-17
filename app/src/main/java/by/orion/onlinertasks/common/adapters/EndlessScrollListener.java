package by.orion.onlinertasks.common.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private boolean loading = true;
    private int pastVisibleItems;
    private int visibleItemCount;
    private int totalItemCount;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();

            visibleItemCount = linearLayoutManager.getChildCount();
            totalItemCount = linearLayoutManager.getItemCount();
            pastVisibleItems = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

            if (loading) {
                if ((visibleItemCount + pastVisibleItems) >= totalItemCount)  {
                    loading = false;
                    loadMore();
                }
            }
        }
    }

    public abstract void loadMore();
}
