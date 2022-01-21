package com.operation.management.tertiaryDto;

import com.operation.management.tertiary.model.CmmCdauth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmmCdauthDto {
    
    private String mbrId;
    private String authSeq;
    private String mbrIp;
    private String mbrPort;
    private int spdpsec;
    private int maxLimitRate;
    private String rmk;
    private String delYn;
    private String regUsr;
    private String regDttm;
    private String uptUsr;
    private String uptDttm;
    private int mbrLevel;
    private String spamFg;
    private String mbrIp2;
    private String client_version;
    private String opChgFg;
    private String smtFg;
    private String alarmType;
    private String privateLineFg;
    private String callBlockFg;
    private String block60Fg;
    private String updateUser;
    private String updateDate;
    private String authSecretData;
    private String authCredentialData;

    @Builder
    public CmmCdauthDto(CmmCdauth cmmCdauth){
            this.mbrId = cmmCdauth.getMbrId();
            this.authSeq = cmmCdauth.getAuthSeq();
            this.mbrIp = cmmCdauth.getMbrIp();
            this.mbrPort = cmmCdauth.getMbrPort();
            this.spdpsec = cmmCdauth.getSpdpsec();
            this.maxLimitRate = cmmCdauth.getMaxLimitRate();
            this.rmk = cmmCdauth.getRmk();
            this.delYn = cmmCdauth.getDelYn();
            this.regUsr = cmmCdauth.getRegUsr();
            this.regDttm = cmmCdauth.getRegDttm();
            this.uptUsr = cmmCdauth.getUptUsr();
            this.uptDttm = cmmCdauth.getUptDttm();
            this.mbrLevel = cmmCdauth.getMbrLevel();
            this.spamFg = cmmCdauth.getSpamFg();
            this.mbrIp2 = cmmCdauth.getMbrIp2();
            this.client_version = cmmCdauth.getClient_version();
            this.opChgFg = cmmCdauth.getOpChgFg();
            this.smtFg = cmmCdauth.getSmtFg();
            this.alarmType = cmmCdauth.getAlarmType();
            this.privateLineFg = cmmCdauth.getPrivateLineFg();
            this.callBlockFg = cmmCdauth.getCallBlockFg();
            this.block60Fg = cmmCdauth.getBlock60Fg();
            this.updateUser = cmmCdauth.getUpdateUser();
            this.updateDate = cmmCdauth.getUpdateDate();
            this.authSecretData = cmmCdauth.getAuthSecretData();
            this.authCredentialData = cmmCdauth.getAuthCredentialData();
    }

    public CmmCdauth toEntity(){
        return CmmCdauth.builder()
                        .mbrId(mbrId)
                        .authSeq(authSeq)
                        .mbrIp(mbrIp)
                        .mbrPort(mbrPort)
                        .spdpsec(spdpsec)
                        .maxLimitRate(maxLimitRate)
                        .rmk(rmk)
                        .delYn(delYn)
                        .regUsr(regUsr)
                        .regDttm(regDttm)
                        .uptUsr(uptUsr)
                        .uptDttm(uptDttm)
                        .mbrLevel(mbrLevel)
                        .spamFg(spamFg)
                        .mbrIp2(mbrIp2)
                        .client_version(client_version)
                        .opChgFg(opChgFg)
                        .smtFg(smtFg)
                        .alarmType(alarmType)
                        .privateLineFg(privateLineFg)
                        .callBlockFg(callBlockFg)
                        .block60Fg(block60Fg)
                        .updateUser(updateUser)
                        .updateDate(updateDate)
                        .authSecretData(authSecretData)
                        .authCredentialData(authCredentialData)
                        .build();
    }
}
