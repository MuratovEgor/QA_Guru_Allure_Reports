import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestBase {
    private static final String BASE_URL = "/",
            REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    void LambdaTestIssueSearch() {
        step("Open the home page", (s) -> {
            open(BASE_URL);
        });

        step("Find the " + REPOSITORY + " repository ", (s) -> {
            $(byName("q")).setValue(REPOSITORY).submit();
            $(byLinkText("eroshenkoam/allure-example")).click();
        });

        step("Open the Issues tab", (s) -> {
            $("[data-content=\"Issues\"]").click();
        });

        step("Check the issue number" + ISSUE_NUMBER, (s) -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });

    }
}
