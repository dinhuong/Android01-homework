package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ScrollView scrollView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.ll_linear_in_scroll);
        scrollView = findViewById(R.id.scroll);
        fab = findViewById(R.id.fb_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.addView(createImageView(MainActivity.this));
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }

    private CustomView createImageView(Context context) {
        CustomView imageView = new CustomView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(randomImage());

        return imageView;
    }

    private int randomImage() {
        Random random = new Random();
        int numImage = random.nextInt(5) + 1;
        switch (numImage) {
            case 1:
                return R.drawable.food_1;
            case 2:
                return R.drawable.food_2;
            case 3:
                return R.drawable.food_3;
            case 4:
                return R.drawable.food_4;
            case 5:
                return R.drawable.food_5;
        }
        return 0;
    }
}
