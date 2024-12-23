SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [co203478].[BOOK_RECOMMENDATION](
	[Recommendation_ID] [int] IDENTITY(1,1) NOT NULL,
	[User_ID] [int] NOT NULL,
	[Book_ID] [int] NOT NULL,
	[Recommendation_Date] [date] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [co203478].[BOOK_RECOMMENDATION] ADD PRIMARY KEY CLUSTERED 
(
	[Recommendation_ID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [co203478].[BOOK_RECOMMENDATION]  WITH CHECK ADD  CONSTRAINT [FK_BookRecommendation_Book] FOREIGN KEY([Book_ID])
REFERENCES [co203478].[BOOK] ([Book_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[BOOK_RECOMMENDATION] CHECK CONSTRAINT [FK_BookRecommendation_Book]
GO
ALTER TABLE [co203478].[BOOK_RECOMMENDATION]  WITH CHECK ADD  CONSTRAINT [FK_BookRecommendation_User] FOREIGN KEY([User_ID])
REFERENCES [co203478].[USER] ([User_ID])
ON DELETE CASCADE
GO
ALTER TABLE [co203478].[BOOK_RECOMMENDATION] CHECK CONSTRAINT [FK_BookRecommendation_User]
GO
