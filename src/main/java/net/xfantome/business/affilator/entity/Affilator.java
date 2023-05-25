package net.xfantome.business.affilator.entity;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Entity
@Data
@Table
public class Affilator  extends  Common {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private long affiliate_code;
    private String country;
    private String  city;
    private String password;
    private String verificationToken;
    @OneToMany(mappedBy = "affilator")
    @JsonIgnoreProperties("affilator")
    private List<Affilate> affilates;

    @ManyToOne
    @JoinColumn(name = "bankingProfile_id", referencedColumnName = "id")
    private BankingProfile bankingProfile;


}
