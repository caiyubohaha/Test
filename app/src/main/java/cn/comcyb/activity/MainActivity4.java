package cn.comcyb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.widget.LinearLayout;

import cn.comcyb.myclass.R;

public class MainActivity4 extends Activity {
    LinearLayout llout;
    ViewDragHelper mViewdragHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        llout = (LinearLayout) findViewById(R.id.activity_main4);
        //mViewdragHelper = ViewDragHelper.create(llout,this);




    }
}
