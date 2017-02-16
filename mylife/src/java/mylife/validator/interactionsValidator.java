/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.validator;

import java.util.logging.Logger;
import mylife.objects.interactions;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
/**
 *
 * @author johna
 */
public class interactionsValidator implements Validator {
    
    
        private static final Logger logger = Logger.getLogger(interactionsValidator.class.getName());

    /**
     *
     * @param clazz
     * @return
     */
    @Override
	public boolean supports(Class<?> clazz) {
		return interactions.class.isAssignableFrom(clazz);
	}

    /**
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
       		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientsid", "interactions.clientsid.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_of_contact", "interactions.date_of_contact.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact_name", "interactions.contact_name.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact_type", "interactions.contact_type.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "conversation", "interactions.conversation.required");
    
          interactions interactions = (interactions)target;
          
                    
          
        if(interactions.getClients_id().length() > 120) {
	    errors.rejectValue("clients_id","interactions.clients_id.length");
	}
                
        if (!interactions.getClients_id().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("clients_id","interactions.clients_id.pattern");
        }
	
        if (interactions.getDate_of_contact().length() > 120){
            errors.rejectValue("date_of_contact", "interactions.date_of_contact.length");
        }
        
        if (!interactions.getDate_of_contact().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("date_of_contact","interactions.date_of_contact.pattern");
        }
        
        if (interactions.getContact_name().length() > 120){
            errors.rejectValue("contact_name","interactions.contact_name.length");
        }
        if (interactions.getContact_name().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("contact_name","interactions.contact_name.pattern");
        }
        
        if (interactions.getContact_type().length() > 45){
            errors.rejectValue("contact_type","interactions.contact_type.length");
        }
        
        if (!interactions.getContact_type().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("contact_type","interactions.contact_type.pattern");
        }
        
        if (interactions.getConversation().length()> 200){
            errors.rejectValue("conversation","interactions.conversation.length");
        }
        
        if (!interactions.getConversation().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("conversation","interaction.conversation.pattern" );
        }
        

}
}
