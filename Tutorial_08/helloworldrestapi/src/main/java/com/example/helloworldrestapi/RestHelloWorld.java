package com.example.helloworldrestapi;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
// @Provider tell the server that this is a REST class
@Provider
// define the path for this class: [server]/rest/examples
@Path("examples")
public class RestHelloWorld {

    // path used to call the method [server]/rest/examples/examples
    @Path("helloWorld")

// answer only to a http get request
    @GET
    public String hello(){ // return a simple string (text/plain by default)
        return "Hello World"; // string to be returned
    }
    @Path("helloJSON")
    @GET
    @Produces("application/json")

// Create a list and add two messages that will be displayed after invoking the GET request
    public List<String> helloJSONList(){
        List<String> jsonList = new ArrayList<String>();
        jsonList.add("Hello World");
        jsonList.add("Client Server Architecture");

        return jsonList;

    }
}
