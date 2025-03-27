package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final String PROJECT_NAME = "//*[text()='%s']";

    public ProjectsListPage isOpened(String projectName) {
        $x(String.format(PROJECT_NAME, projectName)).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage open(String url) {
        open(url);
        return this;
    }

    public NewProjectModalPage openNewProjectModalPage() {
        new Button().click(CREATE_NEW_PROJECT);
        return new NewProjectModalPage();
    }

    public boolean isProjectPresent(String projectName) {
        return $x(String.format(PROJECT_NAME, projectName)).exists();
    }

    public ProjectRepositoryPage openProject(String projectName) {
        $x(String.format(PROJECT_NAME, projectName)).click();
        return new ProjectRepositoryPage();
    }
}