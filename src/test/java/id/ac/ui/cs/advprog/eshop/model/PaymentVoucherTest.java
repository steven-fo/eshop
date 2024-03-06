package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentVoucherTest {
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
    void createPaymentVoucherEmptyPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123", "VOUCHER", this.paymentData);});
    }

    @Test
    void createPaymentVoucherEmptyVoucherData() {
        this.paymentData.put("voucherCode", "");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123", "VOUCHER", this.paymentData);});
    }

    @Test
    void createPaymentVoucherEmptyCodeData() {
        this.paymentData.put("", "ESHOP1234ABC5678");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123", "VOUCHER", this.paymentData);});
    }

    @Test
    void createPaymentVoucherInvalidVoucherCode() {
        this.paymentData.put("voucherCode", "CODE");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123", "VOUCHER", this.paymentData);});
    }

    @Test
    void createPaymentVoucherValidVoucherCode() {
        this.paymentData.put("voucherCode", "ESHOP1234BC5678");
        Payment payment = new Payment("123", "VOUCHER", this.paymentData);

        assertEquals("123", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(1, payment.getPaymentData().size());
    }
}
