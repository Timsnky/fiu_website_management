/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.engine.PathImpl;

/**
 *
 * @author adel
 */
public abstract class HelperBaseCh5 extends HelperBaseCh4{
   
    public Map<String, String> errorMap = new HashMap<String, String>();
    
    protected static final ValidatorFactory validatorFactory 
            = Validation.buildDefaultValidatorFactory();
    
    protected static final Validator validator 
            = validatorFactory.getValidator(); 
    
    public HelperBaseCh5(HttpServlet servlet, 
            HttpServletRequest request, 
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    public Map<String, String> getErrors() {
        return errorMap;
    }
    
    public void clearErrors() {
        if (errorMap != null) {
            errorMap.clear();
        }
    } 
    
    public void setErrors(Object data) {
        Set<ConstraintViolation<Object>> violations = validator.validate(data); 
        
        errorMap.clear();
        if (! violations.isEmpty()) {
            for(ConstraintViolation<Object> msg : violations) {
                PathImpl value = (PathImpl) msg.getPropertyPath();
                errorMap.put((String) value.getLeafNode().getName(), 
                             msg.getMessage());
            }
        }
    }  
    
    public boolean isValid(Object data) {
        setErrors(data);
        return errorMap.isEmpty();
    }
   
    
}
