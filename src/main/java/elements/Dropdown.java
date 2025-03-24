package elements;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String label;
    private static final String DROPDOWN_XPATH = "//*[@id='%s']";
    private static final String DROPDOWN_OPTION_XPATH = "//*[text()='%s']";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOptionFromDropdown(String option) {
        $x(String.format(DROPDOWN_XPATH, label)).click();
        $x(String.format(DROPDOWN_OPTION_XPATH, option)).click();
    }
}