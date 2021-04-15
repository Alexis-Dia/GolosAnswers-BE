CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_entree` datetime NOT NULL,
  `selected_options` varchar(2555) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `old_price` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `stock_status` BIT DEFAULT FALSE,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `product`(brand, model, description, date_entree, selected_options, product_type, image_path, old_price, price, rating, stock_status) VALUES
('SAMSUNG','55UE7300NU','Good quality!',STR_TO_DATE('2017-02-21 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',1599,1499,5,true),
('SAMSUNG','65UE7300NU','Good quality!',STR_TO_DATE('2017-03-11 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',2599,2499,5,false),
('SAMSUNG','75UE7300NU','Good quality!',STR_TO_DATE('2017-04-12 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',3599,3499,5,true),
('SAMSUNG','85UE7300NU','Good quality!',STR_TO_DATE('2017-05-13 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',4599,4499,5,true),
('SAMSUNG','95UE7300NU','Good quality!',STR_TO_DATE('2017-06-14 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',5599,5499,5,true),
('SAMSUNG','55UE7500NU','Good quality!',STR_TO_DATE('2017-07-15 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',1399,1299,5,true),
('SAMSUNG','65UE7500NU','Good quality!',STR_TO_DATE('2017-08-16 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',2399,2299,5,false),
('SAMSUNG','75UE7500NU','Good quality!',STR_TO_DATE('2017-09-17 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',3399,3299,5,true),
('SAMSUNG','85UE7500NU','Good quality!',STR_TO_DATE('2017-02-18 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',4399,4299,5,true),
('SAMSUNG','95UE7500NU','Good quality!',STR_TO_DATE('2017-03-19 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',5399,5299,5,true),
('SAMSUNG','55UE8100MU','Good quality!',STR_TO_DATE('2017-04-21 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',1999,1899,5,true),
('SAMSUNG','65UE8100MU','Good quality!',STR_TO_DATE('2017-05-22 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',2999,2899,5,false),
('SAMSUNG','75UE8100MU','Good quality!',STR_TO_DATE('2017-06-23 23:38:12', '%Y-%m-%d %T'),'Wi-fi','Used','',3999,3899,5,true),
('SAMSUNG','85UE8100MU','Good quality!',STR_TO_DATE('2017-07-24 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',4999,4899,5,true),
('SAMSUNG','95UE8100MU','Good quality!',STR_TO_DATE('2017-08-11 23:38:12', '%Y-%m-%d %T'),'Wi-fi','New','',5999,5899,5,true);