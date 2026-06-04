package com.obaida.InventoryStockAlertApi.service;

import com.obaida.InventoryStockAlertApi.model.Product;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StockAlertEvent extends ApplicationEvent {
    private final Product product;

    public StockAlertEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}

