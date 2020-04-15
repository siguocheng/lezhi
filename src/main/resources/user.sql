/*
Navicat SQL Server Data Transfer

Source Server         : 11
Source Server Version : 130000
Source Host           : localhost:1433
Source Database       : devData
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 130000
File Encoding         : 65001

Date: 2020-04-15 22:10:09
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE [dbo].[user]
GO
CREATE TABLE [dbo].[user] (
[id] int NOT NULL IDENTITY(1,1) ,
[user_name] varchar(255) NULL ,
[user_password] varchar(255) NULL ,
[user_type] varchar(255) NULL ,
[gmt_create] datetime NULL ,
[gmt_modified] datetime NULL 
)


GO

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE [dbo].[user] ADD PRIMARY KEY ([id])
GO
