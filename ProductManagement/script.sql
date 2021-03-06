USE [master]
GO
/****** Object:  Database [ASS_ProductManagement]    Script Date: 10/30/2021 7:04:11 PM ******/
CREATE DATABASE [ASS_ProductManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ASS_ProductManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\ASS_ProductManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ASS_ProductManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\ASS_ProductManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ASS_ProductManagement] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ASS_ProductManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ASS_ProductManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ASS_ProductManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ASS_ProductManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ASS_ProductManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ASS_ProductManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ASS_ProductManagement] SET  MULTI_USER 
GO
ALTER DATABASE [ASS_ProductManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ASS_ProductManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ASS_ProductManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ASS_ProductManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ASS_ProductManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ASS_ProductManagement] SET QUERY_STORE = OFF
GO
USE [ASS_ProductManagement]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ASS_ProductManagement]
GO
/****** Object:  Table [dbo].[Details]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Details](
	[detailID] [int] IDENTITY(1,1) NOT NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[OrderID] [int] NULL,
	[vegetableID] [nvarchar](10) NULL,
 CONSTRAINT [PK_Details] PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[DateOrder] [date] NULL,
	[total] [float] NULL,
	[userName] [nvarchar](50) NULL,
	[phone] [varchar](20) NULL,
	[address] [nvarchar](200) NULL,
	[userID] [nvarchar](50) NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [nvarchar](20) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [nvarchar](50) NOT NULL,
	[roleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRoles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblVegetable]    Script Date: 10/30/2021 7:04:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblVegetable](
	[vegetableID] [nvarchar](10) NOT NULL,
	[vegetableName] [nvarchar](20) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[Status] [nvarchar](10) NULL,
	[Image] [nvarchar](200) NULL,
	[categoryID] [nvarchar](20) NULL,
 CONSTRAINT [PK_tblVegetable] PRIMARY KEY CLUSTERED 
(
	[vegetableID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Details] ON 

INSERT [dbo].[Details] ([detailID], [price], [quantity], [OrderID], [vegetableID]) VALUES (7, 2, 2, 5, N'8989')
INSERT [dbo].[Details] ([detailID], [price], [quantity], [OrderID], [vegetableID]) VALUES (8, 2, 2, 6, N'121')
SET IDENTITY_INSERT [dbo].[Details] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (1, CAST(N'2021-10-27' AS Date), 11, N'Nguyen Tran Nam Long', N'0826325216', N'92 thanh thai', N'long')
INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (2, CAST(N'2021-10-27' AS Date), 30, N'namlong', N'0856530041', N'TP.Quy Nhơn', N'long')
INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (3, CAST(N'2021-10-27' AS Date), 24, N'namlong', N'0956530041', N'TP.Quy Nhơn', N'long')
INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (4, CAST(N'2021-10-27' AS Date), 2, N'namlong', N'0856530041', N'TP.Quy Nhơn', N'long')
INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (5, CAST(N'2021-10-27' AS Date), 4, N'namlong', N'0856530041', N'TP.Quy Nhơn', N'long')
INSERT [dbo].[Orders] ([OrderID], [DateOrder], [total], [userName], [phone], [address], [userID]) VALUES (6, CAST(N'2021-10-30' AS Date), 4, N'Nguyen Tran Nam Long', N'0356530041', N'Chung cu LandMark', N'long')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'fruit', N'Nuoc ep trai cay')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'vegetable', N'Rau sieu tuoi')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'yogurt', N'Yogurt')
GO
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'AD', N'Adminstator')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [email], [password], [roleID]) VALUES (N'admin', N'Adminstrator', N'admin@adm.com', N'1', N'AD')
INSERT [dbo].[tblUsers] ([userID], [fullName], [email], [password], [roleID]) VALUES (N'dev', N'Dev Nguyen', N'dev@yahoo.com', N'1', N'US')
INSERT [dbo].[tblUsers] ([userID], [fullName], [email], [password], [roleID]) VALUES (N'long', N'Nguyen Tran Nam Long', N'long@gmail.com', N'1', N'US')
GO
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'1', N'Rau den 2', 2, 12, N'InActive', N'RAUDEN.png', N'vegetable')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'121', N'Rau mung toi', 2, 4, N'Active', N'APPLE FRUIT.png', N'vegetable')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'2', N'Rau muong', 2, 1, N'Active', N'RAUMUONG.png', N'vegetable')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'3', N'Apple Fruit', 3, 13, N'Active', N'APPLE FRUIT.png', N'fruit')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'4', N'Dau Fruit', 3, 13, N'Active', N'DAU FRUIT.jpg', N'fruit')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'5', N'Cam Fruit', 4, 13, N'InActive', N'CAM FRUIT.jpg', N'fruit')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'6', N'Thom Fruit', 4, 22, N'InActive', N'THOM FRUIT.jpg', N'fruit')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'7', N'Yogurt', 2, 100, N'InActive', N'yogurt.jpg', N'yogurt')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'8989', N'TestX', 2, 0, N'Active', N'RAUMUONG.png', N'yogurt')
INSERT [dbo].[tblVegetable] ([vegetableID], [vegetableName], [price], [quantity], [Status], [Image], [categoryID]) VALUES (N'C22', N'rau Moi', 3, 4, N'InActive', N'THOM FRUIT.jpg', N'vegetable')
GO
ALTER TABLE [dbo].[Details]  WITH CHECK ADD  CONSTRAINT [FK_Details_Orders] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Details] CHECK CONSTRAINT [FK_Details_Orders]
GO
ALTER TABLE [dbo].[Details]  WITH CHECK ADD  CONSTRAINT [FK_Details_tblVegetable] FOREIGN KEY([vegetableID])
REFERENCES [dbo].[tblVegetable] ([vegetableID])
GO
ALTER TABLE [dbo].[Details] CHECK CONSTRAINT [FK_Details_tblVegetable]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRoles] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRoles]
GO
ALTER TABLE [dbo].[tblVegetable]  WITH CHECK ADD  CONSTRAINT [FK_tblVegetable_tblCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblVegetable] CHECK CONSTRAINT [FK_tblVegetable_tblCategory]
GO
USE [master]
GO
ALTER DATABASE [ASS_ProductManagement] SET  READ_WRITE 
GO
