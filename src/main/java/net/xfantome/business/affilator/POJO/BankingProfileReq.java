package net.xfantome.business.affilator.POJO;


import lombok.Data;

import java.util.List;

@Data
public class BankingProfileReq {
    private String city;
    private String rib;
    private String bankName;
    private String  country;
    private List<Affilatorreq> Affilators;

}
