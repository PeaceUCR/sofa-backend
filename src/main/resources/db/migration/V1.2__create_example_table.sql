CREATE TABLE example
(
    id              character varying(36) PRIMARY KEY,
    number          integer,
    title           character varying(256),
    type            character varying(128),
    extra           JSON DEFAULT NULL,
    text            text
);

create index index_user_collections_openid on user_collections (openId);
create index index_user_collections_collectionid on user_collections (collectionId);

create index index_example_type on example (type);
create index index_example_number on example (number);