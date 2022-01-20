package com.operation.management.secondary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "CMM_LIMIT_THRESHOLD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CmmThresHold {

    @Id
    @Column(name = "MBR_ID")
    private String mbrId;
    @Column(name = "MSG_TYPE")
    private String msgType;
    @Column(name = "GRP_CD")
    private String grpCd;
    @Column(name = "T_LIMIT_CNT")
    private int tCnt;
    @Column(name = "D_LIMIT_CNT")
    private int dCnt;
    @Column(name = "M_LIMIT_CNT")
    private int mCnt;
    @Column(name = "DEL_YN")
    private String delYn;
    @Column(name = "UPT_DTTM")
    private String upt;
    @Column(name = "ADT_ID")
    private String adtId;
    @Column(name = "A_LIMIT_CNT")
    private int aCnt;
    @Column(name = "A_RESET")
    private String aReset;
    @Column(name = "LIMIT_MODE")
    private String limitMode;

    @Builder
        public CmmThresHold(String mbrId, String msgType, String grpCd,
                            int tCnt, int dCnt, int mCnt,
                            String delYn, String upt, String adtId,
                            int aCnt, String aReset, String limitMode){
                                this.mbrId = mbrId;
                                this.msgType = msgType;
                                this.grpCd = grpCd;
                                this.tCnt = tCnt;
                                this.dCnt = dCnt;
                                this.mCnt = mCnt;
                                this.delYn = delYn;
                                this.upt = upt;
                                this.adtId = adtId;
                                this.aCnt = aCnt;
                                this.aReset = aReset;
                                this.limitMode = limitMode;
                            }

    
}
