package net.xfantome.business.affilator.POJO;
import lombok.Data;
import net.xfantome.business.affilator.entity.Project;
import java.time.LocalDateTime;

@Data
public class ProjectReq extends Project {


    private String summary;
    private String price;
    private LocalDateTime date;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String clientId;
    private String transactionId;



}
