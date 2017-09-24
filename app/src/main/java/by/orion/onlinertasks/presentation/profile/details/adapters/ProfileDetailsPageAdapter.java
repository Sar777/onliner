package by.orion.onlinertasks.presentation.profile.details.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.presentation.profile.details.pages.InformationProfileDetailsFragment;

public class ProfileDetailsPageAdapter extends FragmentStatePagerAdapter {

    private static final int MAX_PAGE = 3;

    @NonNull
    private final Context context;

    @NonNull
    private final Integer profileId;

    public ProfileDetailsPageAdapter(@NonNull Context context, @NonNull Integer profileId, @NonNull FragmentManager fm) {
        super(fm);

        this.context = context;
        this.profileId = profileId;
    }

    @Override
    public int getCount() {
        return MAX_PAGE;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return InformationProfileDetailsFragment.newInstance(profileId);
            case 1:
                return InformationProfileDetailsFragment.newInstance(profileId);
            case 2:
                return InformationProfileDetailsFragment.newInstance(profileId);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.title_profile_details_page_information);
            case 1:
                return context.getString(R.string.title_profile_details_page_portfolio);
            case 2:
                return context.getString(R.string.title_profile_details_page_reviews);
            default:
                return null;
        }
    }
}
