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

Date: 2020-04-15 22:09:52
*/


-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE [dbo].[dictionary]
GO
CREATE TABLE [dbo].[dictionary] (
[id] int NOT NULL IDENTITY(1,1) ,
[item_key] varchar(255) NULL ,
[item_value] varchar(255) NULL ,
[item_type] varchar(255) NULL ,
[sort_num] int NULL ,
[gmt_create] datetime NULL ,
[gmt_modified] datetime NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[dictionary]', RESEED, 7)
GO

-- ----------------------------
-- Indexes structure for table dictionary
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table dictionary
-- ----------------------------
ALTER TABLE [dbo].[dictionary] ADD PRIMARY KEY ([id])
GO
