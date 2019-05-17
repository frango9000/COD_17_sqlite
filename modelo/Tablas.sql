/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  NarF
 * Created: May 17, 2019
 */

CREATE TABLE IF NOT EXISTS nacionalidades (
                        idPais integer PRIMARY KEY,
                	pais text NOT NULL UNIQUE
                    );

CREATE TABLE IF NOT EXISTS autores (
                        idAutor integer PRIMARY KEY, 
                        nombreAutor text NOT NULL UNIQUE, 
                        fechaNacimiento text, 
                        idPais integer NOT NULL,
                                FOREIGN KEY (idPais) REFERENCES nacionalidades (idPais)
                    );

CREATE TABLE IF NOT EXISTS editoriales (
                        idEditorial integer PRIMARY KEY,
                        nombreEditorial text NOT NULL UNIQUE
                    );

CREATE TABLE IF NOT EXISTS generos (
                        idGenero integer PRIMARY KEY,
                        genero text NOT NULL UNIQUE
                    );

CREATE TABLE IF NOT EXISTS libros (
                        idLibro integer PRIMARY KEY,
                        titulo text NOT NULL UNIQUE,
                        fechaPublicacion text,
                        idAutor integer NOT NULL REFERENCES autores (idAutor),
                        idGenero integer NOT NULL REFERENCES generos (idGenero),
                        idEditorial integer REFERENCES editoriales (idEditorial)
                    );

INSERT INTO nacionalidades VALUES(1, 'España'),
                                (2, 'Reino Unido'), 
                                (3, 'Estados Unidos'),
                                (4, 'Francia'),
                                (5, 'Alemania'),
                                (6, 'Sudafrica');

INSERT INTO generos VALUES (1, 'Ciencia Ficcion'),
                           (2, 'Drama'),
                           (3, 'Horror'),
                           (4, 'Comedia'),
                           (5, 'Educativo'),
                           (6, 'Aventura'),
                           (7, 'Novela Filosofica'),
                           (8, 'Magia');

INSERT INTO editoriales VALUES (1, 'Bloomsbury Publishing'), 
                               (2, 'Francisco de Robles'),
                               (3, 'DAW Books'),
                               (4, 'Allen & Unwin' ),
                               (5, 'Johann Friedrich Unger');

INSERT INTO autores VALUES (1, 'John Ronald Reuel Tolkien', '03 01 1892', 6),
                           (2, 'Joanne K. Rowling', '31 07 1965', 2),
                           (3, 'Miguel de Cervantes Saavedra', '29 09 1547', 1),
                           (4, 'Johann Wolfgang von Goethe', '28 08 1749', 5),
                           (5, 'Alexandre Dumas Davy de la Pailleterie', '24 07 1802', 4),
                           (6, 'Patrick James Rothfuss', '6 6 1973',3);

INSERT INTO libros VALUES (1, 'Wilhelm Meisters Lehrjahre', '01 01 1795', 4, 7, 5), 
                          (2, 'Le Comte de Monte-Cristo', '01 01 1844', 5, 6, null), 
                          (3, 'Les Trois Mousquetaires', '01 07 1844', 5, 6, null), 
                          (4, 'The Fellowship of the Ring', '29 07 1954', 1, 1, 4), 
                          (5, 'The Two Towers', '11 11 1954', 1, 1, 4), 
                          (6, 'The Return of the King', '20 10 1955', 1, 1, 4), 
                          (7, 'Don Quijote de la Mancha', '01 01 1605', 3, 6, 2), 
                          (8, 'The Name of the Wind', '27 02 2007', 6, 1, 3), 
                          (9, 'The Wise Mans Fear', '01 03 2011', 6, 1, 6), 
                          (10, 'Philosophers Stone', '26 06 1997', 2, 8, 1), 
                          (11, 'Chamber of Secrets', '02 06 2998', 2, 8, 1), 
                          (12, 'Prisoner of Azkaban', '08 07 1999', 2, 8, 1), 
                          (13, 'Goblet of Fire', '08 07 2000', 2, 8, 1), 
                          (14, 'Order of the Phoenix', '21 06 2003', 2, 8, 1), 
                          (15, 'Half-Blood Prince', '16 07 2005', 2, 8, 1), 
                          (16, 'Deathly Hallows', '21 07 2007', 2, 8, 1);

