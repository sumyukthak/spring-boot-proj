DROP TABLE IF EXISTS org;

CREATE TABLE org ( 
   org_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   org_name VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS employee;

CREATE TABLE employee ( 
   emp_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   first_name VARCHAR(20) NOT NULL,    
   last_name VARCHAR(20) NOT NULL,
   email VARCHAR(20) NOT NULL,
   designation VARCHAR(20) NOT NULL, 
   org_id INT,
   foreign key (org_id) references org(org_id)
);
DROP TABLE IF EXISTS asset;

CREATE TABLE asset ( 
   asset_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   asset_name VARCHAR(20) NOT NULL,    
   asset_type VARCHAR(20) NOT NULL,
   emp_id INT NULL,
   foreign key (emp_id) references employee(emp_id) 
   ON DELETE SET NULL,
   org_id INT,
   foreign key (org_id) references org(org_id)
);



INSERT INTO org (org_name) VALUES
  ('DemoOrg');

INSERT INTO employee (first_name, last_name, email,designation,org_id) VALUES
  ('Sandhya', 'Kalidasan', 'abc@gmail.com','Lead',1),
  ('John', 'Peter', 'xyz@email.com','Developer',1);

INSERT INTO asset (asset_name, asset_type,emp_id,org_id) VALUES
  ('Laptop', 'Hardware',1,1),
  ('Printer', 'Hardware',NULL,1);  



