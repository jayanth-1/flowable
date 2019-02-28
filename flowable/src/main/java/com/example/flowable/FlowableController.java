package com.example.flowable;


import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowableController {

    @Autowired
    private FlowableService myService;

    @RequestMapping(value="/process", method= RequestMethod.POST)
    public void startProcessInstance(@RequestBody Long id) throws JSONException {

        System.out.println(id);

        myService.startProcess(id);
    }


    @RequestMapping(value="/tasks", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public void getTasks(@RequestBody JsonNode jsonNode) {
        System.out.println("tasks called");
//        List<Task> tasks = myService.getTasks(assignee);
//        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
//        for (Task task : tasks) {
//            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
//        }
//        System.out.println(dtos);

        System.out.println(jsonNode);

    }



}

