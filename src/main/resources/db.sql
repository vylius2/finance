CREATE DATABASE finance;

CREATE SEQUENCE public.record_categorie_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.record_categorie_id_seq
    OWNER TO finance;

CREATE SEQUENCE public.record_category_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.record_categorie_id_seq
    OWNER TO finance;

CREATE SEQUENCE public.record_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.record_id_seq
    OWNER TO finance;


CREATE TABLE public.record
(
    id bigint NOT NULL DEFAULT nextval('record_id_seq'::regclass),
    amount double precision NOT NULL,
    date timestamp without time zone,
    category_id bigint NOT NULL DEFAULT nextval('record_category_id_seq'::regclass),
    CONSTRAINT record_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

    ALTER TABLE public.record
        OWNER to finance;

CREATE TABLE public.category
(
    id bigint NOT NULL DEFAULT nextval('record_categorie_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default",
    record_type character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT record_categorie_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

    ALTER TABLE public.category
        OWNER to finance;

INSERT INTO category (name, record_type)
    VALUES ('Parduotuve' , 'OUTCOME');
INSERT INTO category (name, record_type)
    VALUES ('Transportas' , 'OUTCOME');
INSERT INTO category (name, record_type)
    VALUES ('Nuoma' , 'OUTCOME');

INSERT INTO category (name, record_type)
    VALUES ('Darbas' , 'INCOME');
INSERT INTO category (name, record_type)
    VALUES ('Dovana' , 'INCOME');
INSERT INTO category (name, record_type)
    VALUES ('Turto prievartavimas' , 'INCOME');

INSERT INTO record(amount, date, category_id)
    VALUES (200.21, '2020-06-12', 1);
INSERT INTO record(amount, date, category_id)
    VALUES (215.21, '2020-06-12', 3);
INSERT INTO record(amount, date, category_id)
    VALUES (150.21, '2020-06-12', 2);
INSERT INTO record(amount, date, category_id)
    VALUES (51.0, '2020-06-12', 2);

INSERT INTO record(amount, date, category_id)
    VALUES (500.83, '2020-06-12', 4);
INSERT INTO record(amount, date, category_id)
    VALUES (452.31, '2020-06-12', 5);
INSERT INTO record(amount, date, category_id)
    VALUES (451.31, '2020-06-12', 6);
INSERT INTO record(amount, date, category_id)
    VALUES (41.0, '2020-06-12', 4);