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
        PaymentVoucher payment = new PaymentVoucher("123", "VOUCHER", this.paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setPaymentData(this.paymentData));
    }

    @Test
    void createPaymentVoucherEmptyVoucherData() {
        this.paymentData.put("voucherCode", "");
        PaymentVoucher payment = new PaymentVoucher("123", "VOUCHER", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void createPaymentVoucherEmptyCodeData() {
        this.paymentData.put("", "ESHOP1234ABC5678");
        PaymentVoucher payment = new PaymentVoucher("123", "VOUCHER", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void createPaymentVoucherInvalidVoucherCode() {
        this.paymentData.put("voucherCode", "CODE");
        PaymentVoucher payment = new PaymentVoucher("123", "VOUCHER", this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void createPaymentVoucherValidVoucherCode() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        PaymentVoucher payment = new PaymentVoucher("123", "VOUCHER", this.paymentData);
        payment.setPaymentData(this.paymentData);

        assertEquals("123", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(1, payment.getPaymentData().size());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }
}
