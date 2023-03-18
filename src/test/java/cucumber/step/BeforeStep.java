package cucumber.step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Open website {string}")
    public void openWebsite(String url){
        Configuration.timeout = 60000;
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/test-result/reports";
        Selenide.open(url);
    }
}
