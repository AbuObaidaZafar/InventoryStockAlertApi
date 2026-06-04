package com.obaida.InventoryStockAlertApi.repository;

import com.obaida.InventoryStockAlertApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.stockLevel <= p.lowStockThreshold")
    List<Product> findLowStockProducts();

    java.util.Optional<Product> findBySku(String sku);
}