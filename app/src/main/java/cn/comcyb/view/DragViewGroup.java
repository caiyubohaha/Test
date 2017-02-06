package cn.comcyb.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by user on 2016/11/15.
 */

public class DragViewGroup extends FrameLayout{
    private ViewDragHelper mViewDragHelper;
    private View mMenuView;
    private View mMainView;
    private int mWidthLeft;
    private int mWidthRight;
    private Context mcontext;
    private int mwidth;

    public void setmMenuView(View view){
        mMenuView = view;
    }
    public void setmMainView(View view){
        mMainView = view;
    }
    private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView ==child;//开始检测触摸
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {

            if (left>-mWidthRight&&left<mWidthLeft){
                if (left>0){
                    mMenuView.layout(-mWidthLeft+left,0,left,getBottom());
                }else{
                    mMenuView.layout(mWidthRight+left,0,mwidth+mWidthRight+left,getBottom());
                }
                return left;
            }else if(left<-mWidthRight){
                return -mWidthRight;
            }else{
                return mWidthLeft;
            }
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            //停止后的操作
            if (mMainView.getLeft()<150&&mMainView.getLeft()>-150){
                mViewDragHelper.smoothSlideViewTo(mMainView,0,0);
            }else if(mMainView.getLeft()<-150){
                mViewDragHelper.smoothSlideViewTo(mMainView,-mWidthRight,0);
            }
            else{
                mViewDragHelper.smoothSlideViewTo(mMainView,mWidthLeft,0);
                //mViewDragHelper.smoothSlideViewTo(mMenuView,0,0);
                mMenuView.layout(0,0,mwidth,getBottom());
            }
            ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);


        }
    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
            return true;

    }

    public DragViewGroup(Context context) {
        super(context);
        mcontext = context;
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this,mCallback);
        DisplayMetrics metric=new DisplayMetrics();
         mwidth = mcontext.getResources().getDisplayMetrics().widthPixels;
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        init();
    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext = context;
        init();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

            if (mViewDragHelper.continueSettling(true)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidthLeft = ((ViewGroup)mMenuView).getChildAt(0).getMeasuredWidth();
        mWidthRight = ((ViewGroup)mMenuView).getChildAt(1).getMeasuredWidth();
    }
}
