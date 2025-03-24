package tests;

import objects.Project;
import org.testng.annotations.Test;

public class DeleteProjectModalTest extends BaseTest {

    @Test
    public void deleteProjectAndCheckDetails() {
        Project project = new Project();
        project.setProjectName("Project name value for delete");
        project.setProjectCode("CODEVALUE");
        project.setDescription("Description value");

        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        newProjectModalSteps.createNewProject(project);
        projectRepositorySteps.openSettingsForProject();
        deleteProjectModalSteps.deleteNewProject();
        softAssert.assertEquals(projectsListPage.isProjectPresent(project.getProjectName()), false);

        softAssert.assertAll();
    }
}