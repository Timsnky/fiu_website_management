/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch3.defaultValidate;

/**
 *
 * @author adel
 */
public class RequestDataDefault {
    private String name;
    private String address;

    public String getName() {
        if(isValidName())
        {
            return name;
        }
        else
        {
            return "John Doe";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        if(isValidAddress())
        {
            return address;
        }
        else
        {
            return "Some Address";
        }
    }

    public void setAddress(String address) {
        this.address = address;
    } 
    
    public boolean isValidName() {
        return name != null && !name.trim().equals("");   
    }
    
    public boolean isValidAddress() {
        return address != null && !address.trim().equals("");   
    }
}
