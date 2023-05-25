package net.xfantome.business.affilator.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Affilate   extends Common {

    private String FullName;
    private String email;
    private String phone;
    private String address;
    @ManyToOne
    @JoinColumn(name = "affilator_id")
    private Affilator affilator;
    
    



	
    
    
    
    
}
