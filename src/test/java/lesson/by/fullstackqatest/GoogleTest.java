package lesson.by.fullstackqatest;

import com.codeborne.selenide.*;
import lesson.by.fullstackqa.page.IndexPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    public static final String WORD = "selenide";
    public static final String TITLE = "Selenide: лаконичные и стабильные UI тесты на Java";
    public static final int COUNT = 10;
    public static final int INDEX = 0;

    @BeforeEach
    public void beforeSuite() {
        Configuration.baseUrl = "https://www.google.com";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void googleTest(){

        open("/", IndexPage.class)
                 .search(WORD)
                 .checkResultSize(COUNT)
                 .checkResultTitle(INDEX, TITLE);
    }
}
