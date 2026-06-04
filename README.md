# Inventory Stock Alert API

A RESTful Inventory Management API built with Java and Spring Boot that helps businesses manage products, track inventory levels, and receive stock alerts when product quantities fall below predefined thresholds.

## Features

* Product Management (Create, Read, Update, Delete)
* Inventory Tracking
* Low Stock Alerts
* Stock Quantity Updates
* RESTful API Architecture
* Validation and Exception Handling
* Database Integration
* Layered Architecture (Controller, Service, Repository)
* Clean and Maintainable Code Structure

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* REST API

The application will start on:

```text
http://localhost:8080
```

## Sample Product Request

```json
 {
  "id": 1,
  "name": "Wireless Mouse",
  "sku": "MS-99",
  "stockLevel": 15,
  "lowStockThreshold": 5,
  "supplierEmail": "supplier@example.com"
}
```

## Low Stock Alert Example

When product quantity falls below the configured minimum stock level, the system flags it as a low-stock item.

Example:

```text
id                : 1
name              : Wireless Mouse
sku               : MS-99
stockLevel        : 5
lowStockThreshold : 5
supplierEmail     : supplier@example.com
```

