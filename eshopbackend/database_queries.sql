// Category Table
CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(250),
	image_url VARCHAR(50),
	is_active BOOLEAN,

	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name,description,image_url,is_active) VALUES ('Mobile', 'Best Selling mobile', 'mobile.png', true);

// User Table
CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(50),
	contact_number VARCHAR(50),
	
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) VALUES 
			('Rajneesh', 'Shukla', 'ADMIN', true, 'mindfire', 'rajneesh@gmail.com', '1234567890');
			
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) VALUES 
			('Sachin', 'Tendulkar', 'SUPPLIER', true, 'mindfire', 'sachin@gmail.com', '432423432423');
			
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) VALUES 
			('MS', 'Dhoni', 'SUPPLIER', true, 'mindfire', 'ms@gmail.com', '1234567890');
			
			
// Product Table
CREATE TABLE product(
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10, 2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
)

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views) 
		VALUES ('AAAAAAAAAAA', 'IPHONE - X', 'Apple', 'Best mobile Brand', 123, 100, true, 1, 1, 1,1);
			