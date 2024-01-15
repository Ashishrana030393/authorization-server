-- create table for Role
CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- create table for User
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- create join table for Many-to-Many relationship between User and Role
CREATE TABLE users_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- create table for ClientTokenSettings
CREATE TABLE client_token_settings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ttl INT NOT NULL,
    type VARCHAR(255) NOT NULL,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- create table for Client
CREATE TABLE clients (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    client_id VARCHAR(255) UNIQUE NOT NULL,
    client_id_issued_at TIMESTAMP,
    client_secret VARCHAR(255),
    client_secret_expires_at TIMESTAMP,
    client_name VARCHAR(255),
    client_authentication_methods VARCHAR(255),
    authorization_grant_types VARCHAR(255),
    redirect_uris VARCHAR(255),
    post_logout_redirect_uris VARCHAR(255),
    scopes VARCHAR(255),
    token_settings_id BIGINT,
    FOREIGN KEY (token_settings_id) REFERENCES client_token_settings(id)
);