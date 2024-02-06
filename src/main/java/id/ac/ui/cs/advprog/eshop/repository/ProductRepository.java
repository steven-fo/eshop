package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int id = 1;

    public Product create(Product product) {
        product.setProductId(Integer.toString(id));
        id++;
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(long id) {
        Product temp = null;
        for (Product product : productData) {
            if (id == Integer.parseInt(product.getProductId())) {
                temp = product;
            }
        }
        return temp;
    }

    public void edit(Product currentProduct, Product newProduct) {
        int index = productData.indexOf(currentProduct);
        newProduct.setProductId(currentProduct.getProductId());
        productData.set(index, newProduct);
    }
}
