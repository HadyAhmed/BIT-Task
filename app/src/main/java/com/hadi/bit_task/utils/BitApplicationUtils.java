package com.hadi.bit_task.utils;

import android.content.Context;
import android.view.ViewTreeObserver;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hadi.bit_task.R;

public class BitApplicationUtils {
    public static void setUpRecyclerViewLayoutManager(final Context context, final RecyclerView recyclerView, final GridLayoutManager gridLayoutManager) {
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        int viewWidth = recyclerView.getWidth();
                        float movieCardWidth = context.getResources().getDimension(R.dimen.img_dimen);
                        int newSpanCount = (int) Math.floor(viewWidth / movieCardWidth);
                        gridLayoutManager.setSpanCount(newSpanCount);
                        gridLayoutManager.requestLayout();
                    }
                }
        );
    }
}
