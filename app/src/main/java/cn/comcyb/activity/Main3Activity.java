package cn.comcyb.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

/**
 * listview常用拓展,butterknife基础使用
 */
public class Main3Activity extends AppCompatActivity {
    @BindView(R.id.lv)
    ListView lv;
   /* @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;*/
    private int mTopchSlop;
    private float mcurrenty;
    private Animator mAnimator;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        initView();
    }





    public void initView() {
        /*tv.setText("ButterKnife测试");
        tv2.setText("ButterKnife测试2");
        tv3.setText("ButterKnife测试3");*/

        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            strs.add(i+"");
        }
        View headView = LayoutInflater.from(this).inflate(R.layout.lv_head_layout,null);
        headView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));
        lv.addHeaderView(headView);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strs);
        lv.setAdapter(adapter);
        lv.setOnTouchListener(listviewonTouchlistener);
        mTopchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
    }

    /*@OnClick({R.id.tv_2, R.id.tv_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_2:
                tv2.setText("2");
                break;
            case R.id.tv_3:
                tv3.setText("3");
                break;
        }
    }*/


    private float mfirsty;
    private int direction;
    private boolean mShow;
    View.OnTouchListener listviewonTouchlistener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mfirsty = motionEvent.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mcurrenty = motionEvent.getY();
                    if(mcurrenty-mfirsty>mTopchSlop){
                        direction = 0;//往下
                    }else if(mfirsty-mcurrenty>mTopchSlop){
                        direction = 1;//上
                    }

                    if (direction==1){
                        if (mShow){
                            toolbarAnim(1);//show
                            mShow=!mShow;
                        }
                    }else if(direction==0){
                        if (!mShow){
                        toolbarAnim(0);
                        mShow=!mShow;
                        }
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            return false;
        }
    };
    /****/
    private void toolbarAnim(int i) {
        if (mAnimator!=null&&mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        switch(i){
            case 0:
                mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),0);
                break;
            case 1:
                mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),-mToolbar.getHeight());
                break;
        }
        mAnimator.start();

    }


}
