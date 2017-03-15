/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.respository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import mylife.objects.interactions;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author johna
 */
public class interactionsDAO {
        JdbcTemplate template;
    
     private static final Logger logger = Logger.getLogger(interactionsDAO.class.getName());

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    /**
     *
     * @param interactions
     * @return
     */
    public int save(interactions interactions){
        String sql = "INSERT INTO interactions (clientsid, date_of_contact, contact_name, contact_type, coversation) values(?,?,?,?,?)";
        
                
          Object[] values = {interactions.getClients_id(), interactions.getDate_of_contact(), interactions.getContact_name(), interactions.getContact_type(), interactions.getConversation()};
          
          logger.info ("Interactions DAO save values: " + values);
          
        return template.update(sql,values);
    }

    /**
     *
     * @param interactions
     * @return
     */
    public int update(interactions interactions){
        String sql = "UPDATE interactions SET clientsid=?, date_of_contact=?, contact_name=?, contact_type=?, conversation=?  WHERE interactionid= ?"; 
        
         Object[] values = {interactions.getClients_id(), interactions.getDate_of_contact(), interactions.getContact_name(), interactions.getContact_type(), interactions.getConversation(), interactions.getInteraction_Id()};
        return template.update(sql,values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int id){
        String sql = "DELETE FROM interactions WHERE interactionid=?" ;
        
        Object[] values = {id};
        return template.update(sql,values);
    }

    /**
     *
     * @return
     */
    public List<interactions> getinteractionsList(){
        return template.query("SELECT * FROM interactions",new RowMapper<interactions>(){
            public interactions mapRow(ResultSet rs,int row) throws SQLException{
                interactions i = new interactions();
                i.setInteraction_Id(rs.getInt("interactionid"));
                i.setClients_id(rs.getInt(" Clients_id"));
                i.setDate_of_contact(rs.getString("Date_of_contact"));
                i.setContact_name(rs.getString("First_name"));
                i.setContact_type(rs.getString("Contact_type"));
                i.setConversation(rs.getString("Conversation"));
               
                return i;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public interactions getinteractionsById(int id){
        String sql = "SELECT interactionid, (clientsid, date_of_contact, contact_name, contact_type, conversation,) FROM interactions WHERE interactionid = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<interactions>(interactions.class));
    }
        
    /**
     *
     * @param start
     * @param total
     * @return
     */
    public List<interactions> getinteractionsByPage(int start, int total){
        String sql = "SELECT * FROM interactions LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<interactions>(){
            public interactions mapRow(ResultSet rs,int row) throws SQLException{
                interactions i = new interactions();
                i.setClients_id(rs.getInt(1));
                i.setDate_of_contact(rs.getString(2));
                i.setContact_name(rs.getString(3));
                i.setContact_type(rs.getString(4));
                i.setConversation(rs.getString(5));
            
                
                
                
                return i;
            }
        });
    }

    /**
     *
     * @return
     */
    public int getinteractionsCount() {
        String sql = "SELECT COUNT(interactioniD) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }

    /**
     *
     * @return
     */
    public Map<Integer,String> getclient1Map() {
        Map<Integer,String> client1 = new LinkedHashMap<Integer,String>();
        String sql = "SELECT idclient1, firstname FROM client1 ORDER BY firstname";
        
        SqlRowSet rs = template.queryForRowSet(sql); 
        
        while(rs.next()){ 
            client1.put(rs.getInt(1), rs.getString(2));
        }
        
        return client1;
    }
}

