package org.fancode;



import org.fancode.model.User;
import org.fancode.service.ToDoService;
import org.fancode.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class UserTest {


    private final UserService userService = new UserService();
    private final ToDoService toDoService = new ToDoService();

    @Test
    public void testFancodeUsersTaskCompletion() {
        List<User> fancodeUsers = userService.getFancodeUsers(-40, 5, 5, 100);

        Assert.assertFalse(fancodeUsers.isEmpty(), "No users found for FanCode city!");

        for (User user : fancodeUsers) {
            boolean isAboveThreshold = toDoService.isUserTaskCompletionAboveThreshold(user.getId(), 0.5);
            Assert.assertTrue(isAboveThreshold, "User " + user.getUsername() + " does not have more than 50% tasks completed.");
        }
    }
}

