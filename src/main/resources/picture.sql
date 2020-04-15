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

Date: 2020-04-15 22:09:59
*/


-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE [dbo].[picture]
GO
CREATE TABLE [dbo].[picture] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(50) NULL ,
[url] varchar(100) NULL ,
[type] int NULL ,
[gmt_create] datetime NULL ,
[gmt_modified] varchar(255) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[picture]', RESEED, 34)
GO

-- ----------------------------
-- Indexes structure for table picture
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table picture
-- ----------------------------
ALTER TABLE [dbo].[picture] ADD PRIMARY KEY ([id])
GO
