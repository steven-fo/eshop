package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import java.util.Map;

public class PaymentVoucher extends Payment{
    public PaymentVoucher(String id, String method, Map<String, String> paymentData) {
        super(id, method, paymentData);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (!paymentData.containsKey("voucherCode")) {
            this.status = PaymentStatus.REJECTED.getValue();
        } else {
            if (paymentData.get("voucherCode").length() == 16) {
                if (paymentData.get("voucherCode").startsWith("ESHOP")) {
                    int numericalChar = 0;
                    for (char c : paymentData.get("voucherCode").toCharArray()) {
                        if (Character.isDigit(c)) {
                            numericalChar++;
                        }
                    }
                    if (numericalChar == 8) {
                        this.status = PaymentStatus.SUCCESS.getValue();
                    }
                }
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }
        }
    }
}
