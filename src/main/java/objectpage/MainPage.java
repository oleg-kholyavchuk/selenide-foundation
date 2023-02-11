package objectpage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement tagBoxInput = $x("//input[@name='s']");

    public MainPage(String url){
        Selenide.open(url);
    }

    public AppleinsiderSearchResult search(String element){
        tagBoxInput.setValue(element);
        tagBoxInput.sendKeys(Keys.ENTER);

        return new AppleinsiderSearchResult();
    }

    public void openWebSite(String url){
        Selenide.open(url);
    }
}
