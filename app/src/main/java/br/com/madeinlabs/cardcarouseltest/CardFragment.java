package br.com.madeinlabs.cardcarouseltest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_TITLE = "title";
    private static final String ARG_PARAM_COVER = "coverResource";

    private String mTitle;
    private int mCoverResource;

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance(String title, int coverResource) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_TITLE, title);
        args.putInt(ARG_PARAM_COVER, coverResource);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PARAM_TITLE);
            mCoverResource = getArguments().getInt(ARG_PARAM_COVER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_card, container, false);

        TextView txtTitle = (TextView) root.findViewById(R.id.txt_title);
        txtTitle.setText(mTitle);

        ImageView imgCover = (ImageView) root.findViewById(R.id.img_cover);
        imgCover.setImageResource(mCoverResource);

        return root;
    }

}
