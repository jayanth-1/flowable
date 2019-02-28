package com.example.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FlowableService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public void startProcess(Long id) {
        Map<String, Object> variables = new HashMap<String, Object>();
        System.out.println("appraisal json "+id);
        variables.put("id",id );
        System.out.println("variables"+variables);

        runtimeService.startProcessInstanceByKey("appraisalCycle", variables);
        System.out.println("process started");


//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTUxMjUxMDg0LCJleHAiOjE1NTIxMTUwODQsInJvbGUiOnsiYXV0aG9yaXR5IjoiUk9MRV9FTVAifX0.Vz3SP1rGwTSeE1g2LDw4pSuOy8kqNcY9K2BhU-cZAY2y0EufaABKDANNX3FP3qV8sxIf6A-7nWb6ztJ8dwHzgg");
//
//        HttpEntity entity = new HttpEntity(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/zetalent/managers", HttpMethod.GET,entity,String.class);
//        System.out.println(response);
    }

    @Transactional
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }


}
