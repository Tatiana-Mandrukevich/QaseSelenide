package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectRepositoryPage extends ProjectsListPage {
    private static final SelenideElement SETTINGS_BUTTON = $x("//*[@title='Settings']");
    private static final SelenideElement NEW_TEST_BUTTON = $(By.id("create-case-button"));

    public ProjectRepositoryPage isOpened() {
        NEW_TEST_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectSettingsPage openProjectSettingsPage() {
        new Button().click(SETTINGS_BUTTON);
        return new ProjectSettingsPage();
    }

    public CreateTestCasePage openCreateTestCasePage() {
        new Button().click(NEW_TEST_BUTTON);
        return new CreateTestCasePage();
    }
}