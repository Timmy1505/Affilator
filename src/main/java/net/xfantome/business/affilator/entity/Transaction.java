package net.xfantome.business.affilator.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Transaction extends Common {

    @Column(nullable = false, columnDefinition = "varchar(255) default '20%'")
    private String percentage;
    private String status;
    @OneToMany(mappedBy = "transaction")
    private List<Project> projects;

}
