package net.jspiner.knowyourkid.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import net.jspiner.knowyourkid.R;


public class FixedRatioView extends FrameLayout {

    private int widthRatio = 1;
    private int heightRatio = 1;
    private int fixType = 1;

    public static final int FIX_TYPE_WIDTH = 1;
    public static final int FIX_TYPE_HEIGHT = 2;

    public FixedRatioView(Context context) {
        super(context);
    }

    public FixedRatioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FixedRatioView);

        this.widthRatio = typedArray.getInt(R.styleable.FixedRatioView_widthRatio, 1);
        this.heightRatio = typedArray.getInt(R.styleable.FixedRatioView_heightRatio, 1);
        this.fixType = typedArray.getInt(R.styleable.FixedRatioView_fixType, 1);

        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int originalHeight = MeasureSpec.getSize(heightMeasureSpec);

        float ratio;

        int resultWidth = originalWidth;
        int resultHeight = originalHeight;

        switch (fixType){
            case FIX_TYPE_WIDTH:
                ratio = (float)heightRatio / widthRatio;
                resultHeight = (int) (resultWidth * ratio);
                break;
            case FIX_TYPE_HEIGHT: // HEIGHT
                ratio = (float) widthRatio / heightRatio;
                resultWidth = (int) (resultHeight * ratio);
                break;
        }

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(resultWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(resultHeight, MeasureSpec.EXACTLY)
        );
    }

    public enum FixType {
        WIDTH,
        HEIGHT
    }
}
