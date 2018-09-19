package emre.com.baseexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import emre.com.baseexample.R;
import emre.com.baseexample.base.BaseActivity;

/**
 * Created by Emre.Karatas on 19.09.2018.
 */

public class ProductDetailActivity extends BaseActivity {
    public int position;

    public static void start(Activity context, int position) {

        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    @Override
    public void initData(@Nullable Bundle bundle) {
        position = bundle.getInt("position");

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        TextView productName = findViewById(R.id.productName);
        TextView productDescription = findViewById(R.id.productDescription);

        productName.setText("Product: " + position);
        productDescription.setText("Desc: " + position);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
