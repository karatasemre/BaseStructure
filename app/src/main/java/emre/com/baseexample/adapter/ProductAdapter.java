package emre.com.baseexample.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import emre.com.baseexample.R;
import emre.com.baseexample.activity.ProductDetailActivity;
import emre.com.baseexample.model.Product;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<Product> mProductList;
    LayoutInflater inflater;
    public Activity mActivity;

    public ProductAdapter(Activity mActivity, ArrayList<Product> products) {
        inflater = LayoutInflater.from(mActivity);
        this.mProductList = products;
        this.mActivity = mActivity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName, productDescription;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productDescription = itemView.findViewById(R.id.productDescription);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(this);
        }

        public void setData(Product selectedProduct, int position) {

            this.productName.setText(selectedProduct.getProductName());
            this.productDescription.setText(selectedProduct.getProductDescription());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cardView: {

                    ProductDetailActivity.start(mActivity, getAdapterPosition());
                }
            }
        }
    }
}