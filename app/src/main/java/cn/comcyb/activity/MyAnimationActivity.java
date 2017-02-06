package cn.comcyb.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

public class MyAnimationActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_boom)
    ImageView ivBoom;
    @BindView(R.id.activity_my_animation)
    RelativeLayout activityMyAnimation;
    public boolean isclose = true;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animation);
        ButterKnife.bind(this);


       /*iv.setOnClickListener(view -> {
           if (isclose){
               startAnimation();
           }else{
               closeAnimation();
           }
       });
        ivLeft.setOnClickListener(view -> Toast.makeText(this, "вС", Toast.LENGTH_SHORT).show());
        ivTop.setOnClickListener(view -> Toast.makeText(this, "ио", Toast.LENGTH_SHORT).show());
        ivRight.setOnClickListener(view -> Toast.makeText(this, "ср", Toast.LENGTH_SHORT).show());
        ivBoom.setOnClickListener(view -> Toast.makeText(this, "об", Toast.LENGTH_SHORT).show());*/
        /*iv.setOnClickListener(view -> tvTimer(tv));*/

    }


    private void startAnimation() {
        ObjectAnimator animatorCenter = ObjectAnimator.ofFloat(iv, "alpha", 1F, 0.5F);
        ObjectAnimator animatorCenter2 = ObjectAnimator.ofFloat(iv, "rotation", 0, 360);

        //animatorCenter.setDuration(1000);
        // animatorCenter.start();

        ObjectAnimator animatorleft = ObjectAnimator.ofFloat(ivLeft, "translationX", -200);
        ObjectAnimator animatorleft2 = ObjectAnimator.ofFloat(ivLeft, "rotation", 0, 360);
        //animatorleft.setDuration(1000);
        //animatorleft.start();

        ObjectAnimator animatortop = ObjectAnimator.ofFloat(ivTop, "translationY", -200);
        ObjectAnimator animatortop2 = ObjectAnimator.ofFloat(ivTop, "rotation", 0, 360);
        //animatortop.setDuration(1000);
        //animatortop.start();

        ObjectAnimator animatorright = ObjectAnimator.ofFloat(ivRight, "TranslationX", 200);
        ObjectAnimator animatorright2 = ObjectAnimator.ofFloat(ivRight, "rotation", 0, 360);
        animatorright.setDuration(1000);
        //animatorright.start();

        ObjectAnimator animatorboom = ObjectAnimator.ofFloat(ivBoom, "TranslationY", 200);
        ObjectAnimator animatorboom2 = ObjectAnimator.ofFloat(ivBoom, "rotation", 0, 360);
        //animatorboom.setDuration(1000);
        // animatorboom.start();
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animatorCenter, animatorleft, animatortop, animatorright, animatorboom,
                animatorCenter2, animatorleft2, animatortop2, animatorright2, animatorboom2);
        set.start();
        isclose = !isclose;
    }

    private void closeAnimation() {
        ObjectAnimator animatorCenter = ObjectAnimator.ofFloat(iv, "alpha", 0.5F, 1F);
        //animatorCenter.setDuration(1000);
        // animatorCenter.start();

        ObjectAnimator animatorleft = ObjectAnimator.ofFloat(ivLeft, "translationX", 0);
        //animatorleft.setDuration(1000);
        //animatorleft.start();

        ObjectAnimator animatortop = ObjectAnimator.ofFloat(ivTop, "translationY", 0);
        //animatortop.setDuration(1000);
        //animatortop.start();

        ObjectAnimator animatorright = ObjectAnimator.ofFloat(ivRight, "TranslationX", 0);
        animatorright.setDuration(1000);
        //animatorright.start();

        ObjectAnimator animatorboom = ObjectAnimator.ofFloat(ivBoom, "TranslationY", 0);
        //animatorboom.setDuration(1000);
        // animatorboom.start();
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animatorCenter, animatorleft, animatortop, animatorright, animatorboom);
        set.start();
        isclose = !isclose;
    }

    public void tvTimer(final TextView tv){
        ValueAnimator valueanimator = ValueAnimator.ofInt(0,10);
        valueanimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                tv.setText("$"+(Integer)valueAnimator.getAnimatedValue());
            }
        });
        valueanimator.setDuration(10000);
        //valueanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueanimator.start();
    }

}
