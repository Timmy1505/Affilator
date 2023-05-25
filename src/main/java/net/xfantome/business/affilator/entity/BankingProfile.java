package net.xfantome.business.affilator.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table
public class BankingProfile  extends  Common {

    private String city;
    private String rib;
    private String bankName;
    private String  country;
    @OneToMany(mappedBy = "bankingProfile")
    @JsonIgnoreProperties("bankingProfile")
    private List<Affilator> Affilators;

}
