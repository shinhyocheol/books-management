package com.example.app.api.books.domain.repository.specification;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.domain.entity.Categories;
import com.example.app.api.books.domain.repository.CategoriesRepository;
import com.example.app.api.books.dto.BookSearchKeyword;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BooksSpec {
    /**
     * @설명 : Specification 인터페이스를 통해 검색 조회 시 필요한 검색조건을 빌드함.
     *      검색조건은 필수가 아닌 선택이므로 null인 경우는 조건에 포함되지 않는다.
     */
    public static Specification<Books> getPredicateWithKeyword(BookSearchKeyword searchKeyword) {

        return new Specification<Books>() {
            @Override
            public Predicate toPredicate(Root<Books> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                // 카테시안 곱 현상 방지
                query.distinct(true);

                // 조인 패치타입 설정
                root.fetch("category", JoinType.INNER);

                // 조건 체크 및 빌드
                List<Predicate> predicate = new ArrayList<>();
                if (searchKeyword.getBookName() != null)
                    predicate.add(builder.like(root.get("name"), "%" + searchKeyword.getBookName() + "%"));
                if (searchKeyword.getBookAuthor() != null)
                    predicate.add(builder.like(root.get("author"), "%" + searchKeyword.getBookAuthor() + "%"));
                if (searchKeyword.getCategoryId() != null)
                    predicate.add(builder.equal(root.get("category").get("id"), searchKeyword.getCategoryId()));


                return builder.and(predicate.toArray(new Predicate[0]));
            }
        };
    }

}
