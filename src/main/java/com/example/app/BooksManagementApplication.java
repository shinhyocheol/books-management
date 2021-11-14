package com.example.app;

import com.example.app.api.books.domain.entity.Books;
import com.example.app.api.books.domain.entity.Categories;
import com.example.app.api.books.domain.repository.BooksRepository;
import com.example.app.api.books.domain.repository.CategoriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로젝트 실행 전에 DB 생성 및 기본 데이터 세팅 실행
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BooksManagementApplication {

    public static void main(String[] args) {

        /** runtime 전에 데이터베이스 생성 */
        CreateDatabase.main(args);

        /** runtime */
        SpringApplication.run(BooksManagementApplication.class, args);

    }

    /** 프로젝트 runtime 시 카테고리와 도서목록을 등록한다.(기본 값 세팅)*/
    @Bean
    public CommandLineRunner run(CategoriesRepository categoriesRepository, BooksRepository booksRepository) throws Exception {

        return (String[] args) -> {

            /** 카테고리 데이터 등록 */
            List<String> categoryList = Arrays.asList(new String[]{"문학", "경제경영", "인문학", "IT", "과학"});

            List<Categories> categoriesEntity = categoryList.stream()
                    .map(e -> Categories.builder().name(e).build())
                    .collect(Collectors.toList());

            categoriesRepository.saveAll(categoriesEntity);

            /** 도서 데이터 등록 */
            String[][] bookInfoArr = {
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
            List<String[]> bookInfoList = Arrays.asList(bookInfoArr);

            List<Books> booksEntity = bookInfoList
                    .stream()
                    .map(e -> Books.builder()
                            .name(e[1])
                            .author(e[2])
                            .category(categoriesRepository.findByName(e[0]))
                            .build())
                    .collect(Collectors.toList());

            booksRepository.saveAll(booksEntity);

        };
    }

}
