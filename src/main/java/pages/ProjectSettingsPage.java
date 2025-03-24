package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectSettingsPage extends ProjectsListPage {
    private static final SelenideElement CHANGE_LOGO_BUTTON = $x("//*[contains(text(), 'Change logo')]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[contains(text(), ' Delete project')]");
    public static final String INPUT_LOCATOR = "//*[@id='%s']";

    public ProjectSettingsPage isOpened() {
        CHANGE_LOGO_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public String getExistInputValue(String label) {
        return $x(String.format(INPUT_LOCATOR, label)).shouldBe(Condition.visible).getValue();
    }

    public DeleteProjectModalPage clickDeleteProjectButton() {
        new Button().click(DELETE_PROJECT_BUTTON);
        return new DeleteProjectModalPage();
    }
}