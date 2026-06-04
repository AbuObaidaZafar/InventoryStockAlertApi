package com.obaida.InventoryStockAlertApi.restcontroller;

import com.obaida.InventoryStockAlertApi.model.Product;
import com.obaida.InventoryStockAlertApi.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(inventoryService.addProduct(product));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(inventoryService.getAllProducts());
    }

    @PatchMapping("/products/{sku}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable String sku,
            @RequestBody Map<String, Integer> request) {
        Integer change = request.get("quantityChange");
        return ResponseEntity.ok(inventoryService.updateStock(sku, change));
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Product>> getLowStockAlerts() {
        return ResponseEntity.ok(inventoryService.getLowStockReport());
    }
}
