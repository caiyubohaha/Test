package cn.comcyb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;
import cn.comcyb.view.ViewDraghelperLlout;


public class Main5Activity extends Activity {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.viewdraghelpllout)
    ViewDraghelperLlout vllout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);
        vllout.setmMainView(tv);
    }
}
