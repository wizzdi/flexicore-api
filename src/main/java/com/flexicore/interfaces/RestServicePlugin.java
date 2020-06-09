package com.flexicore.interfaces;

import org.pf4j.ExtensionPoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RestServicePlugin extends Plugin, ExtensionPoint {

}
