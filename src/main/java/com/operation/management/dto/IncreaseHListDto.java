package com.operation.management.dto;

import java.time.LocalDate;
import java.util.List;

import com.operation.management.domain.IncreaseH;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;


import lombok.Data;

@Data
public class IncreaseHListDto {

    private List<IncreaseH> list;
    private int page;
    private int pageSize;
    private long totalCount;

    private String grp_cd;
    private String status;
    private String start_date;
    private String limit_price;
    private float sms_price;
    private float lms_price;
    private float mms_price;
    private String rmk;
    private LocalDate create_dttm;

    public PageRequest toPage(){

        int page = 0;
        int pageSize = 10;

        if(this.page > 0){
            page = this.page -1;
        }
        if(this.pageSize > 0){
            pageSize = this.pageSize;
        }
        return PageRequest.of(page, pageSize, Sort.by(Direction.DESC, "uid"));
    }

    public Specification<IncreaseH> toSpecification(){
        Specification<IncreaseH> grp_cd = null;
        Specification<IncreaseH> status = null;

        if(this.grp_cd != null && !this.grp_cd.isEmpty()){
            grp_cd = Specification.where((root, query, builder) -> builder.like(root.<String> get("grp_cd"), "%" + this.grp_cd + "%"));

            
        }
        if (this.status != null && !this.status.isEmpty()) {
			status = Specification.where((root, query, builder) -> 
						builder.like(root.<String> get("status"), "%" + this.status + "%"));
		}
        return Specification.where(grp_cd).and(status);
    }

    
    
}
