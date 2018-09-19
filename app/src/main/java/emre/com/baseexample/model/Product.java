package emre.com.baseexample.model;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

import java.util.ArrayList;

public class Product {

    private String productName;
    private String productDescription;

    public Product() {
    }

    public Product(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public static ArrayList<Product> getData() {
        ArrayList<Product> productList = new ArrayList<Product>();
        String[] productNames = {"Product 0", "Product 1", "Product 2", "Product 3", "Product 4", "Product 5", "Product 6",
                "Product 7", "Product 8", "Product 9", "Product 10", "Product 11", "Product 12", "Product 13"};

        for (int i = 0; i < 13; i++) {
            Product temp = new Product();
            temp.setProductName(productNames[i]);
            temp.setProductDescription("Desc " + i);

            productList.add(temp);
        }

        return productList;
    }
}