package net.xfantome.business.affilator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Project extends Common {
	private String summary;
	private String price;
	private LocalDateTime date;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String status;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "transaction_id", referencedColumnName = "id")
	@JsonIgnore
	private Transaction transaction;
}
