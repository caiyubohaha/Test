package cn.comcyb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;
import cn.comcyb.view.DragViewGroup;

public class Main6Activity extends AppCompatActivity {
    @BindView(R.id.main)
    LinearLayout Main;
    @BindView(R.id.menu)
    RelativeLayout menu;
    @BindView(R.id.dg)
    DragViewGroup dg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);
        dg.setmMainView(Main);
        dg.setmMenuView(menu);
    }
}
