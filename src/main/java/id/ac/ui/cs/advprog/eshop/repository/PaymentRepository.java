package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    public Payment save(Payment payment) {
        int i = 0;
        for (Payment savedPayment : payments) {
            if (savedPayment.getId().equals(payment.getId())) {
                payments.remove(i);
                payments.add(i, payment);
                return payment;
            }
            i++;
        }

        payments.add(payment);
        return payment;
    }

    public Payment findById(String id) {
        for (Payment savedPayment : payments) {
            if (savedPayment.getId().equals(id)) {
                return savedPayment;
            }
        }
        return null;
    }

    public List<Payment> findAll() {
        return payments;
    }
}