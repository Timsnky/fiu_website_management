/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch3.reorganised;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch3.defaultValidate.RequestDataDefault;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author adel
 */
public class ControllerHelper extends HelperBase{
    
    protected RequestDataDefault data = new RequestDataDefault();
    
    public ControllerHelper(HttpServlet servlet, 
            HttpServletRequest request, 
            HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    public Object getData()
    {
        return data;
    }
    
    public void doGet() throws ServletException, IOException
    {
        request.getSession().setAttribute("helper", this);
        
        data.setName(request.getParameter("name"));
        data.setAddress(request.getParameter("address"));
        
        String address;
    
        if(request.getParameter("confirmButton") != null)
        {
            address = "Confirm.jsp";
        }
        else if(request.getParameter("processButton") != null)
        {
            address = "Process.jsp";
        }
        else
        {
            address = "Edit.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
