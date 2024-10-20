DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
                         `id` BIGINT NOT NULL,
                         `username` VARCHAR(255) NULL,
                         `password` VARCHAR(255) NULL,
                         `email` VARCHAR(255) NULL,
                         `name` VARCHAR(255) NULL,
                         `nickname` VARCHAR(255) NULL,
                         `age` INTEGER NULL,
                         `social_type` VARCHAR(255) NULL,
                         `social_id` VARCHAR(255) NULL,
                         `role` VARCHAR(255) NULL COMMENT '{ADMIN,USER,GUEST}',
                         `created_at` TIMESTAMP NULL,
                         `updated_at` TIMESTAMP NULL
);

DROP TABLE IF EXISTS `tech`;

CREATE TABLE `tech` (
                        `id` BIGINT NOT NULL,
                        `category_id` BIGINT NOT NULL,
                        `name` VARCHAR(255) NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
                          `id` BIGINT NOT NULL,
                          `user_id` BIGINT NOT NULL,
                          `lecture_id` BIGINT NOT NULL,
                          `score` DOUBLE NULL,
                          `content` TEXT NULL,
                          `created_at` TIMESTAMP NULL,
                          `updated_at` TIMESTAMP NULL
);

DROP TABLE IF EXISTS `bookmark`;

CREATE TABLE `bookmark` (
                            `id` BIGINT NOT NULL,
                            `user_id` BIGINT NOT NULL,
                            `lecture_id` BIGINT NOT NULL
);

DROP TABLE IF EXISTS `lecture`;

CREATE TABLE `lecture` (
                           `id` VARCHAR(255) NOT NULL,
                           `category_id` BIGINT NOT NULL,
                           `Field` VARCHAR(255) NULL,
                           `channel_title` VARCHAR(255) NULL,
                           `url` VARCHAR(255) NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
                            `id` BIGINT NOT NULL,
                            `name` VARCHAR(255) NULL
);

ALTER TABLE `users` ADD CONSTRAINT `PK_USERS` PRIMARY KEY (`id`);

ALTER TABLE `tech` ADD CONSTRAINT `PK_TECH` PRIMARY KEY (`id`);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (`id`);

ALTER TABLE `bookmark` ADD CONSTRAINT `PK_BOOKMARK` PRIMARY KEY (`id`);

ALTER TABLE `lecture` ADD CONSTRAINT `PK_LECTURE` PRIMARY KEY (`id`);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (`id`);