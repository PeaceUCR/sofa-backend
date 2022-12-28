CREATE TABLE user
(
    openId          character varying(36) PRIMARY KEY,
    collectionLimit integer,
    lastTimeLogin   timestamp,
    nickname        character varying(128),
    avatarUrl       character varying(256),
    score           integer
);