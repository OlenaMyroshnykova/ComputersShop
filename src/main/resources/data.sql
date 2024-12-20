-- Insert initial data for StoreOwner
INSERT INTO store_owner (id, name) VALUES (1, 'John Doe');
INSERT INTO store_owner (id, name) VALUES (2, 'Jane Smith');

-- Insert initial data for Store
INSERT INTO store (id, name, tax_id, owner_id) VALUES (1, 'Tech Store', '123456789', 1);
INSERT INTO store (id, name, tax_id, owner_id) VALUES (2, 'Gadget World', '987654321', 2);

-- Insert initial data for Brand
INSERT INTO brand (id, name) VALUES (1, 'Apple');
INSERT INTO brand (id, name) VALUES (2, 'Dell');
INSERT INTO brand (id, name) VALUES (3, 'HP');

-- Insert initial data for Computer
INSERT INTO computer (id, brand_id, memory, processor, operating_system, price, store_id) VALUES 
(1, 1, 16, 'M1', 'macOS', 2000.00, 1),
(2, 2, 8, 'Intel i5', 'Windows 10', 800.00, 1),
(3, 3, 16, 'AMD Ryzen 5', 'Windows 11', 1200.00, 2);