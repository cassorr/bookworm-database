SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [co203478].[GENRE](
	[Genre_ID] [int] IDENTITY(1,1) NOT NULL,
	[Genre_Name] [nvarchar](100) NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [co203478].[GENRE] ADD PRIMARY KEY CLUSTERED 
(
	[Genre_ID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
ALTER TABLE [co203478].[GENRE] ADD UNIQUE NONCLUSTERED 
(
	[Genre_Name] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
