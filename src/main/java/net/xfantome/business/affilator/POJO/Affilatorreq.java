package net.xfantome.business.affilator.POJO;
import lombok.Data;

import javax.persistence.Column;

@Data
public class Affilatorreq {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private long affiliate_code;
    private String country;
    private String city;
    private String bankingProfileId;
    private String password;
    private String verificationToken;

}
