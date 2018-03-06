package com.mmcgarvey.todoist.client.api;

import com.mmcgarvey.todoist.client.ApiClient;
import com.mmcgarvey.todoist.client.models.Label;
import com.mmcgarvey.todoist.client.models.Project;
import com.mmcgarvey.todoist.client.models.Task;
import com.mmcgarvey.todoist.client.models.TaskToCreate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TodoistApi
 */
public class TodoistApiTest {

    private TodoistApi api;

    @Before
    public void setup() {
        api = new ApiClient().buildClient(TodoistApi.class);
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void closeTaskTest() {
        Integer id = null;
        // api.closeTask(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void createLabelTest() {
        Label labelToCreate = null;
        // Label response = api.createLabel(labelToCreate);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Create a new project
     */
    @Test
    public void createProjectTest() {
        Project project = null;
        // Project response = api.createProject(project);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void createTaskTest() {
        TaskToCreate task = null;
        // Task response = api.createTask(task);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void deleteLabelTest() {
        Integer id = null;
        // api.deleteLabel(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void deleteProjectTest() {
        String id = null;
        // api.deleteProject(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Get All Projects
     */
    @Test
    public void getAllProjectsTest() {
        // List<Project> response = api.getAllProjects();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getLabelTest() {
        Integer id = null;
        // Label response = api.getLabel(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getLabelsTest() {
        // List<Label> response = api.getLabels();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getProjectTest() {
        String id = null;
        // Project response = api.getProject(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getTaskTest() {
        Integer id = null;
        // Task response = api.getTask(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getTasksTest() {
        Integer projectId = null;
        Integer labelId = null;
        // List<Task> response = api.getTasks(projectId, labelId);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getTasksTestQueryMap() {
        TodoistApi.GetTasksQueryParams queryParams = new TodoistApi.GetTasksQueryParams()
            .projectId(null)
            .labelId(null);
        // List<Task> response = api.getTasks(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     */
    @Test
    public void updateLabelTest() {
        Integer id = null;
        Label label = null;
        // api.updateLabel(id, label);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void updateProjectTest() {
        String id = null;
        // api.updateProject(id);

        // TODO: test validations
    }

    
}
