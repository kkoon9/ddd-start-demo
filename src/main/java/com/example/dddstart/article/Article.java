package com.example.dddstart.article;

import javax.persistence.*;

@Entity
@Table(name = "article")
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @AttributeOverrides({
            @AttributeOverride(
                    name = "content",
                    column = @Column(table = "article_content", name = "content")
            ),
            @AttributeOverride(
                    name = "contentType",
                    column = @Column(table = "article_content", name = "content_type")
            )
    })
    @Embedded
    private ArticleContent content;
}
