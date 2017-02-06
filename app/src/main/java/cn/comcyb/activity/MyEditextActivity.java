package cn.comcyb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.comcyb.myclass.R;
import cn.comcyb.view.CopyEditext;

public class MyEditextActivity extends AppCompatActivity {
    @BindView(R.id.ev)
    CopyEditext ev;
    int type = 0;
    @BindView(R.id.eve)
    EditText eve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_editext);
        ButterKnife.bind(this);
       // Log.i("88882","getLeft"+ev.getX()+"getTop"+ev.getY()+"getRight"+(ev.getX()+ev.getWidth())+"getBottom"+(ev.getY()+ev.getHeight()));
        eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type==0){
                    ev.settype(1);
                    type=1;
                }else{
                    ev.settype(0);
                    type=0;
                }
            }
        });
    }
}
