package es.upm.miw.apiArchitectureSport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
	List<UserWrapper> userList = new ArrayList<>();

	public UserListWrapper() {
	}

	public List<UserWrapper> getUserList() {
		return userList;
	}

	public void addUserWrapper(UserWrapper userWrapper) {
		userList.add(userWrapper);
	}

	@Override
	public String toString() {
		String result = "{\"userList\":[ ";
		for (UserWrapper userWrapper : userList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

	public String toString2() {
		String result = "{\"userList\":[ ";
		for (UserWrapper userWrapper : userList) {
			result += userWrapper.toString2() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
