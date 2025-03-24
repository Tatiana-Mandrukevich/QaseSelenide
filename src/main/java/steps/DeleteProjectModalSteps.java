package steps;

import io.qameta.allure.Step;
import pages.DeleteProjectModalPage;
import pages.ProjectSettingsPage;

public class DeleteProjectModalSteps extends BaseSteps {
    DeleteProjectModalPage deleteProjectModalPage;
    ProjectSettingsPage projectSettingsPage;

    public DeleteProjectModalSteps() {
        this.deleteProjectModalPage = new DeleteProjectModalPage();
        this.projectSettingsPage = new ProjectSettingsPage();
    }

    @Step("Delete new project")
    public void deleteNewProject() {
        projectSettingsPage.clickDeleteProjectButton()
                .isOpened()
                .clickDeleteProjectButtonOnModalPage()
                .isOpened();
    }
}