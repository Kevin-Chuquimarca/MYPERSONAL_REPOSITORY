USE [master]
GO
/****** Object:  Database [crud_login_monster]    Script Date: 3/5/2023 10:36:36 PM ******/
CREATE DATABASE [crud_login_monster]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'crud_login_monster', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\crud_login_monster.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'crud_login_monster_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\crud_login_monster_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [crud_login_monster] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [crud_login_monster].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [crud_login_monster] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [crud_login_monster] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [crud_login_monster] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [crud_login_monster] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [crud_login_monster] SET ARITHABORT OFF 
GO
ALTER DATABASE [crud_login_monster] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [crud_login_monster] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [crud_login_monster] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [crud_login_monster] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [crud_login_monster] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [crud_login_monster] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [crud_login_monster] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [crud_login_monster] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [crud_login_monster] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [crud_login_monster] SET  DISABLE_BROKER 
GO
ALTER DATABASE [crud_login_monster] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [crud_login_monster] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [crud_login_monster] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [crud_login_monster] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [crud_login_monster] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [crud_login_monster] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [crud_login_monster] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [crud_login_monster] SET RECOVERY FULL 
GO
ALTER DATABASE [crud_login_monster] SET  MULTI_USER 
GO
ALTER DATABASE [crud_login_monster] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [crud_login_monster] SET DB_CHAINING OFF 
GO
ALTER DATABASE [crud_login_monster] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [crud_login_monster] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [crud_login_monster] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [crud_login_monster] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'crud_login_monster', N'ON'
GO
ALTER DATABASE [crud_login_monster] SET QUERY_STORE = ON
GO
ALTER DATABASE [crud_login_monster] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [crud_login_monster]
GO
/****** Object:  User [admin]    Script Date: 3/5/2023 10:36:36 PM ******/
CREATE USER [admin] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[PEEMP_EMPLE]    Script Date: 3/5/2023 10:36:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PEEMP_EMPLE](
	[PEEMP_CODIGO] [char](6) NOT NULL,
	[PEEMP_APELLI] [varchar](50) NOT NULL,
	[PEEMP_NOMBRE] [varchar](50) NOT NULL,
	[PEEMP_FECNAC] [datetime] NOT NULL,
	[PEEMP_FECSAL] [datetime] NOT NULL,
	[PEEMP_DIREC] [varchar](200) NOT NULL,
	[PEEMP_TELEF] [varchar](15) NOT NULL,
	[PEEMP_EMAIL] [varchar](100) NOT NULL,
	[PEEMP_CEDULA] [varchar](10) NOT NULL,
	[PEEMP_FOTO] [varchar](100) NULL,
	[PEEMP_CARFAM] [numeric](3, 0) NOT NULL,
	[PEEMP_PASAPO] [varchar](15) NOT NULL,
	[DISCAPA] [binary](1) NOT NULL,
 CONSTRAINT [PK_PEEMP_EMPLE] PRIMARY KEY CLUSTERED 
(
	[PEEMP_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEEST_ESTAD]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEEST_ESTAD](
	[XEEST_CODIGO] [char](1) NOT NULL,
	[XEEST_DESCRI] [varchar](50) NOT NULL,
 CONSTRAINT [PK_XEEST_ESTAD] PRIMARY KEY CLUSTERED 
(
	[XEEST_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEOPC_OPCIO]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEOPC_OPCIO](
	[XEOPC_CODIGO] [char](3) NOT NULL,
	[XESIS_CODIGO] [char](1) NOT NULL,
	[XEOPC_DESCRI] [varchar](100) NOT NULL,
 CONSTRAINT [PK_XEOPC_OPCIO] PRIMARY KEY CLUSTERED 
(
	[XEOPC_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEOXP_OPCPE]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEOXP_OPCPE](
	[XEOPC_CODIGO] [char](3) NOT NULL,
	[XEPER_CODIGO] [char](8) NOT NULL,
	[XEOXP_FECASI] [datetime] NOT NULL,
	[XEOXP_FECRET] [datetime] NULL,
 CONSTRAINT [PK_XEOXP_OPCPE] PRIMARY KEY CLUSTERED 
(
	[XEOPC_CODIGO] ASC,
	[XEPER_CODIGO] ASC,
	[XEOXP_FECASI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEPER_PERFI]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEPER_PERFI](
	[XEPER_CODIGO] [char](8) NOT NULL,
	[XEPER_DESCRI] [varchar](100) NOT NULL,
	[XEPER_OBSER] [text] NULL,
 CONSTRAINT [PK_XEPER_PERFI] PRIMARY KEY CLUSTERED 
(
	[XEPER_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XESIS_SISTE]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XESIS_SISTE](
	[XESIS_CODIGO] [char](1) NOT NULL,
	[XESIS_DESCRI] [varchar](50) NOT NULL,
 CONSTRAINT [PK_XESIS_SISTE] PRIMARY KEY CLUSTERED 
(
	[XESIS_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEUSU_USUAR]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEUSU_USUAR](
	[XEUSU_PASWD] [varchar](100) NOT NULL,
	[XEEST_CODIGO] [char](1) NOT NULL,
	[PEEMP_CODIGO] [char](6) NOT NULL,
	[XEUSU_FECCRE] [datetime] NOT NULL,
	[XEUSU_FECMOD] [datetime] NOT NULL,
	[XEUSU_PIEFIR] [varchar](100) NOT NULL,
 CONSTRAINT [PK_XEUSU_USUAR] PRIMARY KEY CLUSTERED 
(
	[XEUSU_PASWD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XEUXP_USUPE]    Script Date: 3/5/2023 10:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XEUXP_USUPE](
	[XEUSU_PASWD] [varchar](100) NOT NULL,
	[XEPER_CODIGO] [char](8) NOT NULL,
	[XEUXP_FECASI] [datetime] NOT NULL,
	[XEUXP_FECRET] [datetime] NULL,
 CONSTRAINT [PK_XEUXP_USUPE] PRIMARY KEY CLUSTERED 
(
	[XEUSU_PASWD] ASC,
	[XEPER_CODIGO] ASC,
	[XEUXP_FECASI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XESIS_XEOPC_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XESIS_XEOPC_FK] ON [dbo].[XEOPC_OPCIO]
(
	[XESIS_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XEOPC_XEOXP_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XEOPC_XEOXP_FK] ON [dbo].[XEOXP_OPCPE]
(
	[XEOPC_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XEPER_XEOXP_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XEPER_XEOXP_FK] ON [dbo].[XEOXP_OPCPE]
(
	[XEPER_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_PEEMP_XEUSU_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_PEEMP_XEUSU_FK] ON [dbo].[XEUSU_USUAR]
(
	[PEEMP_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XEEST_XEUSU_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XEEST_XEUSU_FK] ON [dbo].[XEUSU_USUAR]
(
	[XEEST_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XEPER_XEUXP_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XEPER_XEUXP_FK] ON [dbo].[XEUXP_USUPE]
(
	[XEPER_CODIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [XR_XEUSU_XEUXP_FK]    Script Date: 3/5/2023 10:36:37 PM ******/
CREATE NONCLUSTERED INDEX [XR_XEUSU_XEUXP_FK] ON [dbo].[XEUXP_USUPE]
(
	[XEUSU_PASWD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[XEOPC_OPCIO]  WITH CHECK ADD  CONSTRAINT [FK_XEOPC_OP_XR_XESIS__XESIS_SI] FOREIGN KEY([XESIS_CODIGO])
REFERENCES [dbo].[XESIS_SISTE] ([XESIS_CODIGO])
GO
ALTER TABLE [dbo].[XEOPC_OPCIO] CHECK CONSTRAINT [FK_XEOPC_OP_XR_XESIS__XESIS_SI]
GO
ALTER TABLE [dbo].[XEOXP_OPCPE]  WITH CHECK ADD  CONSTRAINT [FK_XEOXP_OP_XR_XEOPC__XEOPC_OP] FOREIGN KEY([XEOPC_CODIGO])
REFERENCES [dbo].[XEOPC_OPCIO] ([XEOPC_CODIGO])
GO
ALTER TABLE [dbo].[XEOXP_OPCPE] CHECK CONSTRAINT [FK_XEOXP_OP_XR_XEOPC__XEOPC_OP]
GO
ALTER TABLE [dbo].[XEOXP_OPCPE]  WITH CHECK ADD  CONSTRAINT [FK_XEOXP_OP_XR_XEPER__XEPER_PE] FOREIGN KEY([XEPER_CODIGO])
REFERENCES [dbo].[XEPER_PERFI] ([XEPER_CODIGO])
GO
ALTER TABLE [dbo].[XEOXP_OPCPE] CHECK CONSTRAINT [FK_XEOXP_OP_XR_XEPER__XEPER_PE]
GO
ALTER TABLE [dbo].[XEUSU_USUAR]  WITH CHECK ADD  CONSTRAINT [FK_XEUSU_US_XR_PEEMP__PEEMP_EM] FOREIGN KEY([PEEMP_CODIGO])
REFERENCES [dbo].[PEEMP_EMPLE] ([PEEMP_CODIGO])
GO
ALTER TABLE [dbo].[XEUSU_USUAR] CHECK CONSTRAINT [FK_XEUSU_US_XR_PEEMP__PEEMP_EM]
GO
ALTER TABLE [dbo].[XEUSU_USUAR]  WITH CHECK ADD  CONSTRAINT [FK_XEUSU_US_XR_XEEST__XEEST_ES] FOREIGN KEY([XEEST_CODIGO])
REFERENCES [dbo].[XEEST_ESTAD] ([XEEST_CODIGO])
GO
ALTER TABLE [dbo].[XEUSU_USUAR] CHECK CONSTRAINT [FK_XEUSU_US_XR_XEEST__XEEST_ES]
GO
ALTER TABLE [dbo].[XEUXP_USUPE]  WITH CHECK ADD  CONSTRAINT [FK_XEUXP_US_XR_XEPER__XEPER_PE] FOREIGN KEY([XEPER_CODIGO])
REFERENCES [dbo].[XEPER_PERFI] ([XEPER_CODIGO])
GO
ALTER TABLE [dbo].[XEUXP_USUPE] CHECK CONSTRAINT [FK_XEUXP_US_XR_XEPER__XEPER_PE]
GO
ALTER TABLE [dbo].[XEUXP_USUPE]  WITH CHECK ADD  CONSTRAINT [FK_XEUXP_US_XR_XEUSU__XEUSU_US] FOREIGN KEY([XEUSU_PASWD])
REFERENCES [dbo].[XEUSU_USUAR] ([XEUSU_PASWD])
GO
ALTER TABLE [dbo].[XEUXP_USUPE] CHECK CONSTRAINT [FK_XEUXP_US_XR_XEUSU__XEUSU_US]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad para realizar la gestion de empleados' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PEEMP_EMPLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para gestionar el estado de las difetrentes tablas' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEEST_ESTAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para realizar el registro de las diferentes opciones de un sistema' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEOPC_OPCIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para llevar el registro de las opciones que pertenecen a un perfil' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEOXP_OPCPE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para realizar la gestión de los diferentes perfiles' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEPER_PERFI'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para realziar la gestión de los diferentes subsistemas' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XESIS_SISTE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad relacionada para gentionar los usuario que ingrsan al sistema' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEUSU_USUAR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Entidad utilizada para realizar el registro de los diferentes usuarios que pertenecen a un perfil' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'XEUXP_USUPE'
GO
USE [master]
GO
ALTER DATABASE [crud_login_monster] SET  READ_WRITE 
GO
