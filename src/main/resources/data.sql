-- insertar datos owners
INSERT INTO Owner(nombre, direccion) values ('Agustin','Buenos Aires');
INSERT INTO Owner(nombre,direccion) values ('Juan', 'Cordoba');
INSERT INTO Owner(nombre,direccion) values ('Roman', 'Boca');

-- insertar datos de mascotas
INSERT INTO Pet(nombre, especie, edad, owner_id) values ('Lara','gato','4',1);
INSERT INTO Pet(nombre, especie, edad, owner_id) values ('juan','perro','3',2);
INSERT INTO Pet(nombre, especie, edad, owner_id) values ('campuzano','perro','26',3);