-- REMOVE OLD DATA
SELECT truncate_tables_flatsharing();
SELECT reset_sequences_flatsharing();

-- SET NEW DATA
INSERT INTO users (id, first_name, middle_name, last_name) VALUES
  (nextval('users_seq'), 'Рабодан', 'Рабоданович', 'Брейвик');

INSERT INTO credentials (user_id, login, password, salt) VALUES
  (1, 'xiljagx', '12345678', 'TODO_salt');

INSERT INTO account_statuses (user_id, enabled, locked, expired) VALUES
  (1, TRUE, FALSE, FALSE);
