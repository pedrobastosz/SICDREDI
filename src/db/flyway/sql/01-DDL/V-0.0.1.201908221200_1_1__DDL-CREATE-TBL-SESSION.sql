CREATE TABLE SESSION (
                ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                START TIMESTAMP NOT NULL,
                DURATION NUMERIC(10,0) NOT NULL,
                ID_RULING BIGINT NOT NULL,
                CONSTRAINT PK_SESSION PRIMARY KEY (ID)
);
CREATE INDEX IX_SESSION_ID ON SESSION(ID);

ALTER TABLE SESSION ADD CONSTRAINT FK_SESSION_X_RULING
FOREIGN KEY (ID_RULING)
REFERENCES RULING (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION;