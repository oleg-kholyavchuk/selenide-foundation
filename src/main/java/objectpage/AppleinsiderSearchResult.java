package objectpage;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class AppleinsiderSearchResult {
    private final ElementsCollection tagTitle = $$x("//h2//a");

    /**
     * Return href is first
     */
    public String getHrefFromFirstArticle(){
      return tagTitle.first().getAttribute("href");
    }

}
