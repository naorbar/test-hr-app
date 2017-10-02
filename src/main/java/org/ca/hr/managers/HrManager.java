package org.ca.hr.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.ca.hr.objects.DeletedUserResponse;
import org.ca.hr.objects.User;
import org.springframework.stereotype.Component;


@Component
public class HrManager {
	
	List<User> usersList = new LinkedList<User>();
	public static int counter = 0;
	
	/**
	 * Load 10,000 users to the users list
	 * @author bad.programmer@ca.com
	 */
	public boolean loadUsers() throws Exception {
		try {
			for(int i = 0 ; i < 3000000 ; i++) {
				System.out.println("Adding user " + i);
				usersList.add(new User(Integer.toString(i)));
			}
			return true;
		} catch (Exception e) {
			throw new Exception("Failed to load users to the users - " + e.getMessage(), e);
		}
	}
	
	/**
	 * Returns a list of users if users found or null if no users were not found
	 * @author bad.programmer@ca.com
	 */
	public List<User> getUsers() throws Exception {
		try {
			return new ArrayList<User>(usersList);
		} catch (Exception e) {
			throw new Exception("Failed to retrive users from the users list" + e.getMessage(), e);
		}
	}	
	
	/**
	 * Searches the users list for a given user id, returns user object, or null if user was not found
	 * @author bad.programmer@ca.com
	 */
	public User getUser(String userId) throws Exception {
		try {
			return usersList.get(0);
		} catch (Exception e) {
			throw new Exception("Failed to retrive user from the users list" + e.getMessage(), e);
		}
	}
	
	public boolean insertUser(User user) throws Exception {
		try {
			usersList.add(new User(user.id));
			return true;
		} catch (Exception e) {
			throw new Exception("Failed to insert the user - " + e.getMessage(), e);
		}
	}
	
	public boolean deleteUser(String id) throws Exception {
		try	{
			for (User user : usersList)
				if (user.id.equalsIgnoreCase(id))
					usersList.remove(id);
						return true;
		} catch (Exception e) {
			throw new Exception("Failed to delete user: " + id + " - " + e.getMessage(), e);
		}
	}
	
	/**
	 * Updates a given user id in the users list. Returns true/false
	 * @author bad.programmer@ca.com	 
	 */
	public boolean updateUser(User user) throws Exception {
		try {
			usersList.add(new User(user.id));
			return true;
		} catch (Exception e) {
			throw new Exception("Failed to update the user - " + e.getMessage(), e);
		}
	}

	public List<DeletedUserResponse> deleteUsers(List<User> usersListToDelete) throws Exception {
		List<DeletedUserResponse> deletedUsersList = new ArrayList<DeletedUserResponse>();
		for (User user : usersListToDelete)
			deletedUsersList.add(new DeletedUserResponse(user.id, this.deleteUser(user.id)));
		return deletedUsersList;
	}
}
