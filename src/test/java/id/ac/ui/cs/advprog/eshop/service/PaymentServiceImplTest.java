package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    @Mock
    OrderRepository orderRepository;
    List<Payment> payments;
    List<Order> orders;

    @BeforeEach
    void setUp() {
        List <Product> products = new ArrayList<>();

        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(1);
        products.add(product);

        orders = new ArrayList<>();
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products, 1708560000L, "Safira Sudrajat");
        orders.add(order);

        payments = new ArrayList<>();
        Map <String, String> paymentData1 = Map.of("voucherCode", "ESHOP1234ABC5678");
        Payment payment1 = new Payment("123", "VOUCHER", paymentData1);
        payments.add(payment1);

        Map <String, String> paymentData2 = Map.of("address", "UI", "deliveryFee", "18000");
        Payment payment2 = new Payment("456", "COD", paymentData2);
        payments.add(payment2);
    }

    @Test
    void testAddPayment() {
        Order order = orders.get(0);
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.addPayment(order, "VOUCHER", Map.of("voucherCode", "ESHOP1234ABC5678"));
        verify(paymentRepository, times(1)).save(any(Payment.class));
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testSetStatusSuccess() {
        Payment payment = payments.get(0);
        Order order = orders.get(0);
        doReturn(order).when(orderRepository).findById(payment.getId());
        doReturn(order).when(orderRepository).save(order);
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.setStatus(payment, PaymentStatus.SUCCESS.getValue());
        verify(orderRepository, times(1)).save(order);
        verify(paymentRepository, times(1)).save(payment);
        assertEquals(PaymentStatus.SUCCESS.getValue(), result.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }
}