drop table if exists COURSES;

create table COURSES
(
    COURSE_ID int not null,
    TIME_SLOT int,
    SEMESTER varchar(255),
    START_DATE date,
    END_DATE date,
    LECTURE_HALL_ID int
);

