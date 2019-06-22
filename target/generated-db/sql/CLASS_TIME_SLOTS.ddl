drop table if exists CLASS_TIME_SLOTS;

create table CLASS_TIME_SLOTS
(
    TIME_SLOT_ID int not null,
    START_TIME date,
    END_TIME date,
    DAY varchar(255)
);

