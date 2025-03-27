package steps;

import io.qameta.allure.Step;
import pages.ProjectsListPage;

public class ProjectsListSteps {

    ProjectsListPage projectsListPage;

    public ProjectsListSteps() {
        this.projectsListPage = new ProjectsListPage();
    }

    @Step("Open the project")
    public void openProject(String project) {
        projectsListPage.openProject(project)
                .isOpened();
    }
}
