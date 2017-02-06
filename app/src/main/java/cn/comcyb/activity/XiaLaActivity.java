package cn.comcyb.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

public class XiaLaActivity extends AppCompatActivity {

    @BindView(R.id.app_icon)
    ImageView appIcon;
    @BindView(R.id.hidden_view)
    LinearLayout hiddenView;
    @BindView(R.id.activity_xia_la)
    LinearLayout activityXiaLa;
    private float mDensity;
    private int mHiddenViewMeasuredHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xia_la);
        ButterKnife.bind(this);
        mDensity = getResources().getDisplayMetrics().density;
        mHiddenViewMeasuredHeight = (int)(mDensity*80+0.5);

    }

    public void llClick(View v){
        if (hiddenView.getVisibility()==View.GONE){
            open(hiddenView);
        }else{
            close(hiddenView);
        }
    }
    /****/
    private void open(LinearLayout hiddenView) {
        hiddenView.setVisibility(View.VISIBLE);
        ValueAnimator animator = ValueAnimator.ofInt(0,mHiddenViewMeasuredHeight);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutparams = (LinearLayout.LayoutParams) hiddenView.getLayoutParams();
                layoutparams.height= (int) valueAnimator.getAnimatedValue();
                hiddenView.setLayoutParams(layoutparams);
            }
        });
        animator.start();
    }


    /****/
    private void close(LinearLayout hiddenView) {
        ValueAnimator animator = ValueAnimator.ofInt(mHiddenViewMeasuredHeight,0);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutparams = (LinearLayout.LayoutParams) hiddenView.getLayoutParams();
                layoutparams.height= (int) valueAnimator.getAnimatedValue();
                hiddenView.setLayoutParams(layoutparams);
                if((int)valueAnimator.getAnimatedValue()==0){
                    hiddenView.setVisibility(View.GONE);
                }
            }
        });
        animator.start();
    }
}
