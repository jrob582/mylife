/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author johna
 */
public class interactions implements Serializable {
    private int interactionid;
    private int clientsid;
    private String date_of_contact;
    private String contact_name;
    private String contact_type;
    private String conversation;

    private client1 client1;
    private Map<Integer, String> clients1;

    /**
     *
     * @return
     */
    public client1 getClient1() {
        return client1;
    }

    /**
     *
     * @param client1Map
     */
    public void setclient1(Map<Integer, String> client1Map) {
        this.client1 = client1;
    }
    
    /**
     *
     * @return
     */
    public int getInteraction_Id() {
        return interactionid;
    }

    /**
     *
     * @param interaction_Id
     */
    public void setInteraction_Id(int interaction_Id) {
        this.interactionid = interaction_Id;
    }

    /**
     *
     * @return
     */
    public int getClients_id() {
        return clientsid;
    }

    /**
     *
     * @param clients_id
     */
    public void setClients_id(int clients_id) {
        this.clientsid = clients_id;
    }

    /**
     *
     * @return
     */
    public String getDate_of_contact() {
        return date_of_contact;
    }

    /**
     *
     * @param date_of_contact
     */
    public void setDate_of_contact(String date_of_contact) {
        this.date_of_contact = date_of_contact;
    }

    /**
     *
     * @return
     */
    public String getContact_name() {
        return contact_name;
    }

    /**
     *
     * @param contact_name
     */
    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    /**
     *
     * @return
     */
    public String getContact_type() {
        return contact_type;
    }

    /**
     *
     * @param contact_type
     */
    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    /**
     *
     * @return
     */
    public String getConversation() {
        return conversation;
    }

    /**
     *
     * @param conversation
     */
    public void setConversation(String conversation) {
        this.conversation = conversation;
    }


    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("InteractionID: " + this.interactionid + ";");
        buffer.append("Clients Id: " + clientsid + ";");
        buffer.append("Date Of Contact: " + date_of_contact + ";");
        buffer.append("Contact Name " + contact_name + ";");
        buffer.append("Contact Type: " + contact_type + ";");
        buffer.append("Conversation: " + conversation + ";");


        return buffer.toString();
    }

 

    



    
    
    
}
