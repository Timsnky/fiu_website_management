/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author adel
 */
@MappedSuperclass
public class PersistentBase {
    
    protected Long id;
    
    @Id
    @GeneratedValue
    public Long getId() { return id; }

    private void setId(Long id) { this.id = id; }
    
    public PersistentBase() {
    }
}
