package com.mmcgarvey.cltodoist;

import com.mmcgarvey.todoist.client.ApiClient;
import com.mmcgarvey.todoist.client.api.TodoistApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoistMain {

    public static void main(String[] args) {
        SpringApplication.run(TodoistMain.class, args);
    }

    @Bean
    public TodoistApi todoistApi(@Value("${todoist.api.token}") String token) {
        String bearer = "Bearer " + token;
        ApiClient apiClient = new ApiClient();
        apiClient.addAuthorization("authorization", rt -> rt.header("Authorization", bearer));
        return apiClient.buildClient(TodoistApi.class);
    }
}
