CREATE TABLE user_collections
(
    id           character varying(36) PRIMARY KEY,
    openId       character varying(36),
    collectionId character varying(36),
    type         character varying(128),
    title        character varying(255),
    time         timestamp
);

CREATE UNIQUE INDEX unq_openid_collectionid ON user_collections (openId, collectionId);