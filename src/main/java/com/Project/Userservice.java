package com.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.CRUD.RoleCRUD;
import com.Project.CRUD.UserCRUD;
import com.Project.Entities.Employee;
import com.Project.Entities.Role;
import com.Project.Entities.User;

@Service
public class Userservice implements UserDetailsService {

	@Autowired
	private UserCRUD userRepo;
	
	@Autowired
	private RoleCRUD rc;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new Userdetail(user);
	}
	
	public void CreateUser(String email,String pass,Role role) {
		User user = new User();
	
		user.setEmail(email);
		user.setR(role);
		user.setPass(pass);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		
		userRepo.save(user);
	}
	
	
	
	public boolean Matchpass(String pass , String dbpass) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(pass, dbpass);
		
	}
	
	public User getUser(String email) {
		User u = userRepo.findByEmail(email);
		return u;
	}
	
	public void UpdatePasswordUser(User user ,String password) {
		
		user.setPass(password);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		userRepo.save(user);
	}
	
	public String EncodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}
	
	public void DeleteUser(String email) {
		User u = this.getUser(email);
		
		userRepo.delete(u);
	}
	
	
	public void updateuser(User e) {
		userRepo.save(e);
	}
	
	public void createadmin(Role role) {
		String email = "admin@sabmalek.com" ;
		String pass = "admin" ;
		boolean found = false;
		
		try{
				found = this.getUser(email).getEmail().equals(email);
			}

		catch(Exception e) { }
		
		if (found == false) {
		User user = new User();
		
		user.setEmail(email);
		
		user.setR(role);
		user.setPass(pass);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		
		userRepo.save(user);
		}
		
	}

}
