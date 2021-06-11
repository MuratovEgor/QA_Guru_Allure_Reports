import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open the home page")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Find the {repositoryName} repository")
    public void findRepository(String repositoryName) {
        $(byName("q")).setValue(repositoryName).submit();
        $(byLinkText(repositoryName)).click();
    }

    @Step("Open the Issues tab")
    public void openIssuesTab() {
        $("[data-content=\"Issues\"]").click();
    }

    @Step("Check the issue number: {number}")
    public void checkIssueNumber(Integer number) {
        $(withText("#" + number)).should(Condition.visible);
    }

}
