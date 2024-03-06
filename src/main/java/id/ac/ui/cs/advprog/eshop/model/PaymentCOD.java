package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import java.util.Map;

public class PaymentCOD extends Payment{
    public PaymentCOD(String id, String method, Map<String, String> paymentData) {
        super(id, method, paymentData);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (!paymentData.containsKey("address") && !paymentData.containsKey("deliveryFee")) {
            this.status = PaymentStatus.REJECTED.getValue();
        } else if (paymentData.get("address").isEmpty() || paymentData.get("deliveryFee").isEmpty()) {
            this.status = PaymentStatus.REJECTED.getValue();
        } else {
            this.status = PaymentStatus.SUCCESS.getValue();
        }
    }
}
