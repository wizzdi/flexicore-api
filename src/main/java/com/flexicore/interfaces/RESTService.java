package com.flexicore.interfaces;

import com.flexicore.annotations.InheritedComponent;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@InheritedComponent
public interface RESTService {

}
