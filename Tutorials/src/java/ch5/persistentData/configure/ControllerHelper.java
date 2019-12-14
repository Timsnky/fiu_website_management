/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5.persistentData.configure;

import ch5.persistentData.RequestDataPersistent;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HibernateHelper;

/**
 *
 * @author adel
 */
public class ControllerHelper extends ch5.persistentData.ControllerHelper{
    
    public ControllerHelper(HttpServlet servlet, 
            HttpServletRequest request, 
            HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    static public void initHibernate(HttpServlet servlet) {
        boolean create = 
	    Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create) {
            HibernateHelper.createTable(RequestDataPersistent.class);
        }
        HibernateHelper.initSessionFactory(RequestDataPersistent.class);
    }  
    
    @Override
    public void doGet()
            throws ServletException, java.io.IOException 
    {
        super.doGet();
    }

    @Override
    public void doPost()
            throws ServletException, java.io.IOException 
    {
        super.doPost();
    }
    
}
