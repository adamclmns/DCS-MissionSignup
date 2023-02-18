create table if not exists briefing_documents
(
    id        bigint       not null
    primary key,
    directory varchar(255) null,
    name      varchar(255) null
    );

create table if not exists callsigns
(
    id        bigint       not null
    primary key,
    prefix    varchar(255) null,
    suffix_01 int          null,
    suffix_02 int          null,
    suffix_03 int          null,
    suffix_04 int          null
    );

create table if not exists air_refule_info
(
    id            bigint       not null
    primary key,
    ac_type       varchar(255) null,
    offload       double       null,
    refule_system varchar(255) null,
    tacan         varchar(255) null,
    tnkr_alt      int          null,
    tnkr_cp       varchar(255) null,
    tnkr_speed    int          null,
    freq          double       null,
    name          varchar(255) null,
    frequency_id  bigint       null,
    tnkr_cs_id    bigint       null,
    constraint FK5qqcjgt2d7ge24nfbt2fv3cxh
    foreign key (tnkr_cs_id) references callsigns (id),
    constraint FKl7jy6lmsuevcs2w9woqacxgh
    foreign key (frequency_id) references air_refule_info (id)
    );

create table if not exists dual_end_times
(
    id      bigint      not null
    primary key,
    ingame  datetime(6) null,
    outgame datetime(6) null
    );

create table if not exists dual_start_times
(
    id      bigint      not null
    primary key,
    ingame  datetime(6) null,
    outgame datetime(6) null
    );

create table if not exists air_targeting_order
(
    id           bigint       not null
    primary key,
    identifier   varchar(255) null,
    name         varchar(255) null,
    timezone     varchar(255) null,
    time_from_id bigint       null,
    time_to_id   bigint       null,
    constraint FK2q87mkk7hx064qp9dprbjxev2
    foreign key (time_from_id) references dual_start_times (id),
    constraint FKn1h533udcp2b6qfflsirl0gt
    foreign key (time_to_id) references dual_end_times (id)
    );

create table if not exists mission_data
(
    id           bigint       not null
    primary key,
    mission_num  int          null,
    num_aircraft int          null,
    prim_msn     smallint     null,
    sec_msn      smallint     null,
    tasked_unit  varchar(255) null,
    ac_cs_id     bigint       null,
    constraint FKapy0b0bd4nw6dso97i7tcv9y2
    foreign key (ac_cs_id) references callsigns (id)
    );

create table if not exists flight_lines
(
    id        bigint       not null
    primary key,
    type      varchar(255) null,
    user01    varchar(255) null,
    user02    varchar(255) null,
    user03    varchar(255) null,
    user04    varchar(255) null,
    arinfo_id bigint       null,
    msndat_id bigint       null,
    constraint FKh8i2lcqfimogolopammvtm5np
    foreign key (arinfo_id) references air_refule_info (id),
    constraint FKp6q1ov04w1x5owkhhcexouwjb
    foreign key (msndat_id) references mission_data (id)
    );

create table if not exists air_targeting_order_flight_lines
(
    ato_table_id    bigint not null,
    flight_lines_id bigint not null,
    constraint UK_3sq8n0cy2ibhanbbtmdewsoem
    unique (flight_lines_id),
    constraint FK28yp116eouh77hnsfryet0kll
    foreign key (ato_table_id) references air_targeting_order (id),
    constraint FKrpbeucuvfap3ehw3xjw2ercsb
    foreign key (flight_lines_id) references flight_lines (id)
    );

