-- schema.sql: During startup, Spring Boot creates the schema and tables (match @NonNull for NOT NULL)
CREATE TABLE project_entity
(
    date_created DATE         NOT NULL,
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    internal_id  VARCHAR(255),
    name         VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE task_entity
(
    date_created      DATE         NOT NULL,
    due_date          DATE         NOT NULL,
    id                INTEGER      NOT NULL AUTO_INCREMENT,
    project_entity_id INTEGER      NOT NULL AUTO_INCREMENT,
    description       VARCHAR(255) NOT NULL,
    name              VARCHAR(255) NOT NULL,
    status            ENUM ('DONE','IN_PROGRESS','ON_HOLD','TO_DO'),
    PRIMARY KEY (id),
    FOREIGN KEY (project_entity_id) REFERENCES project_entity (id)
);