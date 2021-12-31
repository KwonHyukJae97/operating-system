package com.operation.management.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.operation.management.vo.IncreaseHistoryVO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "limit_count_history")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IncreaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long     uid;

    @Column(name = "grp_cd")
    private String grpCd;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "limit_price")
    private String limitPrice;

    @Column(name = "sms_price")
    private int    smsPrice;

    @Column(name = "lms_price")
    private int    lmsPrice;

    @Column(name = "mms_price")
    private int    mmsPrice;

    @Column(name = "rmk")
    private String rmk;

    @Column(name = "create_dttm")
    private LocalDateTime createDttm;

    
    @Builder
    public void IncreaseHistoryVO(Long uid, String grpCd, String status, String startDate, String limitPrice, int smsPrice, int lmsPrice, int mmsPrice, String rmk, LocalDateTime createDttm){

        this.uid = uid;
        this.grpCd = grpCd;
        this.status = status;
        this.startDate = startDate;
        this.limitPrice = limitPrice;
        this.smsPrice = smsPrice;
        this.lmsPrice = lmsPrice;
        this.mmsPrice = mmsPrice;
        this.rmk = rmk;
        this.createDttm = createDttm;

    }

}
