package by.orion.onlinertasks.common.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

public class FragmentUtils {

    public static void replaceFragment(@NonNull Fragment fragment, @NonNull FragmentManager manager, @IdRes int containerId, @Nullable String backstackName) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment);

        if (!TextUtils.isEmpty(backstackName))
            transaction.addToBackStack(backstackName);

        transaction.commit();
    }

    public static void addFragment(@NonNull Fragment fragment, @NonNull FragmentManager manager, @IdRes int containerId, @Nullable String backstackName) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment);

        if (!TextUtils.isEmpty(backstackName))
            transaction.addToBackStack(null);

        transaction.commit();
    }

    public static void remoteFragment(@NonNull Fragment fragment, @NonNull FragmentManager manager) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
