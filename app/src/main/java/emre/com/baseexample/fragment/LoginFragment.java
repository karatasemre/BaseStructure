package emre.com.baseexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import emre.com.baseexample.R;
import emre.com.baseexample.activity.LoginActivity;
import emre.com.baseexample.activity.MainActivity;
import emre.com.baseexample.base.BaseFragment;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public class LoginFragment extends BaseFragment {

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();

        return loginFragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        findViewById(R.id.login_button).setOnClickListener(this);
        findViewById(R.id.register_now).setOnClickListener(this);

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()){
            case R.id.login_button:{
                MainActivity.start(getActivity());
            }
            case R.id.register_now:{
                LoginActivity.instance.openFragment(RegisterFragment.newInstance(), true);
            }
        }
    }
}
