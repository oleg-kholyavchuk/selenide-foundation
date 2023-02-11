import objectpage.BasePage;
import objectpage.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleTest extends BasePage {
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH = "Чем iPhone 13 отличается от от iPhone 12";
    private final static String EXPECTED_WORD = "iphone-13";

    @Test
    public void checkHref(){
        Assertions.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH)
                .getHrefFromFirstArticle()
                .contains(EXPECTED_WORD));
    }
}
