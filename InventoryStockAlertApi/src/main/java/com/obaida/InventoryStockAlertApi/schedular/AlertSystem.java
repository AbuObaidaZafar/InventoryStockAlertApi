package com.obaida.InventoryStockAlertApi.schedular;

import com.obaida.InventoryStockAlertApi.service.StockAlertEvent;
import com.obaida.InventoryStockAlertApi.model.Product;
import com.obaida.InventoryStockAlertApi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class AlertSystem {

    private final ProductRepository productRepository;

    @Async
    @EventListener
    public void handleLowStockAlert(StockAlertEvent event) {
        Product product = event.getProduct();
        log.warn("🚨 ALERT! Low stock for SKU: {} ({}). Current Level: {}. Threshold: {}",
                product.getSku(), product.getName(), product.getStockLevel(), product.getLowStockThreshold());
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void dailyInventoryCheck() {
        log.info("⏰ Running automated daily stock check...");
        List<Product> lowStockItems = productRepository.findLowStockProducts();
        if (!lowStockItems.isEmpty()) {
            log.warn("Daily Summary: Found {} items running low on stock.", lowStockItems.size());
        }
    }
}
