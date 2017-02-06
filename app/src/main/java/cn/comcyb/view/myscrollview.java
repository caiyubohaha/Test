package cn.comcyb.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2016/10/10.
 */

public class myscrollview extends ViewGroup {
    int ScreenHeight;
    public myscrollview(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i=0;i<count;i++){
            View childview = getChildAt(i);
            measureChild(childview,widthMeasureSpec,heightMeasureSpec);
            ScreenHeight =getHeight();
        }


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = getHeight()*getChildCount();
        setLayoutParams(mlp);
        for (int i=0;i<getChildCount();i++){
            View childview = getChildAt(i);
            if (childview.getVisibility()!=View.GONE){
                childview.layout(1,i*ScreenHeight,r,(i+1)*ScreenHeight);
            }
        }
    }
}
