DROP DATABASE IF EXISTS InventorySystem;
CREATE DATABASE InventorySystem;

USE InventorySystem;

-- Users table
CREATE TABLE Users (
    userId INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    gmail VARCHAR(50),
    username VARCHAR(25),
    password VARCHAR(25),
    userRole VARCHAR(25),
    userCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (userId)
);

INSERT INTO Users (username, password, userRole, userCreated_at) 
VALUES 
('admin', 'admin123', 'Admin', NOW());

-- Suppliers table
CREATE TABLE Suppliers (
    supplierId INT NOT NULL AUTO_INCREMENT,
    supplierName VARCHAR(100),
    supplierNickname VARCHAR(100),
    supplierLocation VARCHAR(100),
    username VARCHAR(25),
    supplierCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (supplierId)
);

-- SupplierProducts table
CREATE TABLE SupplierProducts (
    supplierProductId INT NOT NULL AUTO_INCREMENT,
    supplierProductName VARCHAR(100),
    supplierProductDescription TEXT,
    supplierProductPrice DOUBLE,
    supplierNickname VARCHAR(100),
    username VARCHAR(25),
    supplierProductCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (supplierProductId)
);

-- IncomingOrders table
CREATE TABLE IncomingOrders (
    receivingId INT NOT NULL AUTO_INCREMENT,
    receivingProductName VARCHAR(100),
    receivingProductDescription TEXT,
    receivingProductQuantity INT,
    receivingProductPrice DOUBLE,
    total DOUBLE,
    supplierNickname VARCHAR(100),
    username VARCHAR(25),
    incomingOrderCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (receivingId)
);

-- Inventory table
CREATE TABLE Inventory (
    inventoryId INT NOT NULL AUTO_INCREMENT,
    inventoryProductName VARCHAR(100),
    inventoryProductDescription TEXT,
    inventoryProductQuantity INT,
    inventoryProductPrice DOUBLE,
    total DOUBLE,
--     supplierNickname VARCHAR(100),
    username VARCHAR(25),
    inventoryCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (inventoryId)
);

-- Stores table
CREATE TABLE Stores (
    storeId INT NOT NULL AUTO_INCREMENT,
    storeName VARCHAR(100),
    storeNickname VARCHAR(100),
    storeLocation VARCHAR(100),
    username VARCHAR(25),
    storeCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (storeId)
);

-- StoreProduct table
CREATE TABLE StoreProduct (
    storeProductId INT NOT NULL AUTO_INCREMENT,
    storeProductName VARCHAR(100),
    storeProductDescription TEXT,
    storeProductQuantity INT,
    storeProdcutPrice DOUBLE,
    total DOUBLE,
    storeNickname VARCHAR(100),
    username VARCHAR(25),
    storeProductCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (storeProductId)
);

-- ShippingOrders table
CREATE TABLE ShippingOrders (
    shippingId INT NOT NULL AUTO_INCREMENT,
    shippingProductName VARCHAR(100),
	shippingProductDescription TEXT,
    shippingProductQuantity INT,
    shippingProductPrice DOUBLE,
    total DOUBLE,
    markup DOUBLE,
    storeNickname VARCHAR(100),
    username VARCHAR(25),
    shippingCreated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (shippingId)
);
