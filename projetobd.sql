drop database if exists projetobd;
create database projetobd;
use projetobd;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    nome_usuario VARCHAR(255)
);

CREATE TABLE vaquinha (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_vaquinha VARCHAR(50),
    descricao VARCHAR(255),
    valor_meta VARCHAR(255),
    valor_arrecadado VARCHAR(255),
    data_criacao VARCHAR(10),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);