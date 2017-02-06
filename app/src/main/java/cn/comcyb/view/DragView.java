package cn.comcyb.view;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by user on 2016/10/27.
 */

public class DragView extends TextView {

    private int lastY;
    private int lastX;
    private Context mcontext;
    private Scroller mScroller;
    private ViewDragHelper mViewDragHelper;

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        mScroller = new Scroller(mcontext);
        //mViewDragHelper = create((ViewGroup) getParent(),this);
    }
    public DragView(Context context) {
        super(context);
        mcontext = context;
        mScroller = new Scroller(mcontext);
       // mViewDragHelper = create((ViewGroup) getParent(),this);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
       /* int x = (int) event.getX();
        int y = (int) event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                Log.i("8888",1111111+"");
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX =x-lastX;
                int offsetY =y-lastY;
                //layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                *//*offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);*//*
               *//* LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft()+offsetX;
                layoutParams.topMargin = getTop()+offsetY;
                setLayoutParams(layoutParams);*//*
                *//*ViewGroup.MarginLayoutParams layoutParams= (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft()+offsetX;
                layoutParams.topMargin = getTop()+offsetY;
                setLayoutParams(layoutParams);*//*
                ((View)getParent()).scrollBy(-offsetX,-offsetY);

                Log.i("8888",222222+"");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("8888",333333333+"");
                View viewgroup = (View) getParent();
                mScroller.startScroll(viewgroup.getScrollX(),viewgroup.getScrollY(),-viewgroup.getScrollX(),-viewgroup.getScrollY(),10000);
                invalidate();
                break;
        }
        return true;*/
        //mViewDragHelper.processTouchEvent(event);

        return true;
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /*@Override
    public boolean tryCaptureView(View child, int pointerId) {
        return false;
    }*/


}
