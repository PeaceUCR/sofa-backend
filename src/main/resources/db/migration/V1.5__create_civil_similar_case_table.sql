CREATE TABLE civil_similar_case
(
    uniqid         character varying(36) PRIMARY KEY,
    casetype       character varying(64),
    `procedure`      character varying(64),
    referencetype  character varying(64),
    courtlevel     character varying(64),
    court          character varying(128),
    province       character varying(36),
    casecause      character varying(128),
    casecausefull  text,
    multicasecause text,
    judgedate      character varying(36),
    judgeyear      character varying(36),
    features       text,
    title          text,
    paragraphs     text
)