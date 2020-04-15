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

Date: 2020-04-15 22:10:05
*/


-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE [dbo].[product]
GO
CREATE TABLE [dbo].[product] (
[id] int NOT NULL IDENTITY(1,1) ,
[product_type] int NULL ,
[product_name] varchar(255) NULL ,
[product_title] varchar(255) NULL ,
[product_pic] varchar(255) NULL ,
[product_pic1] varchar(255) NULL ,
[product_pic2] varchar(255) NULL ,
[product_pic3] varchar(255) NULL ,
[product_pic4] varchar(255) NULL ,
[product_detail] nvarchar(MAX) NULL ,
[is_deleted] int NULL ,
[gmt_create] datetime NULL ,
[gmt_modified] datetime NULL ,
[product_pic_name] varchar(255) NULL ,
[product_pic_name1] varchar(255) NULL ,
[product_pic_name2] varchar(255) NULL ,
[product_pic_name3] varchar(255) NULL ,
[product_pic_name4] varchar(255) NULL ,
[is_home_page] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[product]', RESEED, 7)
GO

-- ----------------------------
-- Indexes structure for table product
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE [dbo].[product] ADD PRIMARY KEY ([id])
GO
