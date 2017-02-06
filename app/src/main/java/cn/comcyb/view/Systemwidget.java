package cn.comcyb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2016/9/7.
 */
public class Systemwidget extends View {
    float width;
    float height;
    float Criclexy;//圆心
    private float mRadius;//半径
    private RectF mArcRectF;//外矩形
    Paint paint;
    Context context;

    public Systemwidget(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        this.context = context;
    }
    public Systemwidget(Context context) {
        super(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Toast.makeText(context, getWidth()+"---"+getHeight(), Toast.LENGTH_SHORT).show();
        width = getWidth();
        height=getWidth();
        Toast.makeText(context, getWidth()+"---"+getHeight(), Toast.LENGTH_SHORT).show();
        Criclexy = width/2;
        mRadius = Criclexy/2;
        mArcRectF = new RectF(width*0.1f,width*0.1f,width*0.9f,width*0.9f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        canvas.drawCircle(Criclexy,Criclexy,mRadius,paint);
        paint.setColor(Color.GRAY);
        paint.setTextSize(25);
        paint.getTextBounds("你这个傻逼",0,1,rect);
        canvas.drawText("你这个傻逼",Criclexy- paint.measureText("你这个傻逼")/2,Criclexy+rect.height()/2,paint);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);//
        canvas.drawArc(mArcRectF,270,225,true,paint);

    }

    public void setr(float r){
        this.invalidate();
    }
}
