drop table if exists DEPARTMENTS;

create table DEPARTMENTS
(
    DEPARTMENT_ID int not null,
    DEPARTMENT_NAME varchar(255),
    COURSE_ID int,
    MAJOR_ID int
);

