CREATE TABLE `im_user_data`
(
    `user_Id`            varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nick_name`          varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `location`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `birth_day`          varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `password`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `photo`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `user_sex`           tinyint(1)                              DEFAULT NULL,
    `self_signature`     varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个性签名',
    `friend_allow_type`  tinyint(1)                              DEFAULT NULL COMMENT '加好友验证类型1需要验证',
    `disable_add_friend` tinyint(1)                              DEFAULT NULL COMMENT '管理员禁止用户添加加好友：0 未禁用 1 已禁用',
    `forbidden_flag`     tinyint(1)                              DEFAULT NULL COMMENT '禁用标识(0 未禁用 1 已禁用',
    `silent_flag`        tinyint(1)                              DEFAULT NULL COMMENT '禁言标识',
    `user_type`          tinyint(1)                              DEFAULT NULL COMMENT '用户类型 1普通用户 2客服 3机器人',
    `app_id`             int                                     DEFAULT NULL,
    `del_flag`           tinyint(1)                              DEFAULT NULL,
    `extra`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`user_Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户数据表';


CREATE TABLE `im_friendship`
(
    `app_Id`          int                                    NOT NULL,
    `from_id`         varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `to_id`           varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `remark`          varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
    `status`          tinyint(1)                              DEFAULT NULL COMMENT '1正常 2删除 0未添加',
    `black`           tinyint(1)                              DEFAULT NULL COMMENT '1正常 2拉黑',
    `black_sequence`  varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `create_time`     bigint                                  DEFAULT NULL,
    `friend_sequence` bigint                                  DEFAULT NULL,
    `add_source`      varchar(20) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '来源',
    `extra`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展',
    PRIMARY KEY (`app_Id`, `from_id`, `to_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='好友表';

CREATE TABLE `im_friendship_group`
(
    `group_id`    bigint NOT NULL,
    `from_id`     varchar(50) COLLATE utf8mb4_unicode_ci  DEFAULT NULL,
    `app_id`      int                                     DEFAULT NULL,
    `group_name`  varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分组名称',
    `sequence`    bigint                                  DEFAULT NULL,
    `create_time` bigint                                  DEFAULT NULL,
    `update_time` bigint                                  DEFAULT NULL,
    `del_flag`    tinyint(1)                              DEFAULT NULL,
    PRIMARY KEY (`group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='好友分组表';

CREATE TABLE `im_friendship_group_member`
(
    `group_id` bigint                                 NOT NULL,
    `to_id`    varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`group_id`, `to_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `im_friendship_request`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `app_id`         int                                                           DEFAULT NULL,
    `from_Id`        varchar(50) COLLATE utf8mb4_unicode_ci                        DEFAULT NULL,
    `to_id`          varchar(50) COLLATE utf8mb4_unicode_ci                        DEFAULT NULL,
    `remark`         varchar(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL,
    `read_status`    tinyint(1)                                                    DEFAULT '0' COMMENT '0未读1已读',
    `add_source`     varchar(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '好友来源',
    `add_wording`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请附带信息',
    `approve_status` tinyint(1)                                                    DEFAULT NULL COMMENT '审批状态 1同意 2拒绝',
    `create_time`    bigint                                                        DEFAULT NULL,
    `update_time`    bigint                                                        DEFAULT NULL,
    `sequence`       bigint                                                        DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='好友请求表';

CREATE TABLE `im_group`
(
    `group_id`         varchar(50) COLLATE utf8mb4_unicode_ci                       NOT NULL COMMENT '群ID',
    `app_id`           int                                     DEFAULT NULL,
    `owner_id`         int                                     DEFAULT NULL COMMENT '群主id',
    `group_type`       tinyint(1)                                                   NOT NULL COMMENT '群类型 1私有群（微信） 2公开群（QQ）',
    `group_name`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '群名称',
    `mute`             tinyint(1)                              DEFAULT NULL COMMENT '是否开启群禁言0否1是',
    `status`           tinyint(1)                              DEFAULT NULL COMMENT '群状态1正常2解散',
    `apply_join_type`  tinyint(1)                              DEFAULT NULL COMMENT '申请加群选项0 表示禁止任何人申请加入1表示需要群主或管理员审批2表示允许无需审批自由加入群组',
    `introduction`     varchar(50) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '群简介',
    `notification`     varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '群公告',
    `photo`            varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
    `max_member_count` int                                     DEFAULT NULL COMMENT '最大群成员数',
    `sequence`         varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `create_time`      bigint                                  DEFAULT NULL,
    `update_time`      bigint                                  DEFAULT NULL,
    `extra`            varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='群组表';

CREATE TABLE `im_group_member`
(
    `group_member_id` bigint                                 NOT NULL AUTO_INCREMENT,
    `app_id`          int                                    NOT NULL,
    `group_id`        varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `member_id`       varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `speak_date`      bigint                                  DEFAULT NULL COMMENT '禁言到期时间',
    `role`            tinyint(1)                             NOT NULL COMMENT '群成员类型，0 普通成员, 1 管理员, 2 群主， 3 禁言，4 已经移除的成员',
    `alias`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '群昵称',
    `join_time`       bigint                                  DEFAULT NULL COMMENT '加入时间',
    `leave_time`      bigint                                  DEFAULT NULL COMMENT '离开时间',
    `join_type`       varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加入方式',
    `extra`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`group_member_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='群成员表';