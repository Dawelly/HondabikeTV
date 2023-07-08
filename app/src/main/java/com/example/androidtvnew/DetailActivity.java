package com.example.androidtvnew;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.example.androidtvnew.utils.Constants;

public class DetailActivity extends FragmentActivity {

    private ImageView imgBanner;
    private TextView title;
    private TextView language;
    private TextView description;
    private TextView viewMore;
    private Boolean isViewMore = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        imgBanner = (ImageView) findViewById(R.id.img_banner);
        title = (TextView) findViewById(R.id.title);
        language = (TextView) findViewById(R.id.language);
        description = (TextView) findViewById(R.id.description);
        viewMore = (TextView) findViewById(R.id.view_more);



        Bundle bundle = getIntent().getExtras();

        viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isViewMore = !isViewMore;
                if (isViewMore) {
                    description.setMaxLines(3);
                    viewMore.setText("View More Information");
                    viewMore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_more, 0, 0, 0);
                } else {
                    description.setMaxLines(100);
                    viewMore.setText("View Less Information");
                    viewMore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_less, 0, 0, 0);
                }

            }
        });

        getDetails(bundle);
    }

    private void getDetails(Bundle bundle) {
        Constants constant = new Constants();

        getImgBanner(bundle, constant);
        title.setText(bundle.getString(constant.TITLE));
        language.setText(bundle.getString(constant.LANGUAGE));
        description.setText(bundle.getString(constant.DESCRIPTION));
    }

    private void getImgBanner(Bundle bundle, Constants constant) {
        String url = bundle.getString(constant.BACKDROP);
        Glide.with(this)
                .load(url)
                .into(imgBanner);
    }
}