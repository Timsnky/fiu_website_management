/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5.persistentData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import shared.ButtonMethod;
import shared.HelperBaseCh5;
import java.util.Properties;
import shared.HibernateHelper;

/**
 *
 * @author adel
 */
public class ControllerHelper extends HelperBaseCh5{
    
    protected RequestDataPersistent data = new RequestDataPersistent();
    
    public ControllerHelper(HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    public Object getData() {
        return data;
    }
    
    public void doGet() throws ServletException, IOException {
        addHelperToSession("helper", SessionData.IGNORE);
        
        String address = editMethod();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    public void doPost()
            throws ServletException, java.io.IOException {
        addHelperToSession("helper", SessionData.READ);
        
        String address = executeButtonMethod();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    protected String jspLocation(String address) {
        return "/WEB-INF/classes/ch5/persistentData/" + address;
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
    
    static public void initHibernate(HttpServlet servlet) {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "300");
        props.setProperty("hibernate.c3p0.max_statements",
                "50");
        props.setProperty("hibernate.c3p0.idle_test_period",
                "300");

        //The following properties must be updated with your information.
        //Replace the capitalized words with your database information.
        //The standard port for MySQL is 3306.
        props.setProperty("hibernate.connection.url",
                "jdbc:mysql://localhost:3306/mydb");
        props.setProperty("hibernate.connection.username",
                "homestead");
        props.setProperty("hibernate.connection.password",
                "secret");

        boolean create =
                Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create) {
            HibernateHelper.createTable(
                    props,
                    RequestDataPersistent.class);
        }

        HibernateHelper.initSessionFactory(
                props,
                RequestDataPersistent.class);
    }  
}
