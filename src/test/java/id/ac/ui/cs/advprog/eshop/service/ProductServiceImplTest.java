package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testCreate() {
        Product product = new Product();

        productService.create(product);

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        Iterator<Product> iterator = products.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void testFindById() {
        long id = 1L;
        Product expectedProduct = new Product();
        when(productRepository.findById(id)).thenReturn(expectedProduct);

        Product result = productService.findById(id);

        assertEquals(expectedProduct, result);
    }

    @Test
    void testEdit() {
        Product currentProduct = new Product();
        Product newProduct = new Product();

        productService.edit(currentProduct, newProduct);

        verify(productRepository, times(1)).edit(currentProduct, newProduct);
    }

    @Test
    void testDelete() {
        Product product = new Product();

        productService.delete(product);

        verify(productRepository, times(1)).delete(product);
    }
}

