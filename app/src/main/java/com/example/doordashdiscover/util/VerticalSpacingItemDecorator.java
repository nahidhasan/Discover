package com.example.doordashdiscover.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpacingItemDecorator extends RecyclerView.ItemDecoration {
    private final int verticalHeightSpacing;

    public VerticalSpacingItemDecorator(int verticalHeightSpacing) {
        this.verticalHeightSpacing = verticalHeightSpacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = verticalHeightSpacing;
    }
}
