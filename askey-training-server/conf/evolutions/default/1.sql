# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table student (
  id                            uuid not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  user                          varchar(255),
  password                      varchar(255),
  birth_date                    timestamp,
  constraint pk_student primary key (id)
);


# --- !Downs

drop table if exists student;

