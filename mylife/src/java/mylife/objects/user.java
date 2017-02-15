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
    private List<String> roles;
    private Map<String, String> rolemap;
    
    public user(){
        this.rolemap = new LinkedHashMap<String,String>();
        this.rolemap.put("role_user", "user");
        this.rolemap.put("role_admin", "administrator");
    }
    
    public String getUser_name() {
        return username;
    }

    public void setUser_name(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  public Map<String,String> getrolemap(){
      return this.rolemap;
  }
   
  public List<String> getroles(){
      return roles;
  }
  
  public void setroles (List<String> roles){
      this.roles = roles;
  }
  
  public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("User Name: " + this.username + ";");
        buffer.append("Password: " + password + ";");
     
        
              return buffer.toString();
    }
    }
    

