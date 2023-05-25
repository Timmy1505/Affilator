package net.xfantome.business.affilator.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private String id;
    private String token;

}
