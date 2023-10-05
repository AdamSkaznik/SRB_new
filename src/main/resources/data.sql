/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

/*Data for the table roles */

insert  into tab_role(id,role_name) values (1,'ADMIN');
insert  into tab_role(id,role_name) values (2,'MANAGER');
insert  into tab_role(id,role_name) values (3,'ANALYST');
insert  into tab_role(id,role_name) values (4,'OFFICER');

/*Data for then table users */

insert into tab_users(id, is_active, login, password) values (1, true, 'admin', '$2a$10$E5IdyCTDQkaZNRYeA205xOrU7dyp77mh3pDNRhhBOuaW1gBDo00mi');

/*Data for the table user_role */

insert into user_role(user_id, role_id) values (1,1);