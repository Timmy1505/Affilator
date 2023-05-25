package net.xfantome.business.affilator.POJO;

import lombok.Data;
import java.util.List;


@Data
public class TransactionReq {

    private String percentage;
   private String status;
    private List<ProjectReq> projects;


}
