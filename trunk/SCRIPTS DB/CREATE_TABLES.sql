CREATE TABLE "Categoria" (
    "idCategoria" integer NOT NULL,
    descripcion character varying(100),
    nombre character varying(50)
);


ALTER TABLE public."Categoria" OWNER TO postgres;

--
-- TOC entry 1214 (class 1259 OID 16668)
-- Dependencies: 4
-- Name: Control; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Control" (
    "idVentana" integer NOT NULL,
    "idControl" integer NOT NULL,
    nombre character varying(30)
);


ALTER TABLE public."Control" OWNER TO postgres;

--
-- TOC entry 1215 (class 1259 OID 16672)
-- Dependencies: 4
-- Name: ControlXPrivilegio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "ControlXPrivilegio" (
    "idPrivilegio" integer NOT NULL,
    "idVentana" integer NOT NULL,
    "idControl" integer NOT NULL
);


ALTER TABLE public."ControlXPrivilegio" OWNER TO postgres;

--
-- TOC entry 1203 (class 1259 OID 16422)
-- Dependencies: 4
-- Name: Documento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Documento" (
    "idDocumento" integer NOT NULL,
    estado character varying(10),
    nombre character varying(50),
    "idUsuario" character varying(8),
    contenido text,
    "idCategoria" integer
);


ALTER TABLE public."Documento" OWNER TO postgres;

--
-- TOC entry 1204 (class 1259 OID 16426)
-- Dependencies: 4
-- Name: DocumentoXCategoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "DocumentoXCategoria" (
    "idDocumento" integer NOT NULL,
    "idCategoria" integer NOT NULL
);


ALTER TABLE public."DocumentoXCategoria" OWNER TO postgres;

--
-- TOC entry 1209 (class 1259 OID 16528)
-- Dependencies: 4
-- Name: Estado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Estado" (
    "idEstado" integer NOT NULL,
    "Descripcion" character varying,
    "Nombre" character varying
);


ALTER TABLE public."Estado" OWNER TO postgres;

--
-- TOC entry 1220 (class 1259 OID 16754)
-- Dependencies: 4
-- Name: Operacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Operacion" (
    "idOperacion" integer NOT NULL,
    "idUsuario" integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    "tipoOperacion" character varying(30) NOT NULL,
    descripcion character varying(500) NOT NULL,
    "nombreVentana" character varying
);


ALTER TABLE public."Operacion" OWNER TO postgres;

--
-- TOC entry 1219 (class 1259 OID 16752)
-- Dependencies: 4 1220
-- Name: Operacion_idOperacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Operacion_idOperacion_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public."Operacion_idOperacion_seq" OWNER TO postgres;

--
-- TOC entry 1598 (class 0 OID 0)
-- Dependencies: 1219
-- Name: Operacion_idOperacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Operacion_idOperacion_seq" OWNED BY "Operacion"."idOperacion";


--
-- TOC entry 1216 (class 1259 OID 16676)
-- Dependencies: 4
-- Name: Privilegio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Privilegio" (
    "idPrivilegio" integer NOT NULL,
    nombre character varying(25),
    descripcion character varying(25)
);


ALTER TABLE public."Privilegio" OWNER TO postgres;

--
-- TOC entry 1218 (class 1259 OID 16715)
-- Dependencies: 4
-- Name: ResultadoDeteccion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "ResultadoDeteccion" (
    "idResultadoDeteccion" integer NOT NULL,
    "Documento1" integer NOT NULL,
    "Documento2" integer NOT NULL,
    "PorcentajePlagio" integer,
    "Resultado" character varying(25),
    "Fecha" date
);


ALTER TABLE public."ResultadoDeteccion" OWNER TO postgres;

--
-- TOC entry 1205 (class 1259 OID 16434)
-- Dependencies: 4
-- Name: Rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Rol" (
    "idRol" smallint NOT NULL,
    nombre character varying(25),
    estado character varying(3)
);


ALTER TABLE public."Rol" OWNER TO postgres;

--
-- TOC entry 1206 (class 1259 OID 16438)
-- Dependencies: 4
-- Name: RolXPrivilegio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "RolXPrivilegio" (
    "idPrivilegio" integer NOT NULL,
    "idRol" integer NOT NULL
);


ALTER TABLE public."RolXPrivilegio" OWNER TO postgres;

--
-- TOC entry 1208 (class 1259 OID 16505)
-- Dependencies: 4
-- Name: TipoCese; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "TipoCese" (
    "IdTipoCese" integer NOT NULL,
    descripcion character varying(50),
    nombre character varying(20)
);


ALTER TABLE public."TipoCese" OWNER TO postgres;

--
-- TOC entry 1213 (class 1259 OID 16632)
-- Dependencies: 4
-- Name: Usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Usuario" (
    "idUsuario" integer NOT NULL,
    nombres character varying(40) NOT NULL,
    "apellidoPaterno" character varying(25) NOT NULL,
    "apellidoMaterno" character varying(25),
    "nombreUsuario" character varying(15) NOT NULL,
    password character varying(12) NOT NULL,
    "fechaRegistro" date,
    "fechaVencimiento" date,
    "fechaCese" date,
    "idRol" smallint,
    "idTipoCese" smallint,
    "idEstado" integer,
    email character varying
);


ALTER TABLE public."Usuario" OWNER TO postgres;

--
-- TOC entry 1207 (class 1259 OID 16446)
-- Dependencies: 4
-- Name: UsuarioXCategoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "UsuarioXCategoria" (
    "idUsuario" integer NOT NULL,
    "idCategoria" integer NOT NULL
);


ALTER TABLE public."UsuarioXCategoria" OWNER TO postgres;

--
-- TOC entry 1212 (class 1259 OID 16630)
-- Dependencies: 4 1213
-- Name: Usuario_idUsuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Usuario_idUsuario_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public."Usuario_idUsuario_seq" OWNER TO postgres;

--
-- TOC entry 1599 (class 0 OID 0)
-- Dependencies: 1212
-- Name: Usuario_idUsuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Usuario_idUsuario_seq" OWNED BY "Usuario"."idUsuario";


--
-- TOC entry 1217 (class 1259 OID 16680)
-- Dependencies: 4
-- Name: Ventana; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Ventana" (
    "idVentana" integer NOT NULL,
    "nombreVentana" character varying(30) NOT NULL
);


ALTER TABLE public."Ventana" OWNER TO postgres;

--
-- TOC entry 1211 (class 1259 OID 16573)
-- Dependencies: 4
-- Name: prueba; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prueba (
    "idPrueba" integer NOT NULL,
    nombre character varying(8)
);


ALTER TABLE public.prueba OWNER TO postgres;

--
-- TOC entry 1210 (class 1259 OID 16571)
-- Dependencies: 4 1211
-- Name: prueba_idPrueba_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "prueba_idPrueba_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public."prueba_idPrueba_seq" OWNER TO postgres;

--
-- TOC entry 1600 (class 0 OID 0)
-- Dependencies: 1210
-- Name: prueba_idPrueba_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "prueba_idPrueba_seq" OWNED BY prueba."idPrueba";


--
-- TOC entry 1543 (class 2604 OID 16756)
-- Dependencies: 1220 1219 1220
-- Name: idOperacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE "Operacion" ALTER COLUMN "idOperacion" SET DEFAULT nextval('"Operacion_idOperacion_seq"'::regclass);


--
-- TOC entry 1542 (class 2604 OID 16575)
-- Dependencies: 1211 1210 1211
-- Name: idPrueba; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE prueba ALTER COLUMN "idPrueba" SET DEFAULT nextval('"prueba_idPrueba_seq"'::regclass);


--
-- TOC entry 1545 (class 2606 OID 16413)
-- Dependencies: 1202 1202
-- Name: Categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Categoria"
    ADD CONSTRAINT "Categoria_pkey" PRIMARY KEY ("idCategoria");


--
-- TOC entry 1568 (class 2606 OID 16675)
-- Dependencies: 1215 1215 1215 1215
-- Name: ControlXPrivilegio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "ControlXPrivilegio"
    ADD CONSTRAINT "ControlXPrivilegio_pkey" PRIMARY KEY ("idPrivilegio", "idVentana", "idControl");


--
-- TOC entry 1566 (class 2606 OID 16671)
-- Dependencies: 1214 1214 1214
-- Name: Control_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Control"
    ADD CONSTRAINT "Control_pkey" PRIMARY KEY ("idVentana", "idControl");


--
-- TOC entry 1550 (class 2606 OID 16429)
-- Dependencies: 1204 1204 1204
-- Name: DocumentoXCategoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "DocumentoXCategoria"
    ADD CONSTRAINT "DocumentoXCategoria_pkey" PRIMARY KEY ("idDocumento", "idCategoria");


--
-- TOC entry 1547 (class 2606 OID 16425)
-- Dependencies: 1203 1203
-- Name: Documento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Documento"
    ADD CONSTRAINT "Documento_pkey" PRIMARY KEY ("idDocumento");


--
-- TOC entry 1560 (class 2606 OID 16534)
-- Dependencies: 1209 1209
-- Name: Estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Estado"
    ADD CONSTRAINT "Estado_pkey" PRIMARY KEY ("idEstado");


--
-- TOC entry 1574 (class 2606 OID 16821)
-- Dependencies: 1218 1218
-- Name: PKIdResultadoDeteccion; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "ResultadoDeteccion"
    ADD CONSTRAINT "PKIdResultadoDeteccion" PRIMARY KEY ("idResultadoDeteccion");


--
-- TOC entry 1570 (class 2606 OID 16679)
-- Dependencies: 1216 1216
-- Name: Privilegio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Privilegio"
    ADD CONSTRAINT "Privilegio_pkey" PRIMARY KEY ("idPrivilegio");


--
-- TOC entry 1554 (class 2606 OID 16441)
-- Dependencies: 1206 1206 1206
-- Name: RolXPrivilegio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "RolXPrivilegio"
    ADD CONSTRAINT "RolXPrivilegio_pkey" PRIMARY KEY ("idPrivilegio", "idRol");


--
-- TOC entry 1552 (class 2606 OID 16437)
-- Dependencies: 1205 1205
-- Name: Rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Rol"
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY ("idRol");


--
-- TOC entry 1558 (class 2606 OID 16508)
-- Dependencies: 1208 1208
-- Name: TipoCese_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "TipoCese"
    ADD CONSTRAINT "TipoCese_pkey" PRIMARY KEY ("IdTipoCese");


--
-- TOC entry 1556 (class 2606 OID 16449)
-- Dependencies: 1207 1207 1207
-- Name: UsuarioXCategoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "UsuarioXCategoria"
    ADD CONSTRAINT "UsuarioXCategoria_pkey" PRIMARY KEY ("idUsuario", "idCategoria");


--
-- TOC entry 1564 (class 2606 OID 16636)
-- Dependencies: 1213 1213
-- Name: Usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY ("idUsuario");


--
-- TOC entry 1572 (class 2606 OID 16683)
-- Dependencies: 1217 1217
-- Name: Ventana_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Ventana"
    ADD CONSTRAINT "Ventana_pkey" PRIMARY KEY ("idVentana");


--
-- TOC entry 1576 (class 2606 OID 16770)
-- Dependencies: 1220 1220
-- Name: primaryKey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Operacion"
    ADD CONSTRAINT "primaryKey" PRIMARY KEY ("idOperacion");


--
-- TOC entry 1562 (class 2606 OID 16577)
-- Dependencies: 1211 1211
-- Name: prueba_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prueba
    ADD CONSTRAINT prueba_pkey PRIMARY KEY ("idPrueba");


--
-- TOC entry 1548 (class 1259 OID 16629)
-- Dependencies: 1203
-- Name: fki_Usuario_Documento; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_Usuario_Documento" ON "Documento" USING btree ("idUsuario");


--
-- TOC entry 1578 (class 2606 OID 16450)
-- Dependencies: 1204 1202 1544
-- Name: Categoria_DocumentoXCategoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "DocumentoXCategoria"
    ADD CONSTRAINT "Categoria_DocumentoXCategoria" FOREIGN KEY ("idCategoria") REFERENCES "Categoria"("idCategoria");


--
-- TOC entry 1582 (class 2606 OID 16455)
-- Dependencies: 1207 1202 1544
-- Name: Categoria_UsuarioXCategoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "UsuarioXCategoria"
    ADD CONSTRAINT "Categoria_UsuarioXCategoria" FOREIGN KEY ("idCategoria") REFERENCES "Categoria"("idCategoria");


--
-- TOC entry 1588 (class 2606 OID 16684)
-- Dependencies: 1215 1215 1214 1214 1565
-- Name: Control_ControlXPrivilegio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ControlXPrivilegio"
    ADD CONSTRAINT "Control_ControlXPrivilegio" FOREIGN KEY ("idVentana", "idControl") REFERENCES "Control"("idVentana", "idControl");


--
-- TOC entry 1590 (class 2606 OID 16822)
-- Dependencies: 1218 1203 1546
-- Name: Documento1_DocumentoId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ResultadoDeteccion"
    ADD CONSTRAINT "Documento1_DocumentoId" FOREIGN KEY ("Documento1") REFERENCES "Documento"("idDocumento");


--
-- TOC entry 1591 (class 2606 OID 16827)
-- Dependencies: 1218 1203 1546
-- Name: Documento2_DocumentoId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ResultadoDeteccion"
    ADD CONSTRAINT "Documento2_DocumentoId" FOREIGN KEY ("Documento2") REFERENCES "Documento"("idDocumento");


--
-- TOC entry 1579 (class 2606 OID 16465)
-- Dependencies: 1204 1203 1546
-- Name: Documento_DocumentoXCategoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "DocumentoXCategoria"
    ADD CONSTRAINT "Documento_DocumentoXCategoria" FOREIGN KEY ("idDocumento") REFERENCES "Documento"("idDocumento");


--
-- TOC entry 1584 (class 2606 OID 16637)
-- Dependencies: 1213 1209 1559
-- Name: Estado_Usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Usuario"
    ADD CONSTRAINT "Estado_Usuario" FOREIGN KEY ("idEstado") REFERENCES "Estado"("idEstado");


--
-- TOC entry 1589 (class 2606 OID 16694)
-- Dependencies: 1215 1216 1569
-- Name: Privilegio_ControlXPrivilegio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ControlXPrivilegio"
    ADD CONSTRAINT "Privilegio_ControlXPrivilegio" FOREIGN KEY ("idPrivilegio") REFERENCES "Privilegio"("idPrivilegio");


--
-- TOC entry 1581 (class 2606 OID 16689)
-- Dependencies: 1206 1216 1569
-- Name: Privilegio_RolXPrivilegio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "RolXPrivilegio"
    ADD CONSTRAINT "Privilegio_RolXPrivilegio" FOREIGN KEY ("idPrivilegio") REFERENCES "Privilegio"("idPrivilegio");


--
-- TOC entry 1580 (class 2606 OID 16485)
-- Dependencies: 1206 1205 1551
-- Name: Rol_RolXPrivilegio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "RolXPrivilegio"
    ADD CONSTRAINT "Rol_RolXPrivilegio" FOREIGN KEY ("idRol") REFERENCES "Rol"("idRol");


--
-- TOC entry 1586 (class 2606 OID 16663)
-- Dependencies: 1213 1205 1551
-- Name: Rol_Usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Usuario"
    ADD CONSTRAINT "Rol_Usuario" FOREIGN KEY ("idRol") REFERENCES "Rol"("idRol");


--
-- TOC entry 1585 (class 2606 OID 16647)
-- Dependencies: 1213 1208 1557
-- Name: TipoCese_Usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Usuario"
    ADD CONSTRAINT "TipoCese_Usuario" FOREIGN KEY ("idTipoCese") REFERENCES "TipoCese"("IdTipoCese");


--
-- TOC entry 1577 (class 2606 OID 16653)
-- Dependencies: 1203 1213 1563
-- Name: Usuario_Documento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY "Documento"
--    ADD CONSTRAINT "Usuario_Documento" FOREIGN KEY ("idUsuario") REFERENCES "Usuario"("idUsuario");


--
-- TOC entry 1583 (class 2606 OID 16658)
-- Dependencies: 1207 1213 1563
-- Name: Usuario_UsuarioXCategoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "UsuarioXCategoria"
    ADD CONSTRAINT "Usuario_UsuarioXCategoria" FOREIGN KEY ("idUsuario") REFERENCES "Usuario"("idUsuario");


--
-- TOC entry 1592 (class 2606 OID 16771)
-- Dependencies: 1220 1213 1563
-- Name: operacion_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Operacion"
    ADD CONSTRAINT operacion_usuario FOREIGN KEY ("idUsuario") REFERENCES "Usuario"("idUsuario");


--
-- TOC entry 1587 (class 2606 OID 16699)
-- Dependencies: 1214 1217 1571
-- Name: ventana_control; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Control"
    ADD CONSTRAINT ventana_control FOREIGN KEY ("idVentana") REFERENCES "Ventana"("idVentana");


--
-- TOC entry 1597 (class 0 OID 0)
-- Dependencies: 4
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-06-24 17:37:08

--
-- PostgreSQL database dump complete
--

