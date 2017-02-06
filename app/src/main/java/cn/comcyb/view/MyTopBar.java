package cn.comcyb.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2016/9/5.
 */
public class MyTopBar extends RelativeLayout{
    LayoutParams mTitleLayoutParams;
    LayoutParams mRightLayoutParams;
    LayoutParams mLeftLayoutParams;
    float MyTopBar_titletextsize;
    Drawable MyTopBar_drawableright;
    String MyTopBar_textright;
    String MyTopBar_textleft;
    int MyTopBar_titletextcolor;
    String MyTopBar_titletext;
    Drawable MyTopBar_drawableleft;
    Button mLeftButton;
    Button mRightButton;
    TextView mTitleTextView;
    CallBackListener mlistener;


    public MyTopBar(Context context) {
        super(context);
    }

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyTopBar);
        MyTopBar_titletextcolor= ta.getColor(R.styleable.MyTopBar_titletextcolor,0);
        MyTopBar_textleft =  ta.getString(R.styleable.MyTopBar_textleft);
        MyTopBar_titletext =  ta.getString(R.styleable.MyTopBar_titletext);
        MyTopBar_textright =  ta.getString(R.styleable.MyTopBar_textright);
        MyTopBar_drawableleft = ta.getDrawable(R.styleable.MyTopBar_drawableleft);
        MyTopBar_drawableright = ta.getDrawable(R.styleable.MyTopBar_drawableright);
        MyTopBar_titletextsize = ta.getDimension(R.styleable.MyTopBar_titletextsize,10);
        ta.recycle();
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleTextView = new TextView(context);
        mLeftButton.setText(MyTopBar_textleft);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLeftButton.setBackground(MyTopBar_drawableleft);
            mRightButton.setBackground(MyTopBar_drawableright);
        }
        mRightButton.setText(MyTopBar_textright);
        mTitleTextView.setText(MyTopBar_titletext);
        mTitleTextView.setTextColor(MyTopBar_titletextcolor);
        mTitleTextView.setTextSize(MyTopBar_titletextsize);

       mLeftLayoutParams =  new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
       mLeftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftLayoutParams);
        mRightLayoutParams =  new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightLayoutParams);
        mTitleLayoutParams =  new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        mTitleTextView.setGravity(Gravity.CENTER);
        addView(mTitleTextView,mTitleLayoutParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlistener!=null){
                    mlistener.leftListener(v);
                }
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlistener!=null){
                    mlistener.rightListener(v);
                }
            }
        });

    }
    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface CallBackListener{
        void leftListener(View v);
        void rightListener(View v);
    }


    public void setOnClickListener(CallBackListener listener){
        this.mlistener = listener;
    }


}
