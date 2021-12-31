package com.operation.management.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncreaseHistoryVO {

    private Long     uid;

    private String grpCd;

    private String status;

    private String startDate;

    private String limitPrice;

    private int    smsPrice;

    private int    lmsPrice;

    private int    mmsPrice;

    private String rmk;

    private LocalDateTime createDttm; 
    
}
