package com.operation.management.primary.model;

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
@Table(name = "remote_user_list")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class RemoteUserList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String name;
    private String email;
    private String phn_id;
    private String used_yn;
    private String type;
    private String server_user;
    private String server_ip;

    @Builder
      public RemoteUserList(Long id, String name, String email, 
                      String phn_id, String used_yn, 
                      String type, String server_user, 
                      String server_ip){
          this.id = id;
          this.name = name;
          this.email = email;
          this.phn_id = phn_id;
          this.used_yn = used_yn;
          this.type = type;
          this.server_user = server_user;
          this.server_ip = server_ip;
      }
    
}
