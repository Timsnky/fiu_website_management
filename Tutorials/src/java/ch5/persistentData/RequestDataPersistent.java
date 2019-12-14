/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5.persistentData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author adel
 */
@Entity
public class RequestDataPersistent {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String address;
    protected int daysPerWeek;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
