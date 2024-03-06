package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCODTest {
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
    void testCreatePaymentCOD() {
        this.paymentData.put("address", "UI");
        this.paymentData.put("deliveryFee", "18000");
        PaymentCOD payment = new PaymentCOD("123", "COD", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentCODEmptyPaymentData() {
        PaymentCOD payment = new PaymentCOD("123", "COD", this.paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setPaymentData(this.paymentData));
    }

    @Test
    void testCreatePaymentCODEmptyValue() {
        this.paymentData.put("address", "");
        this.paymentData.put("deliveryFee", "");
        PaymentCOD payment = new PaymentCOD("123", "COD", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentCODEmptyKey() {
        this.paymentData.put("", "UI");
        this.paymentData.put("", "18000");
        PaymentCOD payment = new PaymentCOD("123", "COD", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}