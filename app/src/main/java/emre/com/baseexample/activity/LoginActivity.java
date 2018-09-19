package emre.com.baseexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import emre.com.baseexample.R;
import emre.com.baseexample.base.BaseActivity;
import emre.com.baseexample.fragment.LoginFragment;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public class LoginActivity extends BaseActivity {

    public static LoginActivity instance;

    public static void start(Activity context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
        context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        instance = this;
    }

    @Override
    public void doBusiness() {
        openFragment(LoginFragment.newInstance(), false);
    }

    @Override
    public void onWidgetClick(View view) {

    }

    public void openFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.login_frame_layout, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
