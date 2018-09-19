package emre.com.baseexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import emre.com.baseexample.R;
import emre.com.baseexample.activity.LoginActivity;
import emre.com.baseexample.base.BaseFragment;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public class RegisterFragment extends BaseFragment {

    public static RegisterFragment newInstance() {
        RegisterFragment registerFragment = new RegisterFragment();

        return registerFragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        findViewById(R.id.register_button).setOnClickListener(this);

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()){
            case R.id.register_button:{
                LoginActivity.instance.openFragment(LoginFragment.newInstance(), false);
            }
        }
    }
}
