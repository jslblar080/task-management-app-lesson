-- schema.sql: During startup, Spring Boot creates the schema and tables (match @NonNull for NOT NULL)
CREATE TABLE project_entity
(
    date_created DATE         NOT NULL,
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    internal_id  VARCHAR(255),
    name         VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);