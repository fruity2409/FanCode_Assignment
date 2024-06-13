package org.fancode;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.fancode.util.ApiUtil.BASE_URL;

public class BaseClass {

    protected static RequestSpecification getRequest(String endpoint)
    {
        return RestAssured.
                given().
                baseUri(BASE_URL).
                basePath(endpoint).
                contentType("application/json");
    }
}
