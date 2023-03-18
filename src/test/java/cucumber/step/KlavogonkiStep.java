package cucumber.step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

@Owner("Oleg QA Automation")
@DisplayName("Test End2End")
@Severity(value = SeverityLevel.BLOCKER)
public class KlavogonkiStep {
    private final SelenideElement closeWindowButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startGameButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocus = $x("//span[@id='afterfocus']");
    private final SelenideElement resultText = $x("//td[text()='Это вы']//ancestor-or-self::div//div[@class='stats']//div[2]/span/span");

    @SneakyThrows
    private String getCurrentWord(){
        Thread.sleep(600);
       return highlightWord.getText().replaceAll("c", "с").replaceAll("o", "о");
    }

    @When("Starting the game")
    public void StartingGame(){
        closeWindowButton.click();
        if (startGameButton.isDisplayed()){
            startGameButton.click();
        }
    }

    @And("Waiting for the game to start")
    public void waitGameStart(){
        highlightWord.click();
    }

    @And("Enter the highlighted word")
    public void playGame(){
        while (true){
            String currentWord = getCurrentWord();
            String afterFocusSymbol = afterFocus.getText();
            inputField.sendKeys(currentWord);
            if(afterFocusSymbol.equals(".")){
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Then("We fix that the game is completed and there are more than {int} characters per minute")
    public void andGame(int minValue){
       String result = resultText.getText();
       int resultNumber = Integer.parseInt(result);
        System.out.println("Number of characters per minute " + resultNumber);
        Assertions.assertTrue(resultNumber > minValue, "Actual result " + resultNumber);
    }
}
