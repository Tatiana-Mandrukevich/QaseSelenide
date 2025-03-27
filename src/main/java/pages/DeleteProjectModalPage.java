package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteProjectModalPage extends ProjectSettingsPage {

    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[@type='button']//*[contains(text(), 'Delete project')]");

    public DeleteProjectModalPage isOpened() {
        DELETE_PROJECT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage clickDeleteProjectButtonOnModalPage() {
        new Button().click(DELETE_PROJECT_BUTTON);
        return new ProjectsListPage();
    }
}