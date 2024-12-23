SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [co203478].[BOOK_AUTHOR](
	[Book_ID] [int] NOT NULL,
	[Author_ID] [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [co203478].[BOOK_AUTHOR] ADD PRIMARY KEY CLUSTERED 
(
	[Book_ID] ASC,
	[Author_ID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [co203478].[BOOK_AUTHOR]  WITH CHECK ADD  CONSTRAINT [FK_BookAuthor_Author] FOREIGN KEY([Author_ID])
REFERENCES [co203478].[AUTHOR] ([Author_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[BOOK_AUTHOR] CHECK CONSTRAINT [FK_BookAuthor_Author]
GO
ALTER TABLE [co203478].[BOOK_AUTHOR]  WITH CHECK ADD  CONSTRAINT [FK_BookAuthor_Book] FOREIGN KEY([Book_ID])
REFERENCES [co203478].[BOOK] ([Book_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[BOOK_AUTHOR] CHECK CONSTRAINT [FK_BookAuthor_Book]
GO
