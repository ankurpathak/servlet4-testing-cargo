package com.github.ankurpathak.integration;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FilterServletTest {

    @Test
    public void standard_servlet_should_return_simple_text() throws MalformedURLException {
        Response response = RestAssured.get("http://localhost:8080/cargo/TestServlet");
        assertThat(response.getBody().print(), is(equalTo("Hello World!")));
    }

    @Test
    public void jsp_should_return_200() throws MalformedURLException {
        Response response = RestAssured.get("http://localhost:8080/cargo");
        assertThat(response.getStatusCode(), is(equalTo(200)));
    }
}