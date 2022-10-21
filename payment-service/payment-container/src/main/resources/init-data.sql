INSERT INTO payment.credit_entry(id, customer_id, total_credit_amount)
    VALUES ('c619698e-206c-4ccb-aff4-f6d5f480bd7b', 'b5f83cc1-2dd2-43cd-95d6-8dd7ba0d2f64', '500.00');


INSERT INTO payment.credit_history(id, customer_id, amount, type)
    VALUES ('0dd614f4-f9de-4fbb-81d0-b0c3f3bd1b79', 'b5f83cc1-2dd2-43cd-95d6-8dd7ba0d2f64', '100.00', 'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
    VALUES ('4a725fdf-ccd3-42c9-8c95-39e2019346d4', 'b5f83cc1-2dd2-43cd-95d6-8dd7ba0d2f64', '600.00', 'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
    VALUES ('48bf4819-442d-44a1-9c2f-5d1710569bd7', 'b5f83cc1-2dd2-43cd-95d6-8dd7ba0d2f64', '200.00', 'DEBIT');


INSERT INTO payment.credit_entry(id, customer_id, total_credit_amount)
    VALUES ('f2b79487-7250-47fe-9354-4d2ad00591d5', '5cec7c36-3c93-425a-a520-b087d9dab4e4', '100.00');

INSERT INTO payment.credit_history(id, customer_id, amount, type)
    VALUES ('1a0b95bd-ec8b-4145-9d17-9eb27fbef729', '5cec7c36-3c93-425a-a520-b087d9dab4e4', '100.00', 'CREDIT');