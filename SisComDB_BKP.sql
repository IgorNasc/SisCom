--
-- PostgreSQL database cluster dump
--

-- Started on 2019-05-20 15:05:55

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md5946b2d99f0fb520fc4c5e5bc83effded';
CREATE ROLE siscom;
ALTER ROLE siscom WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION NOBYPASSRLS PASSWORD 'md575cc549b6dc45b62318c1cba3678448a';
COMMENT ON ROLE siscom IS 'Usuário para a aplicação siscom';






\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-05-20 15:05:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2019-05-20 15:05:56

--
-- PostgreSQL database dump complete
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-05-20 15:05:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2806 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


-- Completed on 2019-05-20 15:05:56

--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-05-20 15:05:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2828 (class 1262 OID 16393)
-- Name: siscom; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE siscom WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE siscom OWNER TO postgres;

\connect siscom

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 2828
-- Name: DATABASE siscom; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE siscom IS 'Sistema de comprar, para o trabalho de poo';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16405)
-- Name: fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedor (
    cnpj character varying(20) NOT NULL,
    nome_contato character varying(90) NOT NULL,
    codigo integer NOT NULL
);


ALTER TABLE public.fornecedor OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16401)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: siscom
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO siscom;

--
-- TOC entry 196 (class 1259 OID 16396)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    codigo integer NOT NULL,
    nome character varying(90) NOT NULL,
    telefones character varying(15),
    email character varying(90),
    data_cad date NOT NULL
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16403)
-- Name: pessoa_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pessoa ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pessoa_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2822 (class 0 OID 16405)
-- Dependencies: 199
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (cnpj, nome_contato, codigo) FROM stdin;
30782085000178	Teste	2
\.


--
-- TOC entry 2819 (class 0 OID 16396)
-- Dependencies: 196
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (codigo, nome, telefones, email, data_cad) FROM stdin;
1	Igor	31987679519	igornascimento060@gmail.com	2019-05-20
2	Teste	31987679519	\N	2019-05-20
\.


--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: siscom
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 2833 (class 0 OID 0)
-- Dependencies: 198
-- Name: pessoa_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_codigo_seq', 2, true);


--
-- TOC entry 2696 (class 2606 OID 16409)
-- Name: fornecedor pk_cnpj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT pk_cnpj PRIMARY KEY (cnpj);


--
-- TOC entry 2693 (class 2606 OID 16400)
-- Name: pessoa pk_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pk_id PRIMARY KEY (codigo);


--
-- TOC entry 2694 (class 1259 OID 16415)
-- Name: fki_pk_pessoa_codigo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_pk_pessoa_codigo ON public.fornecedor USING btree (codigo);


--
-- TOC entry 2697 (class 2606 OID 16416)
-- Name: fornecedor fp_pessoa_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fp_pessoa_codigo FOREIGN KEY (codigo) REFERENCES public.pessoa(codigo);


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE fornecedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.fornecedor TO siscom;


--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE pessoa; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.pessoa TO siscom;


--
-- TOC entry 1683 (class 826 OID 16395)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT SELECT,INSERT,DELETE,UPDATE ON TABLES  TO siscom;


-- Completed on 2019-05-20 15:05:56

--
-- PostgreSQL database dump complete
--

-- Completed on 2019-05-20 15:05:56

--
-- PostgreSQL database cluster dump complete
--

