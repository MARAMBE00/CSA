package com.example.helloworldrestapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//the 'rest' address is mapped to the REST services
@ApplicationPath("rest") //
// a javax.ws.rs.core.Application must be extended
public class RestConfig extends Application{

}

