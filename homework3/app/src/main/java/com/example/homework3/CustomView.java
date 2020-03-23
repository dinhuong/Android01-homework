package com.example.homework3;

import android.content.Context;
import android.view.View;

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width/2;
        setMeasuredDimension(width,height);
    }
}
