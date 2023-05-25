package net.xfantome.business.affilator.POJO;
import lombok.Data;

import java.util.List;

@Data
public class ClientReq {

    private String firstName;

    private String lastName;

    private String email;

    private ClientStatus status;

    private List<ProjectReq> projects;

}
