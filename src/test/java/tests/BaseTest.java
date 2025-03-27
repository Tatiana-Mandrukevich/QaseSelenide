package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.ProjectSettingsPage;
import pages.ProjectsListPage;
import pages.TestCasePage;
import steps.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected LoginSteps loginSteps;
    protected NewProjectModalSteps newProjectModalSteps;
    protected ProjectRepositorySteps projectRepositorySteps;
    protected ProjectSettingsPage projectSettingsPage;
    protected DeleteProjectModalSteps deleteProjectModalSteps;
    protected ProjectsListPage projectsListPage;
    protected CreateTestCaseSteps createTestCaseSteps;
    protected TestCasePage testCasePage;
    protected ProjectsListSteps projectsListSteps;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    SoftAssert softAssert = new SoftAssert();

    public void initPages() {
        loginSteps = new LoginSteps();
        newProjectModalSteps = new NewProjectModalSteps();
        projectRepositorySteps = new ProjectRepositorySteps();
        projectSettingsPage = new ProjectSettingsPage();
        deleteProjectModalSteps = new DeleteProjectModalSteps();
        projectsListPage = new ProjectsListPage();
        createTestCaseSteps = new CreateTestCaseSteps();
        testCasePage = new TestCasePage();
        projectsListSteps = new ProjectsListSteps();
    }

    @BeforeMethod
    public void initTest() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1024x768";

        initPages();
    }

    @BeforeMethod(dependsOnMethods = "initTest")
    public void deleteExistingTestProject() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        if (projectsListPage.isProjectPresent("Project name value")) {
            projectsListSteps.openProject("Project name value");
            projectRepositorySteps.openSettingsForProject();
            deleteProjectModalSteps.deleteNewProject();
        }
    }

    /**
     * It is quitting the WebDriver.
     */
    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}