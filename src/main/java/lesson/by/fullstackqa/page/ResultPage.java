package lesson.by.fullstackqa.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    private ElementsCollection getResultCollection(){
        return $$(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
    }

    public ResultPage checkResultSize(int count){
        getResultCollection().shouldHave(CollectionCondition.size(count));
        return this;
    }

    public ResultPage checkResultTitle(int index, String text){
        getResultCollection().get(index).shouldHave(Condition.text(text));
        return this;
    }

}
