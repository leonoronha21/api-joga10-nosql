package com.joga10.api_joga10.repository;

import com.joga10.api_joga10.model.PaymentMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {
    List<PaymentMethod> findByUserId(String userId);
}
