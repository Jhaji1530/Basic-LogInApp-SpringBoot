package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepostory;

	public String saveUser(User user) {

		System.out.println("Inside Userservice Saveuser Method is executing");

		try {
			if (user != null) {
				User userFrmDb = userRepostory.save(user);
				if (userFrmDb != null) {
					return "User Registered Successsfully";
				} else {
					return "Failed to register the user";
				}
			} else {
				return "received invalid data";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return "Operation Failed";
		}

	}

	public Object getDetailsById(int id) {
		return userRepostory.findAll();
	}

	public String userLogin(User user) {
		System.out.println("Inside LogIn method!!");
		try {
			if (user != null) {
				User ud = userRepostory.findByUserId(user.getUserId());
				if (ud != null) {
					if (ud.getPassWord().equals(user.getPassWord())) {
						return "Login successful !!!!******$$$$$$@@@@@@^^^^^^^";
					} else {
						return "Invalid password";
					}
				} else {
					return "User Id not found";
				}
			} else {
				return "Invalid data";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Opreation filed";
		}
	}

	public String updatePassword(User user) {
		System.out.println("Inside Password update method");
		try {
			if (user != null) {
				User usr = userRepostory.findByUserId(user.getUserId());
				if (usr != null) {
					userRepostory.save(user);
					return "Password updated successfully";
				} else {
					return "User id not found";
				}
			} else {
				return "Invalid data";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Unable to update password";
		}

	}
}
