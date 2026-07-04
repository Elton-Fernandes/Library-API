CREATE TABLE Autor
(
    id_autor SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    data_nascimento DATE,
    nacionalidade VARCHAR(30)
);

CREATE TABLE Livro
(
    id_livro SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    numero_paginas INT NOT NULL,
    genero VARCHAR(255) NOT NULL,
    id_editora INT
);

CREATE TABLE Editora
(
    id_editora SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Cliente
(
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(50),
    is_banned BOOLEAN NOT NULL
);

CREATE TABLE Emprestimo
(
    id_emprestimo SERIAL PRIMARY KEY,
    id_cliente INT,
    id_livro INT,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    is_devolvido BOOLEAN,
    valor NUMERIC(10, 2) NOT NULL,
    is_pago BOOLEAN NOT NULL
);

CREATE TABLE Escreve
(
    id_autor INT,
    id_livro INT,
    PRIMARY KEY(id_autor, id_livro)
);

ALTER TABLE Livro ADD FOREIGN KEY(id_editora) REFERENCES Editora (id_editora);
ALTER TABLE Emprestimo ADD FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente);
ALTER TABLE Emprestimo ADD FOREIGN KEY(id_livro) REFERENCES Livro (id_livro);
ALTER TABLE Escreve ADD FOREIGN KEY(id_autor) REFERENCES Autor (id_autor);
ALTER TABLE Escreve ADD FOREIGN KEY(id_livro) REFERENCES Livro (id_livro);
