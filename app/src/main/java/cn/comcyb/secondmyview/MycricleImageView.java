package cn.comcyb.secondmyview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2017/1/3.
 */

public class MycricleImageView extends View {
    Paint paint;
    Bitmap bitmap1;
    Bitmap bitmap2;
    Canvas mcanvas;

    public MycricleImageView(Context context) {
        this(context,null);
    }

    public MycricleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MycricleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        init();
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
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }
    /**测量高度**/
    private int measureHeight(int heightMeasureSpec) {
        int result = 0 ;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;//如果是精确值模式直接返回原来的高度
        }else{
            result=200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
    /**
     *测量宽度
     */
    private int measureWidth(int widthMeasureSpec) {
        int result = 0 ;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;//如果是精确值模式直接返回原来的高度
        }else{
            result=200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width  = getWidth();
        float height = getHeight();
        Rect rect = new Rect(0,0,200,200);
        Rect rect2 =  new Rect(0,0,bitmap1.getWidth(),bitmap1.getHeight());

       canvas.drawBitmap(bitmap1,rect2,rect,paint);
        mcanvas = new Canvas(bitmap1);
        mcanvas.drawLine(0,0,200,200,paint);



    }
}
