package cn.comcyb.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import cn.comcyb.myclass.R;

/**
 * Created by user on 2016/12/14.
 */

public class CopyEditext extends EditText {
    public Context mcontext;

    public int type = EDITE;

    public static final int SHOW=0;
    public static final int EDITE=1;


    public CopyEditext(Context context) {
        super(context);
        init();
        mcontext = context;
    }

    public CopyEditext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        mcontext = context;
    }

    public CopyEditext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        mcontext = context;
    }
    public  void init(){
       switch (type){
           case SHOW:
               setFocusable(false);
               this.setBackgroundResource(R.drawable.oa_editext_show_shape);
               this.setOnLongClickListener(new OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View view) {
                       View copytext = LayoutInflater.from(mcontext).inflate(R.layout.copy_editext, null);
                       PopupWindow popupWindow = new PopupWindow(copytext, 100, 50);
                       popupWindow.setOutsideTouchable(true);
                       popupWindow.setFocusable(true);
                       popupWindow.showAsDropDown(CopyEditext.this);
                       copytext.setOnClickListener(new OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               copyText();
                               popupWindow.dismiss();
                           }
                       });
                       return true;
                   }
               });
               break;
           case EDITE:
               this.setFocusable(true);
               this.setFocusableInTouchMode(true);
               this.requestFocus();
               this.requestFocusFromTouch();

               this.setBackgroundResource(R.drawable.oa_editext_edit_shape);
               this.setOnLongClickListener(new OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View view) {
                       return false;
                   }
               });
               break;
           default:break;
       }
    }

    public void copyText(){
        String s = this.getText().toString();
        ClipboardManager clip = (ClipboardManager)mcontext.getSystemService(Context.CLIPBOARD_SERVICE);
        clip.setText(s);
    }

    public void settype(int type){
        CopyEditext.this.type = type;
        init();
    }

}
