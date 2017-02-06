package cn.comcyb.activity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;

public class SearchSVGActivity extends AppCompatActivity {
    @BindView(R.id.iv)
    EditText iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_svg);
        ButterKnife.bind(this);
        iv.setOnClickListener(v->{((Animatable)iv.getBackground()).start();});


    }
}
