package org.hit.repository;

import org.hit.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

   ArrayList<Product> listProduct=new ArrayList<>();



    @Override
    public Product addProduct(Product product) {
        if (listProduct.contains(product)){
            return null;
        }
        listProduct.add(product);
        return product;

    }

    @Override
    public Product updateProduct(Product product) {
        int index=listProduct.indexOf(product);
        if(index==-1)return null;
        listProduct.set(index,product);
        return product;
    }

    @Override
    public Product deleteProduct(Integer productId) {
        int index=listProduct.indexOf(new Product(productId,"",0));
        if(index==-1)return null;
        return listProduct.remove(index);

    }

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public Product findById(Integer productId) {
        int index=listProduct.indexOf(new Product(productId,"",0));
        if(index==-1){
            return null;
        }

        return listProduct.get(index);
    }
}
