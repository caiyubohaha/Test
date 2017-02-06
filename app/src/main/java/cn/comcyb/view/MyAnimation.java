package cn.comcyb.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * Created by user on 2016/11/25.
 */

public class MyAnimation extends Animation {
    int x;int y;
    int mRotateY;
    Camera mCamera ;
    public MyAnimation(int Rotatey) {
        this.x=x;
        this.y=y;
        mRotateY = Rotatey;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        /*final Matrix matrix = t.getMatrix();
        matrix.preScale(1,1-interpolatedTime,x,y);*/
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(mRotateY*interpolatedTime);
        mCamera.getMatrix(matrix);
        mCamera.restore();

       /* matrix.preTranslate(x,y);
        matrix.postTranslate(-x,-y);*/
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(2000);
        setFillAfter(true);
        setInterpolator(new BounceInterpolator());
        x = width/2;
        y = height/2;
        mCamera = new Camera();
    }
}
