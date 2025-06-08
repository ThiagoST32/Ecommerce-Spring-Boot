CREATE TABLE IF NOT EXISTS tb_users(
    id_user SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    typeUser VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_users_card(
    id_user_card SERIAL PRIMARY KEY,
    id_user BIGINT NOT NULL,
    card_number VARCHAR(20) NOT NULL UNIQUE,
    password INT NOT NULL,
    card_holder_name VARCHAR(255) NOT NULL,
    expiration_date DATE NOT NULL,
    cvv VARCHAR(5) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES tb_users(id_user)
);