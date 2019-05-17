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
                	pais text NOT NULL
                    );

CREATE TABLE IF NOT EXISTS autores (
                        idAutor integer PRIMARY KEY, 
                        nombreAutor text NOT NULL, 
                        fechaNacimiento text, 
                        idPais integer NOT NULL,
                                FOREIGN KEY (idPais) REFERENCES nacionalidades (idPais)
                    );

CREATE TABLE IF NOT EXISTS editoriales (
                        idEditorial integer PRIMARY KEY,
                        nombreEditorial text NOT NULL
                    );

CREATE TABLE IF NOT EXISTS generos (
                        idGenero integer PRIMARY KEY,
                        genero text NOT NULL
                    );

CREATE TABLE IF NOT EXISTS libros (
                        idLibro integer PRIMARY KEY,
                        titulo text NOT NULL,
                        fechaPublicacion text NOT NULL,
                        idAutor integer NOT NULL REFERENCES autores (idAutor),
                        idGenero integer NOT NULL REFERENCES generos (idGenero),
                        idEditorial integer REFERENCES editoriales (idEditorial)
                    );