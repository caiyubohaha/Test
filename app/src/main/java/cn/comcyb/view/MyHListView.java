package cn.comcyb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by user on 2016/10/27.
 */

public class MyHListView extends ListView {
    Context mcontext;
    public int mMaxOverDistance = 5;
    public MyHListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        initview();
    }
    public MyHListView(Context context) {
        super(context);
        mcontext = context;
        initview();
    }

    private void initview() {
         DisplayMetrics displayMetrics=mcontext.getResources().getDisplayMetrics();

        mMaxOverDistance = (int) (displayMetrics.density*mMaxOverDistance);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, 50, isTouchEvent);
    }
}
