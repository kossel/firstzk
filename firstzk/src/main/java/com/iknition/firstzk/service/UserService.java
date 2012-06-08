/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iknition.firstzk.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author coslit
 */
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
