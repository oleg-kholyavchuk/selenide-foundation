package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import objectpage.BasePage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BasePage {
    private final String URl = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs(){
        Selenide.open(URl);

        ElementsCollection href = $$x("//div[@id='toc']//a[@href]"); ////div[@id='toc']//a[@href]
        List<String> links =new ArrayList<>();
        //1
//        for (int i = 0; i < href.size(); i++) {
//            links.add(href.get(i).getAttribute("href"));
//        }

        //2
//        for (SelenideElement element: href) {
//            links.add(element.getAttribute("href"));
//        }

        //3
        href.forEach(x-> links.add(x.getAttribute("href")));

//        links.forEach(Selenide::open);

//        for (int i = 0; i < links.size(); i++) {
//            String listUrl = links.get(i);
//            Selenide.open(listUrl);
//            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//            Assertions.assertEquals(currentUrl, listUrl);
//        }
//
//        Random random = new Random();
//
//        while (links.size() > 0){
//            int randomNumber = random.nextInt(links.size());
//            Selenide.open(links.get(randomNumber));
//            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
//        }

        List<Integer> linksLength = href.stream().map(x->x.getAttribute("href").length()).collect(Collectors.toList());
    }
}
