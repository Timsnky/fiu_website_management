/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4.enhanced;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch3.defaultValidate.RequestDataDefault;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import shared.ButtonMethod;
import shared.HelperBaseCh4;

/**
 *
 * @author adel
 */
public class ControllerHelper extends HelperBaseCh4{
    
    protected RequestDataDefault data = new RequestDataDefault();
    
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
        return "/WEB-INF/classes/ch4/enhanced/" + address;
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
        return jspLocation("Confirm.jsp");
    }
    
    @ButtonMethod(buttonName = "processButton")
    public String processMethod() {
        return jspLocation("Process.jsp");
    }
}
