/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.validator;

import java.util.logging.Logger;
import mylife.objects.user;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author johna
 */
public class userValidator implements Validator {

    private static final Logger logger = Logger.getLogger(userValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return user.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.required");
    }
    
 
}
