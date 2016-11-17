package com.mobileDev.weddingApp.newweddingapp;


        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import at.technikum.mti.fancycoverflow.FancyCoverFlow;
        import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;

public class FancyCoverFlowSampleAdapter extends FancyCoverFlowAdapter {

    // =============================================================================
    // Private members
    // =============================================================================

    private int[] images = {R.mipmap.prewedding_1, R.mipmap.prewedding_2, R.mipmap.prewedding_3, R.mipmap.prewedding_4, R.mipmap.prewedding_5, R.mipmap.prewedding_6};

    // =============================================================================
    // Supertype overrides
    // =============================================================================

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Integer getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
        ImageView imageView = null;

        if (reuseableView != null) {
            imageView = (ImageView) reuseableView;
        } else {
            imageView = new ImageView(viewGroup.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setLayoutParams(new FancyCoverFlow.LayoutParams(880, 730));

        }

        imageView.setImageResource(this.getItem(i));
        return imageView;
    }
}
