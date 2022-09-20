INSERT INTO tb_account(name, cpf) VALUES ('Bruno Guimarães', '042.266.485-52');
INSERT INTO tb_account(name, cpf) VALUES ('Diogo Guimarães', '054.284.555-82');
INSERT INTO tb_account(name, cpf) VALUES ('Déborah Guimarães', '054.284.555-82');

UPDATE tb_account SET BALANCE = BALANCE + 10000 WHERE ID = 1;

//UPDATE tb_account
//SET balance = balance + 10000
//WHERE id = 1;

// MUDAR PARA ORIGIN_ID
// MUDAR PARA DESTINY_ID
INSERT INTO tb_transaction(origin_id, destiny_id, amount) VALUES (1, 2, 3000.00);
INSERT INTO tb_transaction(origin_id, destiny_id, amount) VALUES (1, 3, 3000.00);