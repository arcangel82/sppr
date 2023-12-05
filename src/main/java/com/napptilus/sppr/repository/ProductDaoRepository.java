package com.napptilus.sppr.repository;

import com.napptilus.sppr.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ProductDaoRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT t FROM Product t WHERE t.toDateApplication> ?1 AND t.fromDateApplication<?1 AND " +
            "t.productId=?2 AND t.brandId=?3 ORDER BY t.priorityProduct DESC LIMIT 1")
    Product getPricebyProduct(LocalDateTime dateApp, String productId, Integer brandId);

}
