DROP DATABASE IF EXISTS flatsharingdb;
DROP USER IF EXISTS flatsharing;

CREATE USER flatsharing WITH PASSWORD 'local';
CREATE DATABASE flatsharingdb;

GRANT ALL PRIVILEGES ON DATABASE flatsharingdb TO flatsharing;
