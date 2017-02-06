package cn.comcyb.activity;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

public class AnimationActivity extends Activity {
    @BindView(R.id.iv)
    ImageView iv;
    //@BindView(R.id.activity_main7)
    RelativeLayout rlout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);
        //iv = (ImageView) findViewById(R.id.iv);

        //视图动画（只影响视图，点击事件的响应还是原来的位置）
        /*透明度动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(5000);
        iv.startAnimation(alphaAnimation);*/
       /* 旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5F,RotateAnimation.RELATIVE_TO_SELF,0.5F);
        rotateAnimation.setDuration(5000);
        iv.startAnimation(rotateAnimation);*/
        /*位移动画（）
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,100);
        translateAnimation.setDuration(5000);
        iv.startAnimation(translateAnimation);*/
       /* 缩放动画
        ScaleAnimation scaleAnimation =  new ScaleAnimation(1,2,1,2,ScaleAnimation.RELATIVE_TO_SELF,0.5F,ScaleAnimation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setDuration(5000);
        iv.startAnimation(scaleAnimation);*/
        /*
        动画集合（优先集合动画时间）
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(5000);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5F,RotateAnimation.RELATIVE_TO_SELF,0.5F);
        rotateAnimation.setDuration(1000);
        ScaleAnimation scaleAnimation =  new ScaleAnimation(1,2,1,2,ScaleAnimation.RELATIVE_TO_SELF,0.5F,ScaleAnimation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setDuration(5000);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        //animationSet.setDuration(5000);
        iv.startAnimation(animationSet);*/

        /*ObjectAnimator objectAnimator = ObjectAnimator.ofInt(iv,"width",500);
        objectAnimator.setDuration(2000);
        objectAnimator.start();*/
        /*PropertyValuesHolder holderscalex = PropertyValuesHolder.ofFloat("scaleX",0f,1f);
        PropertyValuesHolder holderscaley = PropertyValuesHolder.ofFloat("scaleY",0f,1f);
        PropertyValuesHolder holdertranslationx = PropertyValuesHolder.ofFloat("x",0,300);
        PropertyValuesHolder holdertranslationy = PropertyValuesHolder.ofFloat("y",0,300);
        PropertyValuesHolder holderalpha = PropertyValuesHolder.ofFloat("alpha",0,1);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv,holderalpha,holderscalex,holderscaley,holdertranslationx,holdertranslationy);
        animator.setDuration(3000);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });*/
        /*ValueAnimator animator = ValueAnimator.ofFloat(0,100);
        animator.setTarget(iv);
        animator.setDuration(5000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                Log.i("8888",value+"");
            }
        });*/
       /* iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnimationActivity.this, "你是不是煞笔", Toast.LENGTH_SHORT).show();
                Animator animator = AnimatorInflater.loadAnimator(AnimationActivity.this,R.animator.scalexx);
                animator.setTarget(iv);
                animator.start();
            }
        });*/
        //AnimatorSet
        /*ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv,"scaleX",0,1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv,"scaleY",0,1);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(iv,"alpha",0,1);
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.setDuration(5000);
        animationSet.playTogether(scaleX,scaleY,alpha);
        animationSet.start();*/


        /*iv.animate().alpha(0).y(300).setDuration(3000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();*/
        //ObjectAnimator animator  = ObjectAnimator.ofFloat(iv,"translationY",0,400);
        /*Animator animator = AnimatorInflater.loadAnimator(this,R.animator.scalexx);
        animator.setTarget(iv);
        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(2000);
        animator.start();*/
       /* TranslateAnimation animation = new TranslateAnimation(0,100,0,300);
        animation.setDuration(1000);
        animation.setInterpolator(new BounceInterpolator());
        iv.startAnimation(animation);*/

       /* TranslateAnimation animation = new TranslateAnimation(0,0,0,300);
        animation.setDuration(1000);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation,0.5f);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        rlout.setLayoutAnimation(layoutAnimationController);*/
       /* final MyAnimation animation = new MyAnimation(45);
        animation.setDuration(2000);*/
        /*iv.startAnimation(animation);*/

        /*iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(animation);
            }
        });*/
      /*  iv.setOnClickListener(view -> iv.startAnimation(animation));*/
      /* Runnable runnable = ()-> Toast.makeText(this, "傻逼", Toast.LENGTH_SHORT).show();


       // Runnable a = ()-> Log.i("8888","asas");

        runnable = ()->{
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        };

        BinaryOperator<Long> add = (x,y)->x+y;
        String str =  "";*/
        /*iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = "a";
            }
        });*/
       /* iv.setOnClickListener(evnet->{
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        });

        Collections.synchronizedList(new ArrayList<>());*/
        /*Animation animation = AnimationUtils.loadAnimation(this,R.anim.scalexx);
        iv.startAnimation(animation);*/

        iv.setOnClickListener(v->((Animatable)iv.getDrawable()).start());

    }
}
