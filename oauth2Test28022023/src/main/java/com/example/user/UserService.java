package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUser(username);
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
	
	 @Transactional
	    public UserDetails loadUserById(String id) {
	        User user = userDao.getUserById(id);
	        if (user == null) {
	            throw new UsernameNotFoundException(id);
	        }
	        return new CustomUserDetails(user);
	    }
}
