package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Test
    void testCreateProductPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("createProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testCreateProductPost() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        Product product = new Product();
        when(productService.create(product)).thenReturn(product);

        mockMvc.perform(post("/product/create")
                .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        verify(productService, times(1)).create(product);
    }

    @Test
    void testProductListPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().attribute("products", productList));
    }

    @Test
    void testEditProductPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        Product product = new Product();
        product.setProductId("1");
        when(productService.findById(1)).thenReturn(product);

        mockMvc.perform(get("/product/edit/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("editProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testEditProductPut() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        Product product = new Product();
        product.setProductId("1");
        when(productService.findById(1)).thenReturn(product);

        mockMvc.perform(put("/product/edit")
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        verify(productService, times(1)).findById(1);
        verify(productService, times(1)).edit(product, product);
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        Product product = new Product();
        product.setProductId("1");
        when(productService.findById(1)).thenReturn(product);

        mockMvc.perform(delete("/product/delete/{id}", 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("../list"));

        verify(productService, times(1)).findById(1);
        verify(productService, times(1)).delete(product);
    }
}
