package com.mmcgarvey.todoist.client.api;

import com.mmcgarvey.todoist.client.ApiClient;
import com.mmcgarvey.todoist.client.EncodingUtils;

import java.math.BigDecimal;
import com.mmcgarvey.todoist.client.models.Label;
import com.mmcgarvey.todoist.client.models.Project;
import com.mmcgarvey.todoist.client.models.ProjectToCreate;
import com.mmcgarvey.todoist.client.models.Task;
import com.mmcgarvey.todoist.client.models.TaskToCreate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-03-05T22:57:37.991-06:00")
public interface TodoistApi extends ApiClient.Api {


  /**
   * 
   * 
    * @param id  (required)
   */
  @RequestLine("POST /tasks/{id}/close")
  @Headers({
    "Accept: application/json",
  })
  void closeTask(@Param("id") BigDecimal id);

  /**
   * 
   * 
    * @param labelToCreate  (optional)
   * @return Label
   */
  @RequestLine("POST /labels")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Label createLabel(Label labelToCreate);

  /**
   * 
   * Create a new project
    * @param projectToCreate  (optional)
   * @return Project
   */
  @RequestLine("POST /projects")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Project createProject(ProjectToCreate projectToCreate);

  /**
   * 
   * 
    * @param task  (required)
   * @return Task
   */
  @RequestLine("POST /tasks")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Task createTask(TaskToCreate task);

  /**
   * 
   * 
    * @param id  (required)
   */
  @RequestLine("DELETE /labels/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteLabel(@Param("id") BigDecimal id);

  /**
   * 
   * 
    * @param id  (required)
   */
  @RequestLine("DELETE /projects/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProject(@Param("id") String id);

  /**
   * 
   * Get All Projects
   * @return List&lt;Project&gt;
   */
  @RequestLine("GET /projects")
  @Headers({
    "Accept: application/json",
  })
  List<Project> getAllProjects();

  /**
   * 
   * 
    * @param id  (required)
   * @return Label
   */
  @RequestLine("GET /labels/{id}")
  @Headers({
    "Accept: application/json",
  })
  Label getLabel(@Param("id") BigDecimal id);

  /**
   * 
   * 
   * @return List&lt;Label&gt;
   */
  @RequestLine("GET /labels")
  @Headers({
    "Accept: application/json",
  })
  List<Label> getLabels();

  /**
   * 
   * 
    * @param id  (required)
   * @return Project
   */
  @RequestLine("GET /projects/{id}")
  @Headers({
    "Accept: application/json",
  })
  Project getProject(@Param("id") String id);

  /**
   * 
   * 
    * @param id  (required)
   * @return Task
   */
  @RequestLine("GET /tasks/{id}")
  @Headers({
    "Accept: application/json",
  })
  Task getTask(@Param("id") BigDecimal id);

  /**
   * 
   * 
    * @param projectId  (optional)
    * @param labelId  (optional)
   * @return List&lt;Task&gt;
   */
  @RequestLine("GET /tasks?project_id={projectId}&label_id={labelId}")
  @Headers({
    "Accept: application/json",
  })
  List<Task> getTasks(@Param("projectId") BigDecimal projectId, @Param("labelId") Integer labelId);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetTasksQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>projectId -  (optional)</li>
   *   <li>labelId -  (optional)</li>
   *   </ul>
   * @return List&lt;Task&gt;
   */
  @RequestLine("GET /tasks?project_id={projectId}&label_id={labelId}")
  @Headers({
  "Accept: application/json",
  })
  List<Task> getTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getTasks</code> method in a fluent style.
   */
  public static class GetTasksQueryParams extends HashMap<String, Object> {
    public GetTasksQueryParams projectId(final BigDecimal value) {
      put("project_id", EncodingUtils.encode(value));
      return this;
    }
    public GetTasksQueryParams labelId(final Integer value) {
      put("label_id", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
    * @param id  (required)
    * @param label  (required)
   */
  @RequestLine("POST /labels/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLabel(@Param("id") BigDecimal id, Label label);

  /**
   * 
   * 
    * @param id  (required)
   */
  @RequestLine("POST /projects/{id}")
  @Headers({
    "Accept: application/json",
  })
  void updateProject(@Param("id") String id);
}
