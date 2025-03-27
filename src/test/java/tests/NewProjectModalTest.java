package tests;

import objects.Project;
import org.testng.annotations.Test;

public class NewProjectModalTest extends BaseTest {

    @Test
    public void createProjectAndCheckDetails() {
        Project project = new Project();
        project.setProjectName("Project name value");
        project.setProjectCode("CODEVALUE");
        project.setDescription("Description value");

        newProjectModalSteps.createNewProject(project);
        projectRepositorySteps.openSettingsForProject();
        softAssert.assertEquals(projectSettingsPage.getExistInputValue("project-name"), project.getProjectName());
        softAssert.assertEquals(projectSettingsPage.getExistInputValue("project-code"), project.getProjectCode());
        softAssert.assertEquals(projectSettingsPage.getExistInputValue("description-area"), project.getDescription());

        softAssert.assertAll();

        deleteProjectModalSteps.deleteNewProject();
    }
}