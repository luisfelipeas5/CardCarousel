package br.com.madeinlabs.cardcarousel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public abstract class CarouselAdapter extends FragmentStatePagerAdapter {
    public CarouselAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return getCustomItem(position);
    }

    public abstract Fragment getCustomItem(int position);

    @Override
    public int getCount() {
        return getCustomCount();
    }

    public abstract int getCustomCount();
}
