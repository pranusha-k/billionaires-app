CREATE TABLE IF NOT EXISTS
BILLIONAIRE (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    NETWORTH DOUBLE(255),
    COMPANIESOWNED VARCHAR(255),
    ICON BLOB
);

CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE;