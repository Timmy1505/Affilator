package net.xfantome.business.affilator.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import  java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.xfantome.business.affilator.POJO.ClientStatus;

@Entity
@Data
@Table
public class Client extends Common{
	private String firstName;
	private String lastName;
	private String email;
	@Enumerated(EnumType.STRING)
	private ClientStatus status;
	@OneToMany(mappedBy = "client")
	@JsonIgnoreProperties("client")
	private List<Project> projects;


}
