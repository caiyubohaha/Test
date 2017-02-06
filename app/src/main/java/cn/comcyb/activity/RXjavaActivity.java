package cn.comcyb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import cn.comcyb.myclass.R;
import rx.Observable;
import rx.Subscriber;

public class RXjavaActivity extends AppCompatActivity {
    Observable<String> observable=null;
    Subscriber<String> subscriber=null;
    @BindView(R.id.iv)
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

      /* observable = Observable.create(
                new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(getResources().getString(R.string.al));
                subscriber.onCompleted();
            }
        });


         subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(RXjavaActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };

        Subscriber<String> sub = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        Observable<String> obs = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("s");
                subscriber.onCompleted();
            }
        });
        obs.subscribe(sub);*/
        //observable.subscribe(subscriber);

    }


    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "大傻逼", Toast.LENGTH_SHORT).show();
        //observable.subscribe(subscriber);
       /* Observable.just(getResources().getString(R.string.al)).map(s -> getResources().getString(R.string.ni)+s).subscribe(s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });*/



    }
}
