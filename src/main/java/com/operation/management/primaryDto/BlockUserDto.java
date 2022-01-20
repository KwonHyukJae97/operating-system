package com.operation.management.primaryDto;

import java.util.Date;

import com.operation.management.primary.model.BlockUser;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlockUserDto {
    private Long id;
    private String server_ip;
    private String server_user;
    private Date create_dttm;

    @Builder
    public BlockUserDto(BlockUser blockUser){
        this.id = blockUser.getId();
        this.server_ip = blockUser.getServer_ip();
        this.server_user = blockUser.getServer_user();
        this.create_dttm = blockUser.getCreate_dttm();
    }

    public BlockUser toEntity(){
        return BlockUser.builder().id(id)
                                  .server_ip(server_ip)
                                  .server_user(server_user)
                                  .create_dttm(create_dttm)
                                  .build();
    }
    
}
