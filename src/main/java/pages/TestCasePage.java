package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class TestCasePage extends ProjectRepositoryPage {
    private static final SelenideElement EDIT_BUTTON = $x("//*[@aria-label='Edit']");
    private static final SelenideElement STEP_OPEN_BUTTON = $x("//*[@data-icon='angle-down']");
    private static final SelenideElement OPEN_PROPERTIES_BUTTON = $x("//button[text()='Properties']");
    private static final SelenideElement TEST_CASE_TITLE = $x("//*[@class='OZXFF4']");
    private static final String  TEST_CASE_GENERAL_VALUE = "//*[@for='%s']/parent::*//p";
    private static final String  TEST_CASE_STEP_ACTION_VALUE = "//*[@title='%s']//p";
    private static final String  TEST_CASE_STEP_VALUE = "//*[text()='%s']/parent::*//p";
    private static final String  TEST_CASE_PROPERTIES_VALUE = "//*[@id='%s']";

    public TestCasePage isOpened() {
        EDIT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public void openStep() {
        new Button().click(STEP_OPEN_BUTTON);
    }

    public void openProperties() {
        new Button().click(OPEN_PROPERTIES_BUTTON);
    }

    public String getExistTestCaseTitleValue() {
        return TEST_CASE_TITLE.getText();
    }

    public String getExistTestCaseGeneralValue(String label) {
        return $x(String.format(TEST_CASE_GENERAL_VALUE, label)).getText();
    }

    public String getExistTestCaseStepActionValue(String label) {
        return $x(String.format(TEST_CASE_STEP_ACTION_VALUE, label)).getText();
    }

    public String getExistTestCaseStepValue(String label) {
        return $x(String.format(TEST_CASE_STEP_VALUE, label)).shouldBe(Condition.visible).getText();
    }

    public String getExistTestCasePropertiesValue(String label) {
        return $x(String.format(TEST_CASE_PROPERTIES_VALUE, label)).getText();
    }
}