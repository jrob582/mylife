/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.respository;

import mylife.objects.client1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author johna
 */
public class client1DAO {
  
    JdbcTemplate template;
    
     private static final Logger logger = Logger.getLogger(client1DAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(client1 client1){
        String sql = "INSERT INTO client1 (firstname, lastname, addressline1, addressline2, city, state, zip, email, currentstatus, phone_number) values(?,?,?,?,?,?,?,?,?,?)";
        
          Object[] values = {client1.getFirstname(), client1.getLastname(), client1.getAddressline1(), client1.getAddressline2(), client1.getCity(), client1.getState(), client1.getZip(), client1.getEmail(), client1.getCurrent_status(), client1.getPhone_number()};
          logger.info("Interactions DAO save values: " + values);
        return template.update(sql,values);
    }

    public int update(client1 client1){
        String sql = "UPDATE client1 SET firstname=?, lastname=?, addressline1=?, addressline2=?, city=?, state=?, zip=?, email=?, currentstatus=?, phone_number=? WHERE idclient1= ?"; 
        
         Object[] values = {client1.getFirstname(), client1.getLastname(), client1.getAddressline1(), client1.getAddressline2(), client1.getCity(), client1.getState(), client1.getZip(), client1.getEmail(), client1.getCurrent_status(), client1.getPhone_number(), client1.getIdclient1()};
        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM client1 WHERE idclient1=?" ;
        
        Object[] values = {id};
        return template.update(sql,values);
    }
        public List<client1> getclient1List(){
        return template.query("SELECT * FROM client1",new RowMapper<client1>(){
            public client1 mapRow(ResultSet rs,int row) throws SQLException{
                client1 c = new client1();
                c.setIdclient1(rs.getInt("client1Id"));
                c.setFirstname(rs.getString(" First_Name"));
                c.setLastname(rs.getString("Last_Name"));
                c.setAddressline1(rs.getString("Address_Line1"));
                c.setAddressline2(rs.getString("Address_Line2"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setZip(rs.getString("Zip"));
                c.setEmail(rs.getString("Email"));
                c.setCurrent_status(rs.getString("Current_status"));
                c.setPhone_number(rs.getString("Phone_number"));
                return c;
            }
        });
    }

            public client1 getclient1ById(int id){
        String sql = "SELECT idclient1 AS id, firstname, lastname, addressline1, addressline2, city, state, zip, email, currentstatus, phone_number FROM client1 WHERE idclient1 = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<client1>(client1.class));
    }
        
        
    public List<client1> getclient1ByPage(int start, int total){
        String sql = "SELECT * FROM client1 LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<client1>(){
            public client1 mapRow(ResultSet rs,int row) throws SQLException{
                client1 c = new client1();
                c.setIdclient1(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setAddressline1(rs.getString(4));
                c.setAddressline2(rs.getString(5));
                c.setCity(rs.getString(6));
                c.setState(rs.getString(7));
                c.setZip(rs.getString(8));
                c.setEmail(rs.getString(9));
                c.setCurrent_status(rs.getString(10));
                c.setPhone_number(rs.getString(11));
                
                
                
                return c;
            }
        });
    }
    public int getclient1Count() {
        String sql = "SELECT COUNT(idclient1) AS rowcount FROM client1";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }

    public client1 getclient1byFirstname(String FirstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
