package cn.comcyb.secondmyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2017/1/4.
 */

public class TopBar extends RelativeLayout{

    private  Drawable rightBackground;
    private  Drawable leftBackground;
    private  int titleTextColor;
    private  int leftTextColor;
    private  int rightTextColor;
    private  float titleTextSize;
    private  float rightTextSize;
    private  float leftTextSize;
    private  String titleText;
    private String leftText;
    private String rightText;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView titleView;
    private LayoutParams mLeftParams;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, null,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        rightText = typedArray.getString(R.styleable.TopBar_rightText);
        leftText = typedArray.getString(R.styleable.TopBar_leftText);
        titleText = typedArray.getString(R.styleable.TopBar_Title);
        leftTextSize = typedArray.getDimension(R.styleable.TopBar_leftTextSize,10);
        rightTextSize = typedArray.getDimension(R.styleable.TopBar_rightTextSize,10);
        titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize,10);
        rightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor,0);
        leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor,0);

        leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        init(context);
        typedArray.recycle();
    }

    public void init(Context context){
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        titleView  = new TextView(context);

        titleView.setText(titleText);
        titleView.setTextColor(titleTextColor);
        titleView.setTextSize(titleTextSize);

        mLeftButton.setTextColor(leftTextColor);
        mLeftButton.setText(leftText);
        mLeftButton.setTextSize(leftTextSize);
        mLeftButton.setBackground(leftBackground);

        mRightButton.setTextColor(rightTextColor);
        mRightButton.setText(rightText);
        mRightButton.setTextSize(rightTextSize);
        mRightButton.setBackground(rightBackground);

        mLeftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        addView(mLeftButton,mLeftParams);


    }



}
