package cn.comcyb.activity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

public class SVGActivity extends AppCompatActivity {
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        ButterKnife.bind(this);
        iv.setOnClickListener(v->((Animatable)iv.getDrawable()).start());
    }
}
