/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/5/27 15:38:15                           */
/*==============================================================*/


drop table if exists Admin;

drop table if exists Forum;

drop table if exists Reply;

drop table if exists SubForum;

drop table if exists Topic;

drop table if exists User;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   id                   int not null auto_increment,
   adminName            varchar(32),
   password             varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: Forum                                                 */
/*==============================================================*/
create table Forum
(
   id                   int not null auto_increment,
   name                 varchar(20),
   description          varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: Reply                                                 */
/*==============================================================*/
create table Reply
(
   id                   int not null auto_increment,
   replyPoster          int,
   topic_id             int,
   replyTime            datetime,
   replyContent         varchar(2028),
   reply_id             int,
   primary key (id)
);

/*==============================================================*/
/* Table: SubForum                                              */
/*==============================================================*/
create table SubForum
(
   id                   int not null auto_increment,
   name                 varchar(32),
   description          varchar(64),
   forumId              int,
   moderato             int,
   replyLevel           int,
   postLevel            int,
   scanLevel            int,
   primary key (id)
);

/*==============================================================*/
/* Table: Topic                                                 */
/*==============================================================*/
create table Topic
(
   id                   int not null auto_increment,
   originalPoster       int,
   subforum_id          int,
   postTime             datetime,
   lastreplyTime        datetime,
   topicContent         varchar(4048),
   primary key (id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   int not null auto_increment,
   userName             varchar(32),
   password             varchar(32),
   email                varchar(64),
   score                int,
   currentLevel         int,
   registerTime         datetime,
   primary key (id)
);

alter table Reply add constraint FK_Reference_2 foreign key (topic_id)
      references Topic (id);

alter table Reply add constraint FK_Reference_3 foreign key (reply_id)
      references Reply (id);

alter table Reply add constraint FK_Reference_6 foreign key (replyPoster)
      references User (id);

alter table SubForum add constraint FK_Reference_4 foreign key (forumId)
      references Forum (id);

alter table SubForum add constraint FK_Reference_7 foreign key (moderato)
      references User (id);

alter table Topic add constraint FK_Reference_1 foreign key (originalPoster)
      references User (id);

alter table Topic add constraint FK_Reference_5 foreign key (subforum_id)
      references SubForum (id);

