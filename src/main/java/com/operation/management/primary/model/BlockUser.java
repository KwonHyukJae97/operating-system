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
@Table(name = "remote_block_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BlockUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String server_ip;
    private String server_user;
    private Date create_dttm;

    @Builder
      public BlockUser(Long id, String server_ip, String server_user, Date create_dttm){
          this.id = id;
          this.server_ip = server_ip;
          this.server_user = server_user;
          this.create_dttm = create_dttm;
      }
    
    
}
