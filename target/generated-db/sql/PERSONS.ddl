drop table if exists PERSONS;

create table PERSONS
(
    PERSON_ID int not null,
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    OTHER_NAMES varchar(255),
    AGE int,
    GENDER_ID int,
    MARITAL_STATUS_ID int,
    NATIONALITY_ID int
);

