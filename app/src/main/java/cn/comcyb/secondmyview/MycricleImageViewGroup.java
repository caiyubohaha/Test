package cn.comcyb.secondmyview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2017/1/3.
 */

public class MycricleImageViewGroup extends ViewGroup {
    Paint paint;
    Bitmap bitmap1;
    Bitmap bitmap2;
    Canvas mcanvas;

    public MycricleImageViewGroup(Context context) {
        this(context,null);
    }

    public MycricleImageViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MycricleImageViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

            View  view = getChildAt(0);
view.layout(0,0,200,100);



    }

    private void init() {
         bitmap1 = ((BitmapDrawable)(getResources().getDrawable(R.drawable.a8title))).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
         bitmap2 = ((BitmapDrawable)(getResources().getDrawable(R.drawable.xx))).getBitmap();
    }


    public void initPaint(){
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //setMeasuredDimension(400,200);
        /*measureChildren(widthMeasureSpec,heightMeasureSpec);
        int height = 0;
        int width=0;
        int count = getChildCount();
        for (int i=0;i<count;i++){
            height+=getChildAt(i).getMeasuredHeight();
            width = getChildAt(i).getMeasuredWidth();
        }
        setMeasuredDimension(width,height);*/
        int count = getChildCount();
        for (int i=0;i<count;i++){
            View view = getChildAt(i);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
        }
    }

   /* *//**测量高度**//*
    private int measureHeight(int heightMeasureSpec) {
        int childCount =  getChildCount();
        int result = 0 ;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;//如果是精确值模式直接返回原来的高度
        }else{
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = 0;
                for (int i = 0; i < childCount; i++) {
                    View view = getChildAt(i);
                    result += view.getHeight();
                }
            }

        }
        return result;
    }
    *//**
     *测量宽度
     *//*
    private int measureWidth(int widthMeasureSpec) {
        int childCount = getChildCount();
        int result = 0 ;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;//如果是精确值模式直接返回原来的高度
        }else{
            result=200;
            if (specMode == MeasureSpec.AT_MOST){
                result = 0;
                for (int i = 0; i < childCount; i++) {
                    View view = getChildAt(i);
                    if (view.getWidth()>result) result = view.getWidth();
                }
            }
        }
        return result;
    }*/

}
