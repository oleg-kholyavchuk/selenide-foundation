package lesson.by.fullstackqa.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class IndexPage {

    public ResultPage search(String stringSearch){
        $(By.xpath("//input[@class='gLFyf']")).val(stringSearch).pressEnter();
        return page(ResultPage.class);
    }
}
