package com.hblg.forum.Service.impl;

import com.hblg.forum.Entity.Partition;
import com.hblg.forum.Mapper.PartitionMapper;
import com.hblg.forum.Service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartitionServiceImpl implements PartitionService {

    @Autowired
    PartitionMapper partitionMapper;

    @Override
    public List<Partition> getAllPartition() {
        return partitionMapper.selectList(null);
    }
}
