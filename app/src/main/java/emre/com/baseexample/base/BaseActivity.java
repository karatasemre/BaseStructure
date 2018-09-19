package emre.com.baseexample.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected Activity mActivity;
    protected View mContentView;

    private long lastClick = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        getSupportActionBar().hide();
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        setBaseView(bindLayout());
        initView(savedInstanceState, mContentView);
        doBusiness();
    }

    protected void setBaseView(@LayoutRes int layoutId) {
        if (layoutId <= 0) {
            return;
        }
        setContentView(mContentView = LayoutInflater.from(this).inflate(layoutId, null));
    }

    private boolean isFastClick() {
        long now = System.currentTimeMillis();

        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(isFastClick()){
            onWidgetClick(v);
        }
    }
}
