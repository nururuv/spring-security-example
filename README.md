# spring-security-example

SpringSecurity を導入した実装のサンプル

## DB SETUP

パスワードはハッシュ化されている、初期投入のパスワードは「pass」

CREATE DATABASE spring_security_test;

CREATE TABLE public.user_info(
user_name varchar (255)
, password varchar (255)
, role INTEGER
, initial_password_flag boolean
);

INSERT
INTO public.user_info(
user_name
, password
, role
, initial_password_flag
)
VALUES (
'general'
, '$2a$08$SPEVLX1G/UmOpm2IbQTdmOaOolrNMpNpSayn/E62Gn9B83XntgBgS'
, 1
, true
)
, (
'admin'
, '$2a$08$SPEVLX1G/UmOpm2IbQTdmOaOolrNMpNpSayn/E62Gn9B83XntgBgS'
, 2
, true
);

CREATE TABLE authority(id INTEGER, name varchar (255));

INSERT
INTO authority(id, name)
VALUES (1, 'ROLE_AUTHORITY1')
, (2, 'ROLE_AUTHORITY2');

CREATE TABLE public.role_authorities(role_id INTEGER, authority_id INTEGER);

INSERT
INTO public.role_authorities(role_id, authority_id)
VALUES (1, 1)
, (2, 1)
, (2, 2);
