/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author johna
 */
public class user  implements Serializable { 
    
    private String username;
    private String password;
    private Boolean enabled = true;
    private List<String> roles;
    private Map<String, String> rolemap;
    
    /**
     *
     */
    public user(){
        this.rolemap = new LinkedHashMap<String,String>();
        this.rolemap.put("ROLE_USER", "user");
        this.rolemap.put("ROLE_ADMIN", "administrator");
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     *
     * @return
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getRolemap() {
        return rolemap;
    }

    }
    

