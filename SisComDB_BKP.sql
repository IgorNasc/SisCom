--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-06-12 14:09:36

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
-- TOC entry 200 (class 1259 OID 16422)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cpf character varying(20) NOT NULL,
    limite_credito double precision,
    codigo integer NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16492)
-- Name: compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compra (
    codigo integer NOT NULL,
    data_compra date DEFAULT now(),
    codigo_fornecedor integer NOT NULL
);


ALTER TABLE public.compra OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16762)
-- Name: compra_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.compra ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.compra_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


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
-- TOC entry 206 (class 1259 OID 16626)
-- Name: item_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_compra (
    codigo integer NOT NULL,
    quant_compra integer NOT NULL,
    valor_compra numeric(9,2) NOT NULL,
    codigo_produto integer NOT NULL,
    codigo_compra integer NOT NULL
);


ALTER TABLE public.item_compra OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16771)
-- Name: item_compra_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.item_compra ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.item_compra_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


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
-- TOC entry 203 (class 1259 OID 16529)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    codigo integer NOT NULL,
    nome character varying(90) NOT NULL,
    preco_unitario double precision NOT NULL,
    estoque integer NOT NULL,
    estoque_minimo integer,
    data_cad date DEFAULT now() NOT NULL
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16758)
-- Name: produto_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.produto ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.produto_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 16535)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    codigo integer NOT NULL,
    forma_pagto integer NOT NULL,
    data_venda date DEFAULT now() NOT NULL,
    codigo_vendedor integer NOT NULL,
    codigo_cliente integer NOT NULL
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16803)
-- Name: venda_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.venda ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.venda_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 16435)
-- Name: vendedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendedor (
    cpf character varying(20) NOT NULL,
    meta_mensal double precision NOT NULL,
    codigo integer NOT NULL
);


ALTER TABLE public.vendedor OWNER TO postgres;

--
-- TOC entry 2895 (class 0 OID 16422)
-- Dependencies: 200
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cpf, limite_credito, codigo) FROM stdin;
15478625635	500	41
15875632535	900	42
\.


--
-- TOC entry 2897 (class 0 OID 16492)
-- Dependencies: 202
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compra (codigo, data_compra, codigo_fornecedor) FROM stdin;
14	2019-06-12	37
16	2019-06-12	37
\.


--
-- TOC entry 2894 (class 0 OID 16405)
-- Dependencies: 199
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (cnpj, nome_contato, codigo) FROM stdin;
54130750000107	Sr. Heineken	37
\.


--
-- TOC entry 2901 (class 0 OID 16626)
-- Dependencies: 206
-- Data for Name: item_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_compra (codigo, quant_compra, valor_compra, codigo_produto, codigo_compra) FROM stdin;
6	10	33.00	8	14
8	20	66.00	8	16
\.


--
-- TOC entry 2900 (class 0 OID 16551)
-- Dependencies: 205
-- Data for Name: item_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_venda (codigo, quant_venda, valor_venda, codigo_produto, codigo_venda) FROM stdin;
3	5	16.50	8	9
4	1	20.00	9	9
5	2	40.00	7	10
\.


--
-- TOC entry 2891 (class 0 OID 16396)
-- Dependencies: 196
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (codigo, nome, telefones, email, data_cad) FROM stdin;
32	Castro	31965522325	castrao@gmail.com	2019-06-12
37	Heineken	31925642827	heineken@gmail.com	2019-06-12
41	Julio	31965256324	julio@gmail.com	2019-06-12
42	Clara	31964752125	clara@gmail.com	2019-06-12
43	Luiz	31965254126	luiz@gmail.com	2019-06-12
\.


--
-- TOC entry 2898 (class 0 OID 16529)
-- Dependencies: 203
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (codigo, nome, preco_unitario, estoque, estoque_minimo, data_cad) FROM stdin;
8	Cerveja Heineken Premium Long Neck 330 ml	3.29999999999999982	75	20	2019-06-12
9	Blusa Verde	20	14	20	2019-06-12
7	Blusa Azul	20	58	15	2019-06-12
\.


--
-- TOC entry 2899 (class 0 OID 16535)
-- Dependencies: 204
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (codigo, forma_pagto, data_venda, codigo_vendedor, codigo_cliente) FROM stdin;
9	3	2019-06-12	32	42
10	2	2019-06-12	43	41
\.


--
-- TOC entry 2896 (class 0 OID 16435)
-- Dependencies: 201
-- Data for Name: vendedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendedor (cpf, meta_mensal, codigo) FROM stdin;
25657425635	100	32
25487526535	400	43
\.


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 208
-- Name: compra_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.compra_codigo_seq', 16, true);


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: siscom
--

SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);


--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 209
-- Name: item_compra_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_compra_codigo_seq', 8, true);


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 211
-- Name: item_venda_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_venda_codigo_seq', 5, true);


--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 198
-- Name: pessoa_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_codigo_seq', 43, true);


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 207
-- Name: produto_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_codigo_seq', 9, true);


--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 210
-- Name: venda_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_codigo_seq', 10, true);


--
-- TOC entry 2741 (class 2606 OID 16695)
-- Name: cliente pk_cliente_cpf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente_cpf PRIMARY KEY (cpf);


--
-- TOC entry 2749 (class 2606 OID 16637)
-- Name: compra pk_compra_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT pk_compra_codigo PRIMARY KEY (codigo);


--
-- TOC entry 2737 (class 2606 OID 16674)
-- Name: fornecedor pk_fornecedor_cnpj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT pk_fornecedor_cnpj PRIMARY KEY (cnpj);


