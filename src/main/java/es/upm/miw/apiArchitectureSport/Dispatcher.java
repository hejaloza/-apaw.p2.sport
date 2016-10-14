package es.upm.miw.apiArchitectureSport;


import es.upm.miw.apiArchitectureSport.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidVoteException;

import java.util.Map;

import es.upm.miw.apiArchitectureSport.api.SportResource;
import es.upm.miw.apiArchitectureSport.api.UserResource;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private SportResource sportResource = new SportResource();
	private UserResource userResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/sports

		if ("sports".equals(request.getPath())) {
			response.setBody(sportResource.themeList().toString());
			// **/themes/{id}/overage
		} else if ("users".equals(request.getPath())) {
			response.setBody(userResource.voteList().toString());
			
		}else if (("users".equals(request.getPath().split("/")[0]))&& (request.getPath().split("/")[1]).startsWith("search")) {
			try {
				
				String urlParametros=request.getPath().split("/")[1];
				int inicio = urlParametros.indexOf("=");
				String sport=urlParametros.substring(inicio + 1);
				response.setBody(userResource.usersBySport(sport).toString2());
			} catch (Exception e) {
				responseError(response, e);
			}
			// **/votes
		}  else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/themes body="themeName"
		case "sports":
			// Injectar parámetros...
			try {
				sportResource.createTheme(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidThemeFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST votes body="themeId:vote"
		case "users":
			String themeId = request.getBody().split(":")[0];
			String vote = request.getBody().split(":")[1];
			try {
				userResource.createVote(themeId, vote);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		//String nickUser = request.getPath().split("/")[1];
	
		if ("users".equals(request.paths()[0]) && "sports".equals(request.paths()[2])) {
		
			try {
			//	String nickUser = request.getPath().split("/")[1];
				String nickUser = request.paths()[1];
				String SportUser = request.getBody();
				System.out.println("Path"+nickUser);
				//String nickUser="dos";
			//	String SportUser="ajedrez";
				userResource.updateUser(nickUser,SportUser);
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidVoteException e) {
				this.responseError(response, e);
			}
		}else{
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
