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
@Table(name = "remote_server_list")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ServerList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String server_ip;
    private String server_user;
    private String status;
    private Date update_dttm;

    @Builder
      public ServerList(Long id, String server_ip,
                        String server_user, String status, 
                        Date update_dttm){
          this.id = id;
          this.server_ip = server_ip;
          this.server_user = server_user;
          this.status = status;
          this.update_dttm = update_dttm;
      }
    
}
