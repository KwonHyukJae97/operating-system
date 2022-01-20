package com.operation.management.primary.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "remote_status")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class RemoteStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
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
      public RemoteStatus(Long key, String name, String email, 
                          String status, String server_ip,
                          String server_user, String reason,
                          String date, String start_time, 
                          String end_time, String create_ip, 
                          Date create_dttm, String update_admin, 
                          Date update_dttm, String phn_id, 
                          String alarm_type){
        this.key = key;
        this.name = name;
        this.email = email;
        this.status = status;
        this.server_ip = server_ip;
        this.server_user = server_user;
        this.reason = reason;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.create_ip = create_ip;
        this.create_dttm = create_dttm;
        this.update_admin = update_admin;
        this.update_dttm = update_dttm;
        this.phn_id = phn_id;
        this.alarm_type = alarm_type;

      }
    
}
