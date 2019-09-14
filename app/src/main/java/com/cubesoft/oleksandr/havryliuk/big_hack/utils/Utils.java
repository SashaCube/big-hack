package com.cubesoft.oleksandr.havryliuk.big_hack.utils;

import androidx.fragment.app.FragmentManager;

import java.util.Random;

public class Utils {
    public static boolean isFragmentInBackstack(final FragmentManager fragmentManager,
                                                final String fragmentTagName) {
        for (int entry = 0; entry < fragmentManager.getBackStackEntryCount(); entry++) {
            if (fragmentTagName.equals(fragmentManager.getBackStackEntryAt(entry).getName())) {
                return true;
            }
        }
        return false;
    }

    public static int getRandom(int max) {
        Random random = new Random();
        return random.nextInt(max);

    }

    public interface LoadData<T> {

        void onData(T data);

        void onFailure();
    }
}