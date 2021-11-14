package com.example.app.api;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.domain.repository.BooksRepository;
import com.example.app.api.books.domain.entity.Categories;
import com.example.app.api.books.domain.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/setting")
@RequiredArgsConstructor
public class CategorySettingApi {

    private final CategoriesRepository categoriesRepository;

    private final BooksRepository booksRepository;

    @PostMapping(value = "/categories")
    public void defaultCategoriesSetting() throws Exception {

        List<String> categories = Arrays.asList(new String[]{"문학", "경제경영", "인문학", "IT", "과학"});

        List<Categories> entitys = categories.stream()
                .map(e -> Categories.builder().name(e).build())
                .collect(Collectors.toList());

        categoriesRepository.saveAll(entitys);
    }

    @PostMapping(value = "/books")
    public void defaultBooksSetting() throws Exception {

        String[][] registBookInfo = {
                {"문학", "너에게 해주지 못한 말들", "권태영"},
                {"문학", "단순하게 배부르게", "허영서"},
                {"문학", "게으른 사랑", "권태영"},
                {"경제경영", "트랜드 코리아 2322", "권태영"},
                {"경제경영", "초격자 투자", "장동혁"},
                {"경제경영", "파이어족 강환국의 하면 되지 않는다! 퀸트 투자", "이예슬"},
                {"인문학", "진심보다 밥", "이서연"},
                {"인문학", "실패에 대하여 생각하지 마라", "위성원"},
                {"IT", "실리콘뺄리 리더십 쉽다", "지승열"},
                {"IT", "인공지등1-12", "장동혁"},
                {"IT", "-1년차 게임 개발", "위성원"},
                {"IT", "Skye가 알려주는 피부 채색의 비결", "권태영"},
                {"과학", "자연의 발전", "장지명"},
                {"과학", "코스모스 필 무렵", "이승열"}
        };

        for (String[] info : registBookInfo) {

            Categories category = categoriesRepository.findByName(info[0]);

            Books book = Books.builder()
                    .name(info[1])
                    .author(info[2])
                    .category(category)
                    .build();

            booksRepository.save(book);
        }

    }

}
