-- TABLES

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id                            INTEGER NOT NULL PRIMARY KEY,
  first_name                    TEXT NOT NULL,
  middle_name                   TEXT NOT NULL,
  last_name                     TEXT NOT NULL
);

DROP SEQUENCE IF EXISTS users_seq;
CREATE SEQUENCE users_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

DROP TABLE IF EXISTS account_statuses;
CREATE TABLE account_statuses (
  user_id                       INTEGER NOT NULL PRIMARY KEY,
  enabled                       BOOLEAN DEFAULT TRUE,
  locked                        BOOLEAN DEFAULT FALSE,
  expired                       BOOLEAN DEFAULT FALSE
);

DROP TABLE IF EXISTS credentials;
CREATE TABLE credentials (
  user_id                       INTEGER NOT NULL PRIMARY KEY,
  login                         TEXT NOT NULL,
  password                      TEXT NOT NULL,
  salt                          TEXT,
  expired                       BOOLEAN DEFAULT FALSE
);

-- FUNCTIONS

CREATE OR REPLACE FUNCTION truncate_tables_flatsharing() RETURNS void AS
$$
DECLARE statements CURSOR FOR
  SELECT tablename
  FROM pg_tables
  WHERE tableowner = 'flatsharing' AND schemaname = 'public' AND tablename NOT LIKE 'pgbench_%';
BEGIN
  FOR stmt IN statements LOOP
    EXECUTE 'TRUNCATE TABLE ' || quote_ident(stmt.tablename) || ' CASCADE;';
  END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION reset_sequences_flatsharing() RETURNS void AS
$$
DECLARE statements CURSOR FOR
  SELECT sequence_name
  FROM information_schema.sequences
  WHERE sequence_schema = 'public';
BEGIN
  FOR stmt IN statements LOOP
    EXECUTE 'ALTER SEQUENCE ' || quote_ident(stmt.sequence_name) || ' RESTART WITH 1;';
  END LOOP;
END;
$$ LANGUAGE plpgsql;
