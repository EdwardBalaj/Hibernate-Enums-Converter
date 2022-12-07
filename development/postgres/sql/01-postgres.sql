alter role hib with password 'hib';

create table author (
    fullname text not null,
    constraint author_pk primary key (fullname)
);

create table book (
    book_id   integer generated always as identity not null,
    fullname  text                                 not null,
    date_from timestamptz                          not null,
    constraint book_pk primary key (book_id),
    constraint book_fullname_fk foreign key (fullname)
        references author (fullname) match full
        on delete restrict
        on update cascade
);

insert into author
values ('Arthur McKenzie');

insert into author
values ('Georgie Caldwell');

insert into book
    (fullname, date_from)
values
    ('Arthur McKenzie', now() - '2 day'::interval),
    ('Arthur McKenzie', now() - '1 day'::interval),
    ('Georgie Caldwell', now() - '2 day'::interval),
    ('Georgie Caldwell', now() - '1 day'::interval);