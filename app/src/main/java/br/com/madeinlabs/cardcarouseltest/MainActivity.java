package br.com.madeinlabs.cardcarouseltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.madeinlabs.cardcarousel.CardCarousel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomCarouselAdapter carouselPagerAdapter = new CustomCarouselAdapter(getSupportFragmentManager());
        carouselPagerAdapter.add("Black", R.color.black);
        carouselPagerAdapter.add("Yellow", R.color.yellow);
        carouselPagerAdapter.add("Black", R.color.black);
        carouselPagerAdapter.add("Yellow", R.color.yellow);

        CardCarousel cardCarousel = (CardCarousel) findViewById(R.id.card_carousel);
        cardCarousel.setAdapter(carouselPagerAdapter);
    }
}
