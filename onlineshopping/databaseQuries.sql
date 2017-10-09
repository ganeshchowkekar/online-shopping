create table category(
	id IDENTITY,
	name varchar(50),
	description varchar(255),
	image_url varchar(50),
	is_active boolean,
	
	constraint pk_category_id primary key (id)
);


//user detail table

CREATE TABLE `onlineshopping`.`user_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  `enabled` TINYINT(1) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `contact_number` VARCHAR(15) NULL,
  `user_detailcol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  
  INSERT INTO `onlineshopping`.`user_detail` 
  (`first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) 
  VALUES ('virat', 'Kohli', 'admin', '1', '888888', 'vk@gmail.com', '8888888888');

  
  
  
  
  CREATE TABLE `onlineshopping`.`product` (`id` INT NOT NULL AUTO_INCREMENT,`code` VARCHAR(20) NULL,
  `name` VARCHAR(45) NULL,`brand` VARCHAR(45) NULL,`description` VARCHAR(255) NULL,`unit_price` DECIMAL(10,2) NULL,
  `quantity` INT NULL,
  `is_active` TINYINT(1) NULL,
  `category_id` INT NULL,
  `supplier_id` INT NULL,
  `purchase` INT NULL DEFAULT 0,
  `views` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_product_category_id`
    FOREIGN KEY (`id`)
    REFERENCES `onlineshopping`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_supplier_id`
    FOREIGN KEY (`id`)
    REFERENCES `onlineshopping`.`user_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '			';
