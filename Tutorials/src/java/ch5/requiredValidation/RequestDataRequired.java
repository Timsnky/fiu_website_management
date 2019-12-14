/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5.requiredValidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author adel
 */
public class RequestDataRequired {
    private String name;
    private String address;
    protected int daysPerWeek;

    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

    @Min(value=1, 
         message="must be greater than 1, if this is a hobby.")
    @Max(value=7, 
         message="cannot be greater than 7. A week only has 7 days.")
    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }
}
