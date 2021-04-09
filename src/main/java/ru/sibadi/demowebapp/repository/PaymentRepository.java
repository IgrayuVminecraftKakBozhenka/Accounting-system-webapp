package ru.sibadi.demowebapp.repository;

import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Payment;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private static int id = 1;
    private final List<Payment> payments = new ArrayList<>();
    public PaymentRepository () {
        addPayment(10000, 1000, 1, "январь");
    }
    public Payment addPayment(int salary, int prize, int personId, String date) {
        Payment payment = new Payment(id, salary, prize, personId, date);
        payments.add(payment);
        id++;
        return payment;
    }

    public List<Payment> findAllPayments() { return payments; }

    public List<Payment> findPaymentsByPersonId(int id) {
        List<Payment> personPayments = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getPersonId() == id) {
                personPayments.add(p);
            }
        }
        return personPayments;
    }

    public Payment findPaymentById(int id) {
        Payment payment = null;
        for (Payment p : payments) {
            if (p.getId() == id) {
            payment = p;
            }
        }
        return payment;
    }

    public void deletePaymentById(int id) {
        Payment payment = this.findPaymentById(id);
        payments.remove(payment);
    }
}
