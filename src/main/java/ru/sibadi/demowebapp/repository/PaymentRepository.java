package ru.sibadi.demowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Payment;

import java.util.ArrayList;
import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> payments = new ArrayList<>();

    /*public List<Payment> findAllPayments() { return payments; }

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
    }*/
}
