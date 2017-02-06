package cn.comcyb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cn.comcyb.myclass.R;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout srl;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> lists  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lists.add("2");
        listView = (ListView) this.findViewById(R.id.lv);
        srl = (SwipeRefreshLayout) this.findViewById(R.id.srl);
       /* arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lists);*/
        listView.setAdapter(arrayAdapter);
        srl.setOnRefreshListener(this);
        /*MyTopBar bar = (MyTopBar) this.findViewById(R.id.mytopbar);
        bar.setOnClickListener(new MyTopBar.CallBackListener() {
            @Override
            public void leftListener(View v) {
                Toast.makeText(MainActivity.this, "臭傻逼点击了左边", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightListener(View v) {
                Toast.makeText(MainActivity.this, "臭傻逼点击了右边", Toast.LENGTH_SHORT).show();
            }
        });*/

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
        /*listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });*/
    }
    /**下拉刷新**/
    @Override
    public void onRefresh() {
        lists.add((lists.size()+1)+"");
        arrayAdapter.notifyDataSetChanged();
        srl.setRefreshing(false);
    }
}
