package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.TestCase;

import static com.codeborne.selenide.Selenide.*;

public class CreateTestCasePage extends ProjectRepositoryPage {
    private static final SelenideElement SAVE_BUTTON = $x("//*[@type='submit']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[contains(text(), 'Add step')]");


    public CreateTestCasePage isOpened() {
        SAVE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public TestCasePage createTestCase(TestCase testCase) {
        new Input("title").write(testCase.getTitle());
        new Dropdown("Status").selectOptionFromDropdown(testCase.getStatus());
        new Input("Description").writeForTextareaForTestCase(testCase.getDescription());
        new Dropdown("Severity").selectOptionFromDropdown(testCase.getSeverity());
        new Dropdown("Priority").selectOptionFromDropdown(testCase.getPriority());
        new Dropdown("Type").selectOptionFromDropdown(testCase.getType());
        new Dropdown("Layer").selectOptionFromDropdown(testCase.getLayer());
        new Dropdown("Is flaky").selectOptionFromDropdown(testCase.getIsFlaky());
        new Dropdown("Behavior").selectOptionFromDropdown(testCase.getBehavior());
        new Dropdown("Automation status").selectOptionFromDropdown(testCase.getAutomationStatus());
        new Input("Pre-conditions").writeForTextareaForTestCase(testCase.getPreConditions());
        new Input("Post-conditions").writeForTextareaForTestCase(testCase.getPostConditions());
        new Button().click(ADD_STEP_BUTTON);
        new Input("Step Action").hoverOnElementAndRightSpace();
        new Input("Step Action").writeForStepTestCase(testCase.getStepsStepAction());
        new Input("Data").hoverOnElementAndRightSpace();
        new Input("Data").writeForStepTestCase(testCase.getStepsData());
        new Input("Expected result").writeForStepTestCase(testCase.getStepsExpectedResult());
        new Button().click(SAVE_BUTTON);
        return new TestCasePage();
    }
}