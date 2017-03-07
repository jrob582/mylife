
package mylife.validator;

import java.util.logging.Logger;
import mylife.objects.client1;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author johna
 */

@Component
public class client1Validator implements Validator {
    
    private static final Logger logger = Logger.getLogger(client1Validator.class.getName());

    /**
     *
     * @param clazz
     * @return
     */
    @Override
	public boolean supports(Class<?> clazz) {
		return client1.class.isAssignableFrom(clazz);
	}

    /**
     *
     * @param target
     * @param errors
     */
    @Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "client1.firstname.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "client1.lastname.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressline1", "client1.addressline1.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "client1.email.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "current_status","client1.current_status.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone_number", "client1.phone_number.required");
        client1 client1 = (client1)target;
		if(client1.getFirstname().length() > 120) {
			errors.rejectValue("firstname","client1.name.length");
		}
        
        if (!client1.getFirstname().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("firstname","client1.firstname.pattern");
        }
	
        if (client1.getLastname().length() > 120){
            errors.rejectValue("lastname", "client1.lastname.length");
        }
        
        if (!client1.getLastname().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("lastname","client1.lastname.pattern");
        }
        
        if (client1.getAddressline1().length() > 128){
            errors.rejectValue("addressline1","client1.addressline1.length");
        }
        if (!client1.getAddressline1().matches("^[A-Za-z0-9 _.,!\"'/$]*$")){
            errors.rejectValue("addressline1","client1.addressline1.pattern");
        }
        
        if (client1.getAddressline2().length() > 128){
            errors.rejectValue("addressline2","client1.addressline2.length");
        }
        
        if (!client1.getAddressline2().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("addressline2","client1.addressline2.pattern");
        }
        
        if (client1.getCity().length()> 120){
            errors.rejectValue("city","client1.city.length");
        }
        
        if (!client1.getCity().matches("^[a-zA-Z-\\s]+$")){
            errors.rejectValue("city","client1.city.pattern" );
        }
        
        if (client1.getState().length() >120){
            errors.rejectValue("state","client1.state.length");
        }
        
        if (!client1.getState().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("state","client1.state.pattern");
        }
           
        if (client1.getZip().length() >10){
            errors.rejectValue("zip","client1.zip.length");
        }
        
        if (!client1.getZip().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("zip","client1.zip.pattern");
        }
        
        if (client1.getEmail().length()>65 ){
            errors.rejectValue("email","client1.email.length");
        }
        
        if (!client1.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            errors.rejectValue("email","client1.email.pattern");
            
        }      
        if (client1.getCurrent_status().length() > 60){
            errors.rejectValue("current_status", "client1.current_status.length");
        }
        
        if (!client1.getCurrent_status().matches("^[A-Za-z0-9]*$")){
            errors.rejectValue("current_status", "client1.current_status.pattern");
            
        }
        
        if (client1.getPhone_number().length()>25){
            errors.rejectValue("phone_number","client1.phone_number.length");
        }
        
        if (!client1.getPhone_number().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")){
            errors.rejectValue("phone_number","client1.phone_number.pattern");
        }
        
        
        }
        
        
        
    
}
