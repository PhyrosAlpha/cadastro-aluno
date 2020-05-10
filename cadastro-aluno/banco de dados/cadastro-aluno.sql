##Banco de dados cadastro aluno

CREATE DATABASE IF NOT EXISTS cadastro_aluno
DEFAULT CHARACTER SET 'utf8';

USE cadastro_aluno;

CREATE TABLE aluno
(
	rgm VARCHAR(8) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nasc DATE NOT NULL,
    email VARCHAR(50) UNIQUE,
    endereco VARCHAR(50),
    municipio VARCHAR(30),
    estado CHAR(2),
    telefone VARCHAR(16)
);

CREATE TABLE curso
(
	cursoId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    area_conhecimento VARCHAR(20) NOT NULL
);

CREATE TABLE disciplina
(
	disciplinaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    carga_horaria INT NOT NULL
);


CREATE TABLE aluno_curso
(
	rgm VARCHAR(8) NOT NULL,
	cursoId INT NOT NULL,
	aluno_cursoID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    periodo VARCHAR(15) NOT NULL,
    campus VARCHAR(15)  NOT NULL
);

CREATE TABLE curso_matricula
(
	aluno_cursoID INT NOT NULL, 
    disciplinaID INT NOT NULL,
    curso_matriculaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(20) DEFAULT 'INATIVO',
    semestre VARCHAR(6) DEFAULT 'N/A',
    nota decimal(3,1) DEFAULT '0.0',
    falta INT DEFAULT '0'
);

ALTER TABLE aluno_curso
ADD FOREIGN KEY (rgm) REFERENCES aluno(rgm)
ON DELETE CASCADE ON UPDATE CASCADE,
ADD FOREIGN KEY (cursoID) REFERENCES curso(cursoID);

ALTER TABLE curso_matricula
ADD FOREIGN KEY (disciplinaID) REFERENCES disciplina(disciplinaID),
ADD FOREIGN KEY (aluno_cursoID) REFERENCES aluno_curso(aluno_cursoID)
ON DELETE CASCADE ON UPDATE CASCADE;


    
#Inserção de linhas para utilização do aplicativo

#Inserção cursos de exemplo    
INSERT INTO curso VALUES
(DEFAULT, 'Análise e Desenvoldimento de Sistemas', 'Tecnólogo', 'Exatas'),
(DEFAULT, 'Psicologia', 'Bacharelado', 'Humanas');

#Inserção Disiciplinas de exemplo
INSERT INTO disciplina VALUES
#-------------/Curso ADS\---------------
(DEFAULT,"Técnicas de Programação",40),
(DEFAULT,"Banco de dados",80),
(DEFAULT,"Análise de Projetos",80),
(DEFAULT,"Engenharia de Software",80),
(DEFAULT,"Estrutura de Dados",40),
(DEFAULT,"Matemática Aplicada",80),
(DEFAULT,"Programção Web",80),
(DEFAULT,"Técnicas e desenvolvimento de algoritmos",80),
(DEFAULT,"Programção Orientada a Objetos",80),
(DEFAULT,"Modelagem de dados",60),
(DEFAULT,"Empreendedorismo",80),
(DEFAULT,"Análise e Projetos de Sistemas",40),
(DEFAULT,"Tópicos Especiais",60),
(DEFAULT,"Sistemas Clientes-Servidores",60),
(DEFAULT,"Gestão de Técnologia da Informação",60),
(DEFAULT,"Projeto Interdisciplinas III",30),
(DEFAULT,"Programção para Dispositivos Móveis",60),
(DEFAULT,"Qualidade de Software",40),
(DEFAULT,"Projeto Interdisciplinas II",30),
(DEFAULT,"Projeto Interdisciplinas I",20),
(DEFAULT,"Aplicações para a Internet",60),
(DEFAULT,"Engenharia de Requisitos",40),
(DEFAULT,"Fundamentos de Sistemas de Informação",40),
(DEFAULT,"Modelagem de Negócios",40),
(DEFAULT,"Projeto Interdisciplinar ",20),
(DEFAULT,"Interface Humano-Computador",40),
(DEFAULT,"Lingua Portuguesa",80),
(DEFAULT,"Organização e Arquitetura de Computadores",80),
(DEFAULT,"Programação de Computadores",40),
(DEFAULT,"Sistemas Operacionais",80),

#-------------/Curso Psicologia\--------------

(DEFAULT,"História da Psicologia",80),
(DEFAULT,"Psicologia e Educação",80),
(DEFAULT,"Psicopatologia I",80),
(DEFAULT,"Psicopatologia II",80),
(DEFAULT,"Psicopatologia III",60);


#Aluno de exemplo
#INSERT INTO aluno VALUES("4134-1", "Fulano das Neves", "414.544.444-44", STR_TO_DATE("04-12-1992", '%d-%m-%Y'), "aluno@hotmail.com", "Rua de exemplo", "São Paulo", "SP", "4444");   # Aluno de exemplo
