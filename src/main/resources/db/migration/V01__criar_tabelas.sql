CREATE TABLE cliente (
       	id_cliente  serial not null,
        endereco varchar(255) not null,
        nome varchar(255) not null,
        telefone varchar(255) not null,
        primary key (id_cliente)
    );

CREATE TABLE pet (
       	id_pet  serial not null,
        nome varchar(255) not null,
        raca varchar(255) not null,
        cliente_id int4,
        primary key (id_pet)
    );

alter table "pet"
       add constraint FK_cliente_pet
       foreign key (cliente_id)
       references cliente