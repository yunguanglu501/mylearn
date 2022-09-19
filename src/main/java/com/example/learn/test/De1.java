package com.example.learn.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * De1
 *
 * @author wcy
 * @date 2022/8/12
 */
@NoArgsConstructor
@Data
public class De1 {

    @JsonProperty("userIdFive")
    private String userIdFive;
    @JsonProperty("userIdOne")
    private String userIdOne;
    @JsonProperty("dos")
    private List<DosDTO> dos;

    @NoArgsConstructor
    @Data
    public static class DosDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("userNo")
        private String userNo;
        @JsonProperty("patientId")
        private String patientId;
        @JsonProperty("patientUserId")
        private String patientUserId;
        @JsonProperty("cardNo")
        private String cardNo;
        @JsonProperty("orgCode")
        private String orgCode;
    }
}
