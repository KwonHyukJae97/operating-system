package com.operation.management.primaryDto;

import java.util.Date;

import com.operation.management.primary.model.RemoteStatus;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RemoteStatusDto {

    private Long key;
    private String name;
    private String email;
    private String status;
    private String server_ip;
    private String server_user;
    private String reason;
    private String date;
    private String start_time;
    private String end_time;
    private String create_ip;
    private Date create_dttm;
    private String update_admin;
    private Date update_dttm;
    private String phn_id;
    private String alarm_type;

    @Builder
    public RemoteStatusDto(RemoteStatus remoteStatus){
        this.key = remoteStatus.getKey();
        this.name = remoteStatus.getName();
        this.email = remoteStatus.getEmail();
        this.status = remoteStatus.getStatus();
        this.server_ip = remoteStatus.getServer_ip();
        this.server_user = remoteStatus.getServer_user();
        this.reason = remoteStatus.getReason();
        this.date = remoteStatus.getDate();
        this.start_time = remoteStatus.getStart_time();
        this.end_time = remoteStatus.getEnd_time();
        this.create_ip = remoteStatus.getCreate_ip();
        this.create_dttm = remoteStatus.getCreate_dttm();
        this.update_admin = remoteStatus.getUpdate_admin();
        this.update_dttm = remoteStatus.getUpdate_dttm();
        this.phn_id = remoteStatus.getPhn_id();
        this.alarm_type = remoteStatus.getAlarm_type();
    }

    public RemoteStatus toEntity(){
        return RemoteStatus.builder().key(key)
                           .name(name)
                           .email(email)
                           .status(status)
                           .server_ip(server_ip)
                           .server_user(server_user)
                           .reason(reason)
                           .date(date)
                           .start_time(start_time)
                           .end_time(end_time)
                           .create_ip(create_ip)
                           .create_dttm(create_dttm)
                           .update_admin(update_admin)
                           .update_dttm(update_dttm)
                           .phn_id(phn_id)
                           .alarm_type(alarm_type)
                           .build();
    }
    
}
