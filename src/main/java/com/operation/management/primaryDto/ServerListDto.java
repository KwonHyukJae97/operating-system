package com.operation.management.primaryDto;

import java.util.Date;

import com.operation.management.primary.model.ServerList;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServerListDto {

    private Long id;
    private String server_ip;
    private String server_user;
    private String status;
    private Date update_dttm;

    @Builder
    public ServerListDto(ServerList serverList){
        this.id = serverList.getId();
        this.server_ip = serverList.getServer_ip();
        this.server_user = serverList.getServer_user();
        this.status = serverList.getStatus();
        this.update_dttm = serverList.getUpdate_dttm();
    }

    public ServerList toEntity(){
        return ServerList.builder().id(id)
                                  .server_ip(server_ip)
                                  .server_user(server_user)
                                  .status(status)
                                  .update_dttm(update_dttm)
                                  .build();
    }
    
}
