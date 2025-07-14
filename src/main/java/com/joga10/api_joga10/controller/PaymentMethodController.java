package com.joga10.api_joga10.controller;

import com.joga10.api_joga10.model.PaymentMethod;
import com.joga10.api_joga10.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<PaymentMethod> getPaymentMethodsByUser(@PathVariable String userId) {
        return paymentMethodRepository.findByUserId(userId);
    }

    @GetMapping("/{id}")
    public Optional<PaymentMethod> getPaymentMethodById(@PathVariable String id) {
        return paymentMethodRepository.findById(id);
    }

    @PostMapping
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @PutMapping("/{id}")
    public PaymentMethod updatePaymentMethod(@PathVariable String id, @RequestBody PaymentMethod paymentMethod) {
        paymentMethod.setId(id);
        return paymentMethodRepository.save(paymentMethod);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentMethod(@PathVariable String id) {
        paymentMethodRepository.deleteById(id);
    }
}
