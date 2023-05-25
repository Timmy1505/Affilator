package net.xfantome.business.affilator.POJO;


import lombok.Data;

@Data
public class ClientAndProjectReq {


    private ClientReq clientReq;
    private ProjectReq projectReq;

    public String getFirstName() {
        return clientReq.getFirstName();
    }

    public String getLastName() {
        return clientReq.getLastName();
    }

    public String getEmail() {
        return clientReq.getEmail();
    }

    public ClientStatus getStatus() {
        return clientReq.getStatus();
    }

    public ProjectReq getProject() {
        return projectReq;
    }
}

