--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-06-10 17:46:45

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
-- TOC entry 205 (class 1259 OID 16551)
-- Name: item_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_venda (
    codigo integer NOT NULL,
    quant_venda integer NOT NULL,
    valor_venda numeric(9,2) NOT NULL,
    codigo_produto integer NOT NULL,
    codigo_venda integer NOT NULL
);


ALTER TABLE public.item_venda OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16805)
-- Name: item_venda_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.item_venda ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.item_venda_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2847 (class 0 OID 16551)
-- Dependencies: 205
-- Data for Name: item_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_venda (codigo, quant_venda, valor_venda, codigo_produto, codigo_venda) FROM stdin;
1	5	0.00	4	4
\.


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 211
-- Name: item_venda_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_venda_codigo_seq', 1, true);


--
-- TOC entry 2722 (class 2606 OID 16555)
-- Name: item_venda pk_itemVenda_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT "pk_itemVenda_codigo" PRIMARY KEY (codigo);


--
-- TOC entry 2725 (class 2606 OID 16779)
-- Name: item_venda fk5geyhnv5bkaywf80n7pv2tpm2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk5geyhnv5bkaywf80n7pv2tpm2 FOREIGN KEY (codigo) REFERENCES public.item_venda(codigo);


--
-- TOC entry 2723 (class 2606 OID 16556)
-- Name: item_venda fk_produto_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk_produto_codigo FOREIGN KEY (codigo_produto) REFERENCES public.produto(codigo);


--
-- TOC entry 2724 (class 2606 OID 16561)
-- Name: item_venda fk_venda_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk_venda_codigo FOREIGN KEY (codigo_venda) REFERENCES public.venda(codigo);


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE item_venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.item_venda TO siscom;


-- Completed on 2019-06-10 17:46:45

--
-- PostgreSQL database dump complete
--

