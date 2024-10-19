
USE productservice;
truncate products;
INSERT INTO products (weight, recommendation_id, review_id, product_name)
VALUES 
    (1.25, 1, 3, 'Laptop Sleeve'),
    (0.75, 2, 1, 'Wireless Mouse'),
    (2.50, 4, 2, 'Mechanical Keyboard'),
    (1.10, 3, 4, 'External Hard Drive'),
    (0.90, 1, 2, 'USB-C Hub');

USE reviewservice;
truncate reviews;
INSERT INTO reviews (author, content, subject)
VALUES 
   ('Chaimaa LAMSIEH', 'This product really exceeded my expectations!', 'Amazing Experience'),
   ('Chaimaa LAMSIEH', 'It’s okay, but it could be better.', 'Average Product'),
   ('El Hassan SEMLALI', 'Absolutely loved it! Will buy again.', 'Highly Recommend'),
   ('El Hassan SEMLALI', 'Not happy with the quality.', 'Disappointed');

USE recommendationservice;
truncate recommendations;
INSERT INTO recommendations (rate, author, content)
VALUES 
    (5, 'El Hassan SEMLALI', 'Highly recommend this product!'),
    (4, 'El Hassan SEMLALI', 'Good value for the price.'),
    (3, 'Chaimaa LAMSIEH', 'It works fine, but there are better options.'),
    (5, 'Chaimaa LAMSIEH', 'Excellent quality and fast delivery.');
