package xproject.xdriver;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xproject.xdriver.impl.response.XSessionInfo;

@Singleton
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface XDriver {
	
	@POST
	@Path("/session")
	/*
	 * {
		  "desiredCapabilities": {
		    "browserName": "MicrosoftEdge",
		    "version": "",
		    "platform": "WINDOWS"
		  },
		  "capabilities": {
		    "firstMatch": [
		      {
		        "browserName": "MicrosoftEdge",
		        "platformName": "windows"
		      }
		    ]
		  }
		}
	 */
	XReturn<XSessionInfo> xnewSession(XCapabilitiesInfo capabilities) throws Exception;
	
	
	@Path("session/{session_id}")
	XSession xsession(@PathParam("session_id") String session_id) throws Exception;
	
}
