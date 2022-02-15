package com.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Project.Entities.Role;
import com.Project.Entities.User;

public class Userdetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public Userdetail(User user) {
		this.user = user;
	}
	
	/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
*/
	@Override
	public String getPassword() {
		return user.getPass();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Role getR() {
		return user.getR();
	}
	
	public String getEmail() {
		return user.getEmail();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    Role roles = user.getR();
	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	     
	
	        authorities.add(new SimpleGrantedAuthority(roles.getNom()));
	    
	     
	    return authorities;
	}

}
