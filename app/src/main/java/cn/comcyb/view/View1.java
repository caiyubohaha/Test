package cn.comcyb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/**
 * Created by user on 2016/8/19.
 */
public class View1 extends TextView {
    public View1(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }
}
