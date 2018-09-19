package emre.com.baseexample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import emre.com.baseexample.R;
import emre.com.baseexample.base.BaseActivity;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {

    }

    @Override
    public void doBusiness() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity.start(SplashActivity.this);
                finish();
            }
        }, 2000);
    }

    @Override
    public void onWidgetClick(View view) {

    }
}
