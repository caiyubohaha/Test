package cn.comcyb.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2016/11/15.
 */

public class MyImageView extends ImageView{
    public Paint paint;
    public MyImageView(Context context) {
        super(context);
        init();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        //paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
       // paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xx);

        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float width = this.getMeasuredWidth();
        float height = this.getMeasuredHeight();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(0,0,width,height,80,80,paint);
        }

        canvas.save();

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        //Bitmap bitmap = ((BitmapDrawable)getDrawable()).getBitmap();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(0,0,width/2,height/2,30,30,paint);
        }
        //canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
    }
}
