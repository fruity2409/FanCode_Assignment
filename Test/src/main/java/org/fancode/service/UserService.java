package org.fancode.service;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.fancode.BaseClass;

import org.fancode.model.User;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.fancode.util.ApiUtil.USERS_ENDPOINT;

public class UserService extends BaseClass {

    public List<User> getUsers() {

        Gson gson = new Gson();
        Response response = getRequest(USERS_ENDPOINT).get();
        User []  user = gson.fromJson(response.asString(),User[].class);

        System.out.println(response.getBody().asString());
         return Arrays.asList(user);

    }

    public List<User> getFancodeUsers(double lat ,double lng,double lat1,double lng1) {
          List<User> users = getUsers();
          List<User> fancodeUsers = new ArrayList<>();
          for(User user : users) {
              User.Address.Geo geo = user.getAddress().getGeo();
              double lattitude = geo.getLat();
              double longitude = geo.getLng();
              if(lattitude >= lat && lattitude <= lat1 && longitude >= lng && longitude <= lng1)
              {
                  fancodeUsers.add(user);
              }
          }

          return fancodeUsers;
    }
}
