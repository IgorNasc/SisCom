--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-05-27 17:38:25

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16396)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    codigo integer NOT NULL,
    nome character varying(90) NOT NULL,
    telefones character varying(15),
    email character varying(90),
    data_cad date DEFAULT now()
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
-- TOC entry 2841 (class 0 OID 16396)
-- Dependencies: 196
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (codigo, nome, telefones, email, data_cad) FROM stdin;
1	Igor	31987679519	igornascimento060@gmail.com	2019-05-20
2	Teste	31987679519	\N	2019-05-20
6	Fornecedor	31987679519	fornecedor@gmail.com	\N
7	Fornecedor	31987679519	fornecedor@gmail.com	\N
8	Cliente	31987679519	cliente@gmail.com	\N
9	Vendedor	31987679519	vendedor@gmail.com	\N
\.


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 198
-- Name: pessoa_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_codigo_seq', 9, true);


--
-- TOC entry 2719 (class 2606 OID 16400)
-- Name: pessoa pk_pessoa_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pk_pessoa_codigo PRIMARY KEY (codigo);


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE pessoa; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.pessoa TO siscom;


-- Completed on 2019-05-27 17:38:25

--
-- PostgreSQL database dump complete
--