--
-- TOC entry 2757 (class 2606 OID 16630)
-- Name: item_compra pk_itemCompra_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_compra
    ADD CONSTRAINT "pk_itemCompra_codigo" PRIMARY KEY (codigo);


--
-- TOC entry 2755 (class 2606 OID 16555)
-- Name: item_venda pk_itemVenda_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT "pk_itemVenda_codigo" PRIMARY KEY (codigo);


--
-- TOC entry 2735 (class 2606 OID 16400)
-- Name: pessoa pk_pessoa_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pk_pessoa_codigo PRIMARY KEY (codigo);


--
-- TOC entry 2751 (class 2606 OID 16534)
-- Name: produto pk_produto_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT pk_produto_codigo PRIMARY KEY (codigo);


--
-- TOC entry 2753 (class 2606 OID 16540)
-- Name: venda pk_venda_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT pk_venda_codigo PRIMARY KEY (codigo);


--
-- TOC entry 2745 (class 2606 OID 16439)
-- Name: vendedor pk_vendedor_cpf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedor
    ADD CONSTRAINT pk_vendedor_cpf PRIMARY KEY (cpf);


--
-- TOC entry 2743 (class 2606 OID 16792)
-- Name: cliente uk_cliente_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT uk_cliente_codigo UNIQUE (codigo);


--
-- TOC entry 2739 (class 2606 OID 16765)
-- Name: fornecedor uk_fornecedor_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT uk_fornecedor_codigo UNIQUE (codigo);


--
-- TOC entry 2747 (class 2606 OID 16785)
-- Name: vendedor uk_vendedor_codigo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedor
    ADD CONSTRAINT uk_vendedor_codigo UNIQUE (codigo);


--
-- TOC entry 2769 (class 2606 OID 16774)
-- Name: item_compra fk2l4fw6ot8i4ay3edxs27wpawe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_compra
    ADD CONSTRAINT fk2l4fw6ot8i4ay3edxs27wpawe FOREIGN KEY (codigo) REFERENCES public.item_compra(codigo);


--
-- TOC entry 2766 (class 2606 OID 16779)
-- Name: item_venda fk5geyhnv5bkaywf80n7pv2tpm2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk5geyhnv5bkaywf80n7pv2tpm2 FOREIGN KEY (codigo) REFERENCES public.item_venda(codigo);


--
-- TOC entry 2759 (class 2606 OID 16701)
-- Name: cliente fk_cliente_pessoa_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_pessoa_codigo FOREIGN KEY (codigo) REFERENCES public.pessoa(codigo);


--
-- TOC entry 2768 (class 2606 OID 16638)
-- Name: item_compra fk_compra_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_compra
    ADD CONSTRAINT fk_compra_codigo FOREIGN KEY (codigo_compra) REFERENCES public.compra(codigo);


--
-- TOC entry 2761 (class 2606 OID 16766)
-- Name: compra fk_compra_fornecedor_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT fk_compra_fornecedor_codigo FOREIGN KEY (codigo_fornecedor) REFERENCES public.fornecedor(codigo);


--
-- TOC entry 2758 (class 2606 OID 16675)
-- Name: fornecedor fk_fornecedor_pessoa_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fk_fornecedor_pessoa_codigo FOREIGN KEY (codigo) REFERENCES public.pessoa(codigo);


--
-- TOC entry 2764 (class 2606 OID 16556)
-- Name: item_venda fk_produto_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk_produto_codigo FOREIGN KEY (codigo_produto) REFERENCES public.produto(codigo);


--
-- TOC entry 2767 (class 2606 OID 16631)
-- Name: item_compra fk_produto_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_compra
    ADD CONSTRAINT fk_produto_codigo FOREIGN KEY (codigo_produto) REFERENCES public.produto(codigo);


--
-- TOC entry 2763 (class 2606 OID 16798)
-- Name: venda fk_venda_cliente_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT fk_venda_cliente_codigo FOREIGN KEY (codigo_cliente) REFERENCES public.cliente(codigo);


--
-- TOC entry 2765 (class 2606 OID 16561)
-- Name: item_venda fk_venda_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk_venda_codigo FOREIGN KEY (codigo_venda) REFERENCES public.venda(codigo);


--
-- TOC entry 2762 (class 2606 OID 16793)
-- Name: venda fk_venda_vendedor_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT fk_venda_vendedor_codigo FOREIGN KEY (codigo_vendedor) REFERENCES public.vendedor(codigo);


--
-- TOC entry 2760 (class 2606 OID 16748)
-- Name: vendedor fk_vendedor_pessoa_codigo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedor
    ADD CONSTRAINT fk_vendedor_pessoa_codigo FOREIGN KEY (codigo) REFERENCES public.pessoa(codigo);


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 200
-- Name: TABLE cliente; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.cliente TO siscom;


--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE compra; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.compra TO siscom;


--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE fornecedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.fornecedor TO siscom;


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE item_compra; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.item_compra TO siscom;


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE item_venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.item_venda TO siscom;


--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE pessoa; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.pessoa TO siscom;


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE produto; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.produto TO siscom;


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.venda TO siscom;


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE vendedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.vendedor TO siscom;


--
-- TOC entry 1721 (class 826 OID 16395)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT SELECT,INSERT,DELETE,UPDATE ON TABLES  TO siscom;


-- Completed on 2019-06-12 14:09:36

--
-- PostgreSQL database dump complete
--

