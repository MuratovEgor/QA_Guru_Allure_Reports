import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends TestBase {
    private static final String BASE_URL = "/",
            REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private WebSteps steps = new WebSteps();

    @Test
    public void annotatedStepsTestIssueSearch() {
        steps.openMainPage(BASE_URL);
        steps.findRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueNumber(ISSUE_NUMBER);
    }
}
