import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {
    private static final String BASE_URL = "/",
            REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;


    @Test
    void testIssueSearch() {
        open(BASE_URL);
        $(byName("q")).setValue(REPOSITORY).submit();
        $(byLinkText("eroshenkoam/allure-example")).click();
        $("[data-content=\"Issues\"]").click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);

    }
}
