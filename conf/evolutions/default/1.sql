# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tbtestweb (
  id                        integer not null,
  descrip                   varchar(255),
  constraint pk_tbtestweb primary key (id))
;

create sequence tbtestweb_seq;




# --- !Downs

drop table if exists tbtestweb cascade;

drop sequence if exists tbtestweb_seq;

