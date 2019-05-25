/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch3.defaultValidate;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adel
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException
    {
        RequestDataDefault requestData = new RequestDataDefault();
        requestData.setName(request.getParameter("name"));
        requestData.setAddress(request.getParameter("address"));
        request.getSession().setAttribute("userData", requestData);
        
        String address;
    
        if(request.getParameter("confirmButton") != null)
        {
            address = "/ch3/dataBean/Confirm.jsp";
        }
        else if(request.getParameter("processButton") != null)
        {
            address = "/ch3/dataBean/Process.jsp";
        }
        else
        {
            address = "/ch3/dataBean/Edit.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
}
