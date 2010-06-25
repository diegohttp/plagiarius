INSERT INTO "Ventana" ("idVentana", "nombreVentana") VALUES (1, 'JFAntiPlagiumPrincipal');

INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 1, 'JMUsuarios');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 2, 'JMIAdministrarUsuarios');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 3, 'JMIAdministrarRoles');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 4, 'JMILogDeUsuarios');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 5, 'JMDocumentos');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 6, 'JMIGestionarCategoria');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 7, 'JMIGestionarDocumento');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 8, 'JMDeteccion');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 9, 'JMICompararDocumentos');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 10, 'JMIMostrarResultados');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 11, 'JMReportes');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 12, 'JMIReporteComparaciones');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 13, 'JMIReporteDocumentos');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 14, 'JMSesion');
INSERT INTO "Control" ("idVentana", "idControl", nombre) VALUES (1, 15, 'JMICerrarSesion');

INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (1, 'Administrar Seguridad', 'Seguridad');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (3, 'Administrar Documentos', 'Documentos');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (6, 'Acceso a Log Usuarios', 'Log');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (2, 'Acceso a  Usuarios', 'Usuarios');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (7, 'Acceso a Categorias', 'Categorias');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (8, 'Acceso a Documentos', 'Documentos');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (4, 'Administrar Deteccion', 'Deteccion');
INSERT INTO "Privilegio" ("idPrivilegio", nombre, descripcion) VALUES (5, 'Administrar Reportes', 'Reportes');

INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 3);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 4);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (2, 1, 2);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (4, 1, 8);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (5, 1, 11);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (2, 1, 1);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 1);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 2);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 5);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 6);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 7);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 8);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 9);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 10);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (1, 1, 11);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (4, 1, 9);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (4, 1, 10);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (3, 1, 5);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (3, 1, 6);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (3, 1, 7);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (5, 1, 12);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (5, 1, 13);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (6, 1, 1);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (6, 1, 4);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (7, 1, 5);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (7, 1, 6);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (8, 1, 5);
INSERT INTO "ControlXPrivilegio" ("idPrivilegio", "idVentana", "idControl") VALUES (8, 1, 7);

INSERT INTO "Rol" ("idRol", nombre, estado) VALUES (1, 'Administrador', 'ACT');

INSERT INTO "RolXPrivilegio" ("idPrivilegio", "idRol") VALUES (1, 1);
INSERT INTO "RolXPrivilegio" ("idPrivilegio", "idRol") VALUES (2, 1);
INSERT INTO "RolXPrivilegio" ("idPrivilegio", "idRol") VALUES (3, 1);
INSERT INTO "RolXPrivilegio" ("idPrivilegio", "idRol") VALUES (4, 1);
INSERT INTO "RolXPrivilegio" ("idPrivilegio", "idRol") VALUES (5, 1);

INSERT INTO "Estado" ("idEstado", "Descripcion", "Nombre") VALUES (1, 'Cuenta de usuario vigente', 'Activo');
INSERT INTO "Estado" ("idEstado", "Descripcion", "Nombre") VALUES (2, 'Cuenta de usuario suspendida', 'Inactivo');

INSERT INTO "Usuario" ("idUsuario", nombres, "apellidoPaterno", "apellidoMaterno", "nombreUsuario", password, "fechaRegistro", "fechaVencimiento", "fechaCese", "idRol", "idTipoCese", "idEstado", email) VALUES (1, 'Piero', 'Cordero', 'Principe', 'piero', 'abcde', '2010-05-13', '2010-06-30', NULL, 1, NULL, 1, 'cordero.p@pucp.edu.pe');
