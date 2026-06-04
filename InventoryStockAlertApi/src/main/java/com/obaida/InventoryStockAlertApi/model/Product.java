package com.obaida.InventoryStockAlertApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sku; // Stock Keeping Unit
    private Integer stockLevel;
    private Integer lowStockThreshold;
    private String supplierEmail;
}