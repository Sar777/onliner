package by.orion.onlinertasks.presentation.main.fragments.profiles.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.AbstractRecyclerAdapter;
import by.orion.onlinertasks.common.adapters.holders.AbstractRecyclerViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.profiles.adapters.holders.ProfileViewHolder;
import by.orion.onlinertasks.presentation.main.fragments.profiles.adapters.listeners.OnClickProfileListener;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;

public class ProfilesAdapter extends AbstractRecyclerAdapter<ProfileItem, AbstractRecyclerViewHolder> {

    @NonNull
    private final OnClickProfileListener listener;

    public ProfilesAdapter(@NonNull OnClickProfileListener listener) {
        this.listener = listener;
    }

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbstractRecyclerViewHolder holder = super.onCreateViewHolder(parent, viewType);
        if (holder != null) {
            return holder;
        }

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ProfileViewHolder(listener, inflater.inflate(R.layout.item_profile, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractRecyclerViewHolder holder, int position) {
        ProfileItem item = getItem(position);
        if (item == null) {
            return;
        }

        ((ProfileViewHolder)holder).onBindViewHolder(item);
    }

    @Override
    public long getItemId(int position) {
        ProfileItem item = getItem(position);
        if (item == null) {
            return -1;
        }

        return item.id();
    }
}
