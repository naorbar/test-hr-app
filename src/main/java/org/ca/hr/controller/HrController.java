package org.ca.hr.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.ca.hr.managers.HrManager;
import org.ca.hr.objects.DeletedUserResponse;
import org.ca.hr.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * UsersController Description: manages the Users database 
 * @author bad.programmer@ca.com
 */

@Controller
public class HrController {

	@Autowired
    private HrManager hrManager;
	
	@ResponseBody
    @RequestMapping(value="/print", method = RequestMethod.GET)
    public String printHello() {
		return "HELLO WORLD";
    }
	
	@RequestMapping(value="/users/load", method=RequestMethod.GET)
	@ResponseBody
	public void loadUsers() throws Exception {
		try {
			hrManager.loadUsers();
		} catch (Exception e) {
			throw new Exception("Failed to load users");
		}
	}
	
	@RequestMapping(value="/users")
	@ResponseBody
	public List<User> getUsers() throws Exception {
			return hrManager.getUsers();
	}
	
	@ResponseBody
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") String id ) throws Exception {
		try	{
			return hrManager.getUser(id);
		} catch (Exception e) {
			throw new Exception("Failed to retrive the user from the users list: " + e.getMessage(), e);
		}
	}	
	
	@ResponseBody
	@RequestMapping(value="/users/insert", method = RequestMethod.POST)
	public boolean insertUser(@RequestBody User uiUser) throws Exception {
		try	{
			return hrManager.insertUser(uiUser);
		} catch (Exception e) {
			throw new Exception("Failed to insert the user - " + e.getMessage(), e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/users/delete/{id}", method = RequestMethod.POST)
	public boolean deleteUser(@PathVariable("id") String id ) throws Exception {
		try	{
			return hrManager.deleteUser(id);
		} catch (Exception e) {
			throw new Exception("Failed to delete user: " + id + " - " + e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/users/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateCaUser(@RequestBody User uiUser) throws Exception {
		return hrManager.updateUser(uiUser);
	}

	@RequestMapping(value="/users/delete22", method = RequestMethod.POST)
	@ResponseBody
	public List<DeletedUserResponse> deleteUsers2(@RequestBody List<String> uiUersList) throws Exception {
		try	{
			for (String string : uiUersList)
				hrManager.deleteUser(string);
			return null;
		} catch (Exception e) {
			throw new Exception("Failed to dalete users - " + e.getMessage(), e);
		}
	}
}
	





