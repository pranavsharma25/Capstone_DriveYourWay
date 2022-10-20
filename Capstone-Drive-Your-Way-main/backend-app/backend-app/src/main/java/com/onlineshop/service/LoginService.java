package com.onlineshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.bean.Login;
import com.onlineshop.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("admin")) {
							return "Admin login successfull";
				}else if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("user")){
							return "User login successfull";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "Email Id already exists";
		}else {
			if(login.getTypeOfUser().equals("admin")) {
				return "You cannot create admin account";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}	
	}
}
