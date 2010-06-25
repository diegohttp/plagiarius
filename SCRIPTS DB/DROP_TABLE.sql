ALTER TABLE ONLY public."Control" DROP CONSTRAINT ventana_control;
ALTER TABLE ONLY public."Operacion" DROP CONSTRAINT operacion_usuario;
ALTER TABLE ONLY public."UsuarioXCategoria" DROP CONSTRAINT "Usuario_UsuarioXCategoria";
--ALTER TABLE ONLY public."Documento" DROP CONSTRAINT "Usuario_Documento";
ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "TipoCese_Usuario";
ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Rol_Usuario";
ALTER TABLE ONLY public."RolXPrivilegio" DROP CONSTRAINT "Rol_RolXPrivilegio";
ALTER TABLE ONLY public."RolXPrivilegio" DROP CONSTRAINT "Privilegio_RolXPrivilegio";
ALTER TABLE ONLY public."ControlXPrivilegio" DROP CONSTRAINT "Privilegio_ControlXPrivilegio";
ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Estado_Usuario";
ALTER TABLE ONLY public."DocumentoXCategoria" DROP CONSTRAINT "Documento_DocumentoXCategoria";
ALTER TABLE ONLY public."ResultadoDeteccion" DROP CONSTRAINT "Documento2_DocumentoId";
ALTER TABLE ONLY public."ResultadoDeteccion" DROP CONSTRAINT "Documento1_DocumentoId";
ALTER TABLE ONLY public."ControlXPrivilegio" DROP CONSTRAINT "Control_ControlXPrivilegio";
ALTER TABLE ONLY public."UsuarioXCategoria" DROP CONSTRAINT "Categoria_UsuarioXCategoria";
ALTER TABLE ONLY public."DocumentoXCategoria" DROP CONSTRAINT "Categoria_DocumentoXCategoria";
DROP INDEX public."fki_Usuario_Documento";
ALTER TABLE ONLY public.prueba DROP CONSTRAINT prueba_pkey;
ALTER TABLE ONLY public."Operacion" DROP CONSTRAINT "primaryKey";
ALTER TABLE ONLY public."Ventana" DROP CONSTRAINT "Ventana_pkey";
ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Usuario_pkey";
ALTER TABLE ONLY public."UsuarioXCategoria" DROP CONSTRAINT "UsuarioXCategoria_pkey";
ALTER TABLE ONLY public."TipoCese" DROP CONSTRAINT "TipoCese_pkey";
ALTER TABLE ONLY public."Rol" DROP CONSTRAINT "Rol_pkey";
ALTER TABLE ONLY public."RolXPrivilegio" DROP CONSTRAINT "RolXPrivilegio_pkey";
ALTER TABLE ONLY public."Privilegio" DROP CONSTRAINT "Privilegio_pkey";
ALTER TABLE ONLY public."ResultadoDeteccion" DROP CONSTRAINT "PKIdResultadoDeteccion";
ALTER TABLE ONLY public."Estado" DROP CONSTRAINT "Estado_pkey";
ALTER TABLE ONLY public."Documento" DROP CONSTRAINT "Documento_pkey";
ALTER TABLE ONLY public."DocumentoXCategoria" DROP CONSTRAINT "DocumentoXCategoria_pkey";
ALTER TABLE ONLY public."Control" DROP CONSTRAINT "Control_pkey";
ALTER TABLE ONLY public."ControlXPrivilegio" DROP CONSTRAINT "ControlXPrivilegio_pkey";
ALTER TABLE ONLY public."Categoria" DROP CONSTRAINT "Categoria_pkey";
ALTER TABLE public.prueba ALTER COLUMN "idPrueba" DROP DEFAULT;
ALTER TABLE public."Operacion" ALTER COLUMN "idOperacion" DROP DEFAULT;
DROP SEQUENCE public."prueba_idPrueba_seq";
DROP TABLE public.prueba;
DROP TABLE public."Ventana";
DROP SEQUENCE public."Usuario_idUsuario_seq";
DROP TABLE public."UsuarioXCategoria";
DROP TABLE public."Usuario";
DROP TABLE public."TipoCese";
DROP TABLE public."RolXPrivilegio";
DROP TABLE public."Rol";
DROP TABLE public."ResultadoDeteccion";
DROP TABLE public."Privilegio";
DROP SEQUENCE public."Operacion_idOperacion_seq";
DROP TABLE public."Operacion";
DROP TABLE public."Estado";
DROP TABLE public."DocumentoXCategoria";
DROP TABLE public."Documento";
DROP TABLE public."ControlXPrivilegio";
DROP TABLE public."Control";
DROP TABLE public."Categoria";