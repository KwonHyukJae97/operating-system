package com.operation.management.secondaryDto;


import com.operation.management.secondary.model.CmmThresHold;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmmThresHoldDto {
    
    private String mbrId;
    private String msgType;
    private String grpCd;
    private int tCnt;
    private int dCnt;
    private int mCnt;
    private String delYn;
    private String upt;
    private String adtId;
    private int aCnt;
    private String aReset;
    private String limitMode;

    @Builder
    public CmmThresHoldDto(CmmThresHold cmmThresHold){
        this.mbrId = cmmThresHold.getMbrId();
        this.msgType = cmmThresHold.getMsgType();
        this.grpCd = cmmThresHold.getGrpCd();
        this.tCnt = cmmThresHold.getTCnt();
        this.dCnt = cmmThresHold.getDCnt();
        this.mCnt = cmmThresHold.getMCnt();
        this.delYn = cmmThresHold.getDelYn();
        this.upt = cmmThresHold.getUpt();
        this.adtId = cmmThresHold.getAdtId();
        this.aCnt = cmmThresHold.getACnt();
        this.aReset = cmmThresHold.getAReset();
        this.limitMode = cmmThresHold.getLimitMode();
    }

    public CmmThresHold toEntity(){
        return CmmThresHold.builder()
                            .mbrId(mbrId)
                            .msgType(msgType)
                            .grpCd(grpCd)
                            .tCnt(tCnt)
                            .dCnt(dCnt)
                            .mCnt(mCnt)
                            .delYn(delYn)
                            .upt(upt)
                            .adtId(adtId)
                            .aCnt(aCnt)
                            .aReset(aReset)
                            .limitMode(limitMode)
                            .build();
    }
}
