package com.operation.management.service;

import java.util.List;

import com.operation.management.IncreaseHistory.IncreaseH;
import com.operation.management.IncreaseHistory.IncreaseHRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("increaseHService")
public class IncreaseHService implements IncreaseHServiceImpl{
    @Autowired
    private IncreaseHRepository increaseHRepository;

    @Override
    public List<IncreaseH> getIncreaseHList() throws Exception{
        return (List<IncreaseH>)increaseHRepository.findAll();
    }    
}
