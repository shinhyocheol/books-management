package com.example.app.api.books.domain.entity;

import com.example.app.api.categories.domain.entity.Categories;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String author;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(length = 1)
    @ColumnDefault("'N'")
    private String disabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_CATEGORY_BOOK"))
    private Categories category;

    @Builder
    public Books(Long id, String name, String author, Categories category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
    }

    public void modifyCategoryOfBook(Categories category) {
        this.category = category;
    }

    public void modifyDisabledOfBook(String disabled) {
        this.disabled = disabled;
    }

}
