package com.operation.management.tertiary.model;

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
@Table(name = "CMM_CDAUTH")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CmmCdauth {
    
    @Id
    @Column(name ="MBR_ID")
    private String mbrId;
    @Column(name ="AUTH_SEQ")
    private String authSeq;
    @Column(name ="MBR_IP")
    private String mbrIp;
    @Column(name ="MBR_PORT")
    private String mbrPort;
    @Column(name ="SPDPSEC")
    private int spdpsec;
    @Column(name ="MAX_LIMIT_RATE")
    private int maxLimitRate;
    @Column(name ="RMK")
    private String rmk;
    @Column(name ="DEL_YN")
    private String delYn;
    @Column(name ="REG_USR")
    private String regUsr;
    @Column(name ="REG_DTTM")
    private String regDttm;
    @Column(name ="UPT_USR")
    private String uptUsr;
    @Column(name ="UPT_DTTM")
    private String uptDttm;
    @Column(name ="MBR_LEVEL")
    private int mbrLevel;
    @Column(name = "SPAM_FG")
    private String spamFg;
    @Column(name = "MBR_IP2")
    private String mbrIp2;
    @Column(name = "CLIENT_VERSION")
    private String client_version;
    @Column(name = "OP_CHG_FG")
    private String opChgFg;
    @Column(name = "SMT_FG")
    private String smtFg;
    @Column(name = "ALARM_TYPE")
    private String alarmType;
    @Column(name = "PRIVATE_LINE_FG")
    private String privateLineFg;
    @Column(name = "CALLBLOCK_FG")
    private String callBlockFg;
    @Column(name = "BLOCK060_FG")
    private String block60Fg;
    @Column(name = "UPDATE_USER")
    private String updateUser;
    @Column(name = "UPDATE_DATE")
    private String updateDate;
    @Column(name = "AUTH_SECRET_DATA")
    private String authSecretData;
    @Column(name = "AUTH_CREDENTIAL_DATA")
    private String authCredentialData;

    @Builder
        public CmmCdauth(String mbrId,
        String authSeq,
        String mbrIp,
        String mbrPort,
        int spdpsec,
        int maxLimitRate,
        String rmk,
        String delYn,
        String regUsr,
        String regDttm,
        String uptUsr,
        String uptDttm,
        int mbrLevel,
        String spamFg,
        String mbrIp2,
        String client_version,
        String opChgFg,
        String smtFg,
        String alarmType,
        String privateLineFg,
        String callBlockFg,
        String block60Fg,
        String updateUser,
        String updateDate,
        String authSecretData,
        String authCredentialData){
            this.mbrId = mbrId;
            this.authSeq = authSeq;
            this.mbrIp = mbrIp;
            this.mbrPort = mbrPort;
            this.spdpsec = spdpsec;
            this.maxLimitRate = maxLimitRate;
            this.rmk = rmk;
            this.delYn = delYn;
            this.regUsr = regUsr;
            this.regDttm = regDttm;
            this.uptUsr = uptUsr;
            this.uptDttm = uptDttm;
            this.mbrLevel = mbrLevel;
            this.spamFg = spamFg;
            this.mbrIp2 = mbrIp2;
            this.client_version = client_version;
            this.opChgFg = opChgFg;
            this.smtFg = smtFg;
            this.alarmType = alarmType;
            this.privateLineFg = privateLineFg;
            this.callBlockFg = callBlockFg;
            this.block60Fg = block60Fg;
            this.updateUser = updateUser;
            this.updateDate = updateDate;
            this.authSecretData = authSecretData;
            this.authCredentialData = authCredentialData;
            
        }


}
