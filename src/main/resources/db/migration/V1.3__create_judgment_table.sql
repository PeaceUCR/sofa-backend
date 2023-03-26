CREATE TABLE judgment
(
    id              character varying(36) PRIMARY KEY,
    rowKey          character varying(36),
    cause           character varying(256),
    title           character varying(256),
    courtName       character varying(256),
    caseNumber      character varying(128),
    opinion         text,
    date            character varying(64),
    civilLaws       character varying(256),
    criminalLaws    character varying(256),
    type            character varying(128),
    tags            JSON DEFAULT NULL
);

create UNIQUE INDEX index_example_rowKey on judgment (rowKey);
create index index_example_cause on judgment (cause);
create index index_example_courtName on judgment (courtName);
create index index_example_date on judgment (date);