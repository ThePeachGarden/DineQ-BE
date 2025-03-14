package com.dineq.dineqbe.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;
    private String categoryDesc;
    private Integer categoryPriority;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<MenuEntity> menus;

    public CategoryEntity(String categoryName, String categoryDesc, Integer categoryPriority) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryPriority = categoryPriority;
        this.createdAt = LocalDate.now();
    }
}
