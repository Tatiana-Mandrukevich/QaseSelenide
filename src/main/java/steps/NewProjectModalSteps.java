package steps;

import io.qameta.allure.Step;
import objects.Project;
import pages.NewProjectModalPage;
import pages.ProjectsListPage;

public class NewProjectModalSteps extends BaseSteps {

    NewProjectModalPage newProjectModalPage;
    ProjectsListPage projectsListPage;

    public NewProjectModalSteps() {
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectsListPage = new ProjectsListPage();
    }

    @Step("Create new project")
    public void createNewProject(Project project) {
        projectsListPage.openNewProjectModalPage()
                .createNewProject(project)
                .isOpened();
    }
}