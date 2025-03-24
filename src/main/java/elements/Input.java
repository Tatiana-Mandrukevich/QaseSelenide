package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class Input {
    String label;
    public static final String INPUT_LOGIN_LOCATOR = "//*[@name='%s']";
    public static final String INPUT_LOCATOR = "//*[@id='%s']";
    public static final String TEXTAREA_TEST_CASE_LOCATOR = "//*[contains(text(), '%s')]/parent::div//*[contains(@class, 'ProseMirror toastui-editor-contents')]";
    public static final String INPUT_STEP_TEST_CASE_LOCATOR = "//*[contains(text(), '%s')]/parent::p/parent::div";

    public Input(String label) {
        this.label = label;
    }

    public Input writeForLoginPage(String text) {
        $x(String.format(INPUT_LOGIN_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input write(String text) {
        $x(String.format(INPUT_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeForTextareaForTestCase(String text) {
        $x(String.format(TEXTAREA_TEST_CASE_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeForStepTestCase(String text) {
        $x(String.format(INPUT_STEP_TEST_CASE_LOCATOR, label)).shouldBe(Condition.visible, Duration.ofSeconds(30)).setValue(text);
        return this;
    }

    public Input clear() {
        SelenideElement element = $x(String.format(INPUT_LOCATOR, label));
        element.click();
        element.clear();
        return this;
    }

    public void hoverOnElementAndRightSpace() {
        SelenideElement element = $x(String.format(INPUT_STEP_TEST_CASE_LOCATOR, label));
        element.scrollIntoView(true);
        element.hover();

        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        int offsetX = elementWidth + 50; // Смещение на 50 пикселей вправо от элемента
        int offsetY = elementHeight / 2; // Смещение на середину высоты элемента

        actions().moveByOffset(offsetX, offsetY).perform();
    }
}