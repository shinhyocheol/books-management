package com.example.app.api.categories.domain.repository;

import com.example.app.api.categories.domain.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Categories findByName(String name);
}
