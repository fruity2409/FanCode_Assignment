package org.fancode.service;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.fancode.BaseClass;
import org.fancode.model.ToDo;

import java.util.Arrays;
import java.util.List;

import static org.fancode.util.ApiUtil.TODOS_ENDPOINT;


public class ToDoService extends BaseClass {

    public  List<ToDo> getTodosByUserId(int userId) {
        Gson gson = new Gson();
        Response response = getRequest(TODOS_ENDPOINT)
                .queryParam("userId", userId)
                .get();

       ToDo [] todo = gson.fromJson(response.asString(),ToDo[].class);

        return Arrays.asList(todo);
    }


    public boolean isUserTaskCompletionAboveThreshold(int userId, double target) {
        List<ToDo> todos = getTodosByUserId(userId);
        long totalTasks = todos.size();
        int count = 0;
        for (ToDo todo : todos) {
            if(todo.isCompleted())
            {
               count++ ;
            }
        }

        return totalTasks > 0 && ((double) count / totalTasks) > target;
    }
}
