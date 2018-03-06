package com.mmcgarvey.cltodoist;

import com.mmcgarvey.todoist.client.api.TodoistApi;
import com.mmcgarvey.todoist.client.models.Project;
import com.mmcgarvey.todoist.client.models.Task;
import com.mmcgarvey.todoist.client.models.TaskToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ShellComponent
public class Commands {
    private BigDecimal currentProjectId;

    private final TodoistApi todoistApi;

    @Autowired
    public Commands(TodoistApi todoistApi) {
        this.todoistApi = todoistApi;
    }

    @ShellMethod("Show all project names.")
    public List<Project> projects() {
        return todoistApi.getAllProjects();
    }

    @ShellMethod("Delete a project by id.")
    public void deleteProject(BigInteger id) {
        todoistApi.deleteProject(id.toString());
    }

    @ShellMethod("Set as current project.")
    public void currentProject(BigInteger id) {
        this.currentProjectId = new BigDecimal(id);
    }

    @ShellMethod("Add a task")
    public Task addTask(String content,
                        @ShellOption(defaultValue = "0") Integer priority,
                        @ShellOption(defaultValue = "<none>") String dueDate,
                        @ShellOption(defaultValue = "<none>") String dueString) {
        TaskToCreate taskToCreate = new TaskToCreate();
        taskToCreate.content(content);
        if (!dueDate.equals("<none>")) {
            taskToCreate.setDueDate(LocalDate.parse(dueDate));
        } else if (!dueString.equals("<none>")) {
            taskToCreate.setDueString(dueString);
        } else {
            taskToCreate.setDueDate(LocalDate.now().plus(1, ChronoUnit.DAYS));
        }

        if (currentProjectId != null) {
            taskToCreate.setProjectId(currentProjectId);
        }
        taskToCreate.setPriority(priority);

        return todoistApi.createTask(taskToCreate);
    }

    @ShellMethod("View tasks for current project.")
    public List<Task> tasks() {
        return todoistApi.getTasks(currentProjectId, null);
    }

    public Availability tasksAvailability() {
        return currentProjectId != null ? Availability.available() : Availability.unavailable("you must set a current project");
    }

    @ShellMethod("Complete a task.")
    public void complete(BigInteger id) {
        todoistApi.closeTask(new BigDecimal(id));
    }
}
