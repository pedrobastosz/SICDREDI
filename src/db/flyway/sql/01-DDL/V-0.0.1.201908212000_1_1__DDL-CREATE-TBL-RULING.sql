CREATE TABLE RULING (
                ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                NAME VARCHAR(100) NOT NULL,
                CONSTRAINT PK_RULING PRIMARY KEY (ID)
);
CREATE INDEX IX_RULING_ID ON RULING(ID);

CREATE UNIQUE INDEX UK_RULING
 ON RULING
 ( NAME );