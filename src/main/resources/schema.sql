create table if not exists player
(
    id bigserial not null,
    first_name varchar not null,
    last_name varchar not null,
    position varchar not null
);
