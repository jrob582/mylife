/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.respository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import mylife.objects.user;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author johna
 */
public class userDAO {
            JdbcTemplate template;
    
     private static final Logger logger = Logger.getLogger(userDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(user user){
        String sql = "INSERT INTO user (username, password,) values(?,?)";
        
          Object[] values = {user.getUser_name(), user.getPassword(),};
          
        return template.update(sql,values);
    }

    public int update(user user){
        String sql = "UPDATE user SET username=?, password=?, WHERE userid= ?"; 
        
         Object[] values = {user.getUser_name(), user.getPassword(),};
        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM user WHERE userid=?" ;
        
        Object[] values = {id};
        return template.update(sql,values);
    }
        public List<user> getuserList(){
        return template.query("SELECT * FROM user",new RowMapper<user>(){
            public user mapRow(ResultSet rs,int row) throws SQLException{
                user u = new user();
                u.setUser_name(rs.getString("User_name"));
                u.setPassword(rs.getString(" Password"));
               
 
               
                return u;
            }
        });
    }

            public user getuserById(int id){
        String sql = "SELECT userId AS id, (username, password ) FROM user WHERE userId = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<user>(user.class));
    }
        
        
    public List<user> getuserByPage(int start, int total){
        String sql = "SELECT * FROM interaction LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<user>(){
            public user mapRow(ResultSet rs,int row) throws SQLException{
                user u = new user();
                u.setUser_name(rs.getString(1));
                u.setPassword(rs.getString(2));
              
        
                
                
                
                return u;
            }
        });
    }
    public int getuserCount() {
        String sql = "SELECT COUNT(userID) AS rowcount FROM user";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
