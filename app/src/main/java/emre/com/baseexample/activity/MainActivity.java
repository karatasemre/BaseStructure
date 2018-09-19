package emre.com.baseexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import emre.com.baseexample.R;
import emre.com.baseexample.adapter.ProductAdapter;
import emre.com.baseexample.base.BaseActivity;
import emre.com.baseexample.model.Product;

public class MainActivity extends BaseActivity {

    public RecyclerView recyclerView;

    public static void start(Activity context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
        context.finish();
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {

        recyclerView = findViewById(R.id.recylerview);

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        recyclerView.setLayoutAnimation(animation);

        ProductAdapter productAdapter = new ProductAdapter(this, Product.getData());
        recyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
