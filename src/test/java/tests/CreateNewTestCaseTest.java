package tests;

import objects.Project;
import objects.TestCase;
import org.testng.annotations.Test;

public class CreateNewTestCaseTest extends BaseTest {

    @Test
    public void createNewTestCase() {
        Project project = new Project();
        project.setProjectName("Project name value for test case");
        project.setProjectCode("CODEVALUE");
        project.setDescription("Description value");

        TestCase testCase = new TestCase();
        testCase.setTitle("Test case title value");
        testCase.setStatus("Actual");
        testCase.setDescription("Test case description value");
        testCase.setSeverity("Normal");
        testCase.setPriority("Medium");
        testCase.setType("Regression");
        testCase.setLayer("API");
        testCase.setIsFlaky("No");
        testCase.setBehavior("Positive");
        testCase.setAutomationStatus("Automated");
        testCase.setPreConditions("Test case preconditions value");
        testCase.setPostConditions("Test case post conditions value");
        testCase.setStepsStepAction("Test case step action value");
        testCase.setStepsData("Test case step data value");
        testCase.setStepsExpectedResult("Test case step expected result value");

        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        newProjectModalSteps.createNewProject(project);
        createTestCaseSteps.createNewTestCase(testCase);
        softAssert.assertEquals(testCasePage.getExistTestCaseTitleValue(), testCase.getTitle());
        softAssert.assertEquals(testCasePage.getExistTestCaseGeneralValue("0-description"), testCase.getDescription());
        softAssert.assertEquals(testCasePage.getExistTestCaseGeneralValue("0-preconditions"), testCase.getPreConditions());
        softAssert.assertEquals(testCasePage.getExistTestCaseGeneralValue("0-postconditions"), testCase.getPostConditions());

        testCasePage.openStep();
        softAssert.assertEquals(testCasePage.getExistTestCaseStepActionValue("1"), testCase.getStepsStepAction());
        softAssert.assertEquals(testCasePage.getExistTestCaseStepValue("Input data"), testCase.getStepsData());
        softAssert.assertEquals(testCasePage.getExistTestCaseStepValue("Expected result"), testCase.getStepsExpectedResult());

        testCasePage.openProperties();
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-severity"), testCase.getSeverity());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-priority"), testCase.getPriority());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-type"), testCase.getType());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-layer"), testCase.getLayer());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-is_flaky"), testCase.getIsFlaky());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-behavior"), testCase.getBehavior());
        softAssert.assertEquals(testCasePage.getExistTestCasePropertiesValue("0-isManual"), testCase.getAutomationStatus());

        softAssert.assertAll();

        projectRepositorySteps.openSettingsForProject();
        deleteProjectModalSteps.deleteNewProject();
    }
}