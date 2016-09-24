package br.com.madeinlabs.cardcarouseltest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.LinkedList;
import java.util.List;

import br.com.madeinlabs.cardcarousel.CarouselAdapter;

class CustomCarouselAdapter extends CarouselAdapter {
    private List<String> mTitles;
    private List<Integer> mResources;

    CustomCarouselAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mTitles = new LinkedList<>();
        mResources = new LinkedList<>();
    }

    public Fragment getCustomItem(int position) {
        String title = mTitles.get(position);
        int coverResource = mResources.get(position);
        return CardFragment.newInstance(title, coverResource);
    }

    public int getCustomCount() {
        return mTitles.size();
    }

    void add(String title, int coverResource) {
        mTitles.add(title);
        mResources.add(coverResource);
    }
}
