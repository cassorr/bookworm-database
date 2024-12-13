SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [co203478].[ACHIEVEMENTS](
	[Achievement_ID] [int] IDENTITY(1,1) NOT NULL,
	[User_ID] [int] NOT NULL,
	[Achievement_Description] [nvarchar](255) NOT NULL,
	[Date_Achieved] [date] NOT NULL,
	[Goals_Completed] [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [co203478].[ACHIEVEMENTS] ADD PRIMARY KEY CLUSTERED 
(
	[Achievement_ID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [co203478].[ACHIEVEMENTS] ADD  DEFAULT (getdate()) FOR [Date_Achieved]
GO
ALTER TABLE [co203478].[ACHIEVEMENTS]  WITH CHECK ADD  CONSTRAINT [FK_Achievements_User] FOREIGN KEY([User_ID])
REFERENCES [co203478].[USER] ([User_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[ACHIEVEMENTS] CHECK CONSTRAINT [FK_Achievements_User]
GO
