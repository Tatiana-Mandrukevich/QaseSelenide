package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import objects.Project;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalPage extends ProjectsListPage {
    private static final SelenideElement CREATE_PROJECT_BUTTON = $x("//*[@type='submit']");

    public ProjectRepositoryPage createNewProject(Project project) {
        new Input("project-name").write(project.getProjectName());
        new Input("project-code").clear();
        new Input("project-code").write(project.getProjectCode());
        new Input("description-area").write(project.getDescription());
        new Button().click(CREATE_PROJECT_BUTTON);
        return new ProjectRepositoryPage();
    }
}