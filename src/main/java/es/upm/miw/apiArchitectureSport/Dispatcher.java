package es.upm.miw.apiArchitectureSport;

import es.upm.miw.apiArchitectureSport.exceptions.InvalidRequestException;
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
		// **GET/sports
		if ("sports".equals(request.getPath())) {
			response.setBody(sportResource.sportList().toString());
			// **GET/users
		} else if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **GET/users/search?sport=*
		} else if (("users".equals(request.getPath().split("/")[0]))
				&& (request.getPath().split("/")[1]).startsWith("search")) {
			try {
				String urlParams = request.getPath().split("/")[1];
				int indexParam = urlParams.indexOf("=");
				String sportName = urlParams.substring(indexParam + 1);
				response.setBody(userResource.usersBySport(sportName).returnNick());
			} catch (Exception e) {
				responseError(response, e);
			}

		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// **POST/sports body="sportName"
		case "sports":
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		// **POST/users body="nick:email"
		case "users":
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			try {
				userResource.createUser(nick, email);
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
		// **PUT/users/{nick}/sport body="sportName"
		if ("users".equals(request.paths()[0]) && "sports".equals(request.paths()[2])) {
			try {
				String nick = request.paths()[1];
				String sportName = request.getBody();
				userResource.updateUser(nick, sportName);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
		} else {
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
