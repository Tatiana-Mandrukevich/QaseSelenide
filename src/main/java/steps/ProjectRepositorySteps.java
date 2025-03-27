package steps;

import io.qameta.allure.Step;
import pages.ProjectRepositoryPage;

public class ProjectRepositorySteps extends BaseSteps {
    ProjectRepositoryPage projectRepositoryPage;

    public ProjectRepositorySteps() {
        this.projectRepositoryPage = new ProjectRepositoryPage();
    }

    @Step("Open settings for project")
    public void openSettingsForProject() {
        projectRepositoryPage.openProjectSettingsPage()
                .isOpened();
    }
}