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
    
    public user(){
        this.rolemap = new LinkedHashMap<String,String>();
        this.rolemap.put("role_user", "user");
        this.rolemap.put("role_admin", "administrator");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Map<String, String> getRolemap() {
        return rolemap;
    }

    }
    

