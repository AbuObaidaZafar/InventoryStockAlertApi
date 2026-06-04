package com.obaida.InventoryStockAlertApi.service;

import com.obaida.InventoryStockAlertApi.model.Product;
import com.obaida.InventoryStockAlertApi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher eventPublisher;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product updateStock(String sku, Integer quantityChange) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));

        product.setStockLevel(product.getStockLevel() + quantityChange);
        Product updatedProduct = productRepository.save(product);

        if (updatedProduct.getStockLevel() <= updatedProduct.getLowStockThreshold()) {
            eventPublisher.publishEvent(new StockAlertEvent(this, updatedProduct));
        }

        return updatedProduct;
    }

    public List<Product> getLowStockReport() {
        return productRepository.findLowStockProducts();
    }
}