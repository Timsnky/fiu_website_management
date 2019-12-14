/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5.requiredValidation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import shared.ButtonMethod;
import shared.HelperBaseCh5;
import shared.HibernateHelper;

/**
 *
 * @author adel
 */
public class ControllerHelper extends HelperBaseCh5{
    
    protected RequestDataRequired data = new RequestDataRequired();
    
    public ControllerHelper(HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    public Object getData() {
        return data;
    }
    
    public void doGet() throws ServletException, IOException {
        addHelperToSession("helper", SessionData.READ);
        
        String address = executeButtonMethod();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    protected String jspLocation(String address) {
        return "/WEB-INF/classes/ch5/requiredValidation/" + address;
    }
    
    @Override
    protected void copyFromSession(Object sessionHelperObject) {
        
        if (sessionHelperObject.getClass() == this.getClass()) {
            data = ((ControllerHelper) sessionHelperObject).data;
        }
    }
    
    @ButtonMethod(buttonName = "editButton", isDefault = true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }
    
    @ButtonMethod(buttonName = "confirmButton")
    public String confirmMethod() {
        fillBeanFromRequest(data);
        
        String address;

        if (isValid(data)) {
            address = jspLocation("Confirm.jsp");
        } else {
            address = jspLocation("Edit.jsp");
        }
            
        return address;
    }
    
    @ButtonMethod(buttonName = "processButton")
    public String processMethod() {
        if (!isValid(data)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(data);
        java.util.List list =
                HibernateHelper.getListData(data.getClass());
        request.setAttribute("database", list);
        return jspLocation("Process.jsp");
    }
}
