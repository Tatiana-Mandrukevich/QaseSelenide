package steps;

import io.qameta.allure.Step;
import objects.TestCase;
import pages.ProjectRepositoryPage;

public class CreateTestCaseSteps extends BaseSteps {
    ProjectRepositoryPage projectRepositoryPage;

    public CreateTestCaseSteps() {
        this.projectRepositoryPage = new ProjectRepositoryPage();
    }

    @Step("Create new test case")
    public void createNewTestCase(TestCase testCase) {
        projectRepositoryPage.openCreateTestCasePage()
                .isOpened()
                .createTestCase(testCase)
                .isOpened();
    }
}