CREATE TABLE user_collections
(
    id           character varying(36) PRIMARY KEY,
    openid       character varying(36),
    collectionid character varying(36),
    type         character varying(32),
    title        character varying(255),
    time         timestamp
);

CREATE UNIQUE INDEX unq_openid_collectionid ON user_collections (openid, collectionid);