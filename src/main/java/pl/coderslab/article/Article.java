package pl.coderslab.article;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;
    @OneToMany
    private List<Category> categories;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void setCreated() {
        this.created = LocalDateTime.now();
    }

    @PostPersist
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
}
