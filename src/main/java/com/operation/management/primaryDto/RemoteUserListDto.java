package com.operation.management.primaryDto;

import com.operation.management.primary.model.RemoteUserList;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RemoteUserListDto {
    private Long id;
    private String name;
    private String email;
    private String phn_id;
    private String used_yn;
    private String type;
    private String server_user;
    private String server_ip;

    @Builder
    public RemoteUserListDto(RemoteUserList userList){
        this.id = userList.getId();
        this.name = userList.getName();
        this.email = userList.getEmail();
        this.phn_id = userList.getPhn_id();
        this.used_yn = userList.getUsed_yn();
        this.type = userList.getType();
        this.server_user = userList.getServer_user();
        this.server_ip = userList.getServer_ip();
    }

    public RemoteUserList toEntity(){
        return RemoteUserList.builder().id(id).name(name)
                        .email(email).phn_id(phn_id)
                        .used_yn(used_yn).type(type)
                        .server_user(server_user)
                        .server_ip(server_ip)
                        .build();
    }
    
}
