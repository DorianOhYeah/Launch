package com.example.launch;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class LaunchImproveAdapter extends FragmentStatePagerAdapter {
    private int[] mImageArray; // the image array

    // put the image array and fragment manager
    public LaunchImproveAdapter(FragmentManager fm, int[] imageArray) {
        super(fm);
        mImageArray = imageArray;
    }

    // get the number of the image array
    public int getCount() {
        return mImageArray.length;
    }

    // get the specific fragment item
    public Fragment getItem(int position) {
        return LaunchFragment.newInstance(position, mImageArray[position]);
    }
}
