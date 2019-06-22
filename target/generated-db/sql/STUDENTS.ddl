drop table if exists STUDENTS;

create table STUDENTS
(
    STUDENT_ID int not null,
    MAJOR_ID int,
    GPA int,
    ADMISSION_DATE date,
    EXPECTED_GRADUATION date,
    PERSON_ID int,
    COURSE_ID int
);

