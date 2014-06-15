create sequence  ARTICLE_ID_SEQUENCE;

create table Articles (
id int8 not null,
title varchar(255),
content varchar(255), 
author  varchar(255),
WHEN_DATE date 
);

--------------- CONSTRAINTS -----------------------------------------------------------

alter table Articles add constraint Article_PK1 primary key (id);
alter table Articles add constraint Articles_unq1   unique (title);

------------------- INDEXES ----------------------------------------------------

create index Articles_pk_idx on  Articles (id);
create index Articles_unq_idx on  Articles(title);



