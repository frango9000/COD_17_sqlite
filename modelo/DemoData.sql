/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  NarF
 * Created: May 18, 2019
 */

INSERT INTO paises VALUES(1, 'España'),
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

INSERT INTO autores VALUES (1, 'John Ronald Reuel Tolkien', '1892-01-03 00:00:00.000', 6),
                           (2, 'Joanne K. Rowling', '1965-07-31 00:00:00.000', 2),
                           (3, 'Miguel de Cervantes Saavedra', '1547-09-29 00:00:00.000', 1),
                           (4, 'Johann Wolfgang von Goethe', '1749-08-28 00:00:00.000', 5),
                           (5, 'Alexandre Dumas Davy de la Pailleterie', '1802-07-24 00:00:00.000', 4),
                           (6, 'Patrick James Rothfuss', '1973-06-06 00:00:00.000',3);

INSERT INTO libros VALUES (1, 'Wilhelm Meisters Lehrjahre', '1795-01-01 00:00:00.000', 4, 7, 5), 
                          (2, 'Le Comte de Monte-Cristo', '1844-01-01 00:00:00.000', 5, 6, null), 
                          (3, 'Les Trois Mousquetaires', '1844-01-01 00:00:00.000', 5, 6, null), 
                          (4, 'The Fellowship of the Ring', '1954-01-29 00:00:00.000', 1, 1, 4), 
                          (5, 'The Two Towers', '1954-11-11 00:00:00.000', 1, 1, 4), 
                          (6, 'The Return of the King', '1955-10-20 00:00:00.000', 1, 1, 4), 
                          (7, 'Don Quijote de la Mancha', '1605-01-01 00:00:00.000', 3, 6, 2), 
                          (8, 'The Name of the Wind', '2007-02-27 00:00:00.000', 6, 1, 3), 
                          (9, 'The Wise Mans Fear', '2011-03-01 00:00:00.000', 6, 1, 6), 
                          (10, 'Philosophers Stone', '1997-06-26 00:00:00.000', 2, 8, 1), 
                          (11, 'Chamber of Secrets', '1998-06-02 00:00:00.000', 2, 8, 1), 
                          (12, 'Prisoner of Azkaban', '1999-07-08 00:00:00.000', 2, 8, 1), 
                          (13, 'Goblet of Fire', '2000-07-08 00:00:00.000', 2, 8, 1), 
                          (14, 'Order of the Phoenix', '2003-06-21 00:00:00.000', 2, 8, 1), 
                          (15, 'Half-Blood Prince', '2005-07-16 00:00:00.000', 2, 8, 1), 
                          (16, 'Deathly Hallows', '2007-07-21 00:00:00.000', 2, 8, 1);