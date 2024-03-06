package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @AfterEach
    void tearDown() {
        this.paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucher() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("123", "VOUCHER", this.paymentData);

        assertEquals("123", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(1, payment.getPaymentData().size());
    }

    @Test
    void testCreatePaymentCOD() {
        this.paymentData.put("address", "UI");
        this.paymentData.put("deliveryFee", "15000");
        Payment payment = new Payment("123", "COD", this.paymentData);

        assertEquals("123", payment.getId());
        assertEquals("COD", payment.getMethod());
        assertEquals(1, payment.getPaymentData().size());
    }

    @Test
    void testSetStatusToSuccess() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("123", "VOUCHER", this.paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testSetStatusToRejected() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("123", "VOUCHER", this.paymentData);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetInvalidStatus() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("123", "VOUCHER", this.paymentData);
        payment.setStatus("REJECTED");
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}
