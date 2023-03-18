package cucumber.step;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import lombok.SneakyThrows;

public class AfterStep {
    @After
    @SneakyThrows
    public void tearDown(){
        Thread.sleep(40000);
        WebDriverRunner.getWebDriver().quit();
    }

//    @io.cucumber.java.AfterStep
//    public void makeScreenshot(){
//        Selenide.screenshot(System.currentTimeMillis() + "step");
//    }
}
