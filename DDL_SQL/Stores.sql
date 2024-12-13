SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [co203478].[STORES](
	[Bookshelf_ID] [int] NOT NULL,
	[Book_ID] [int] NOT NULL,
	[Book_Status] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [co203478].[STORES] ADD PRIMARY KEY CLUSTERED 
(
	[Bookshelf_ID] ASC,
	[Book_ID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [co203478].[STORES]  WITH CHECK ADD  CONSTRAINT [FK_Stores_Book] FOREIGN KEY([Book_ID])
REFERENCES [co203478].[BOOK] ([Book_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[STORES] CHECK CONSTRAINT [FK_Stores_Book]
GO
ALTER TABLE [co203478].[STORES]  WITH CHECK ADD  CONSTRAINT [FK_Stores_Bookshelf] FOREIGN KEY([Bookshelf_ID])
REFERENCES [co203478].[BOOKSHELF] ([Bookshelf_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[STORES] CHECK CONSTRAINT [FK_Stores_Bookshelf]
GO