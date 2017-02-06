package cn.comcyb.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by user on 2016/11/5.
 */

public class ViewDraghelperLlout extends LinearLayout{
    ViewDragHelper mViewDraghelper;
    View mMainView;
    View mMenuView;
    private int mWidth;

    public void setmMainView(View view){
        mMainView = view;
    }
    ViewDragHelper.Callback mcallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if (mMainView.getLeft()<500){
                mViewDraghelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(ViewDraghelperLlout.this);
            }else{
                mViewDraghelper.smoothSlideViewTo(mMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(ViewDraghelperLlout.this);
            }
        }
    };
    public ViewDraghelperLlout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mViewDraghelper = ViewDragHelper.create(this,mcallback);

    }
    public ViewDraghelperLlout(Context context) {
        super(context);
        mViewDraghelper = ViewDragHelper.create(this,mcallback);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDraghelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDraghelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public void computeScroll() {
        if (mViewDraghelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
/*
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();
    }*/
}
