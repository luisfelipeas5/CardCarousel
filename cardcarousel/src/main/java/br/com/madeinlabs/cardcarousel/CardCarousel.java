package br.com.madeinlabs.cardcarousel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class CardCarousel extends ViewPager {
    public CardCarousel(Context context) {
        super(context);
        init();
    }

    public CardCarousel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageMargin(-300);
        setPageTransformer(false, new CarouserPageTransformer());
        setOffscreenPageLimit(2);
    }

    private class CarouserPageTransformer implements PageTransformer {
        private static final float MIN_SCALE = 0.85f;

        @Override
        public void transformPage(View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();

            if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
                float horizontalMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    page.setTranslationX(horizontalMargin - verticalMargin / 2);
                } else {
                    page.setTranslationX(-horizontalMargin + verticalMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            }

        }
    }
}
