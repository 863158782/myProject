package com.hblg.forum.Controller;

import com.hblg.forum.Service.impl.PartitionServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
public class PartitionCpntroller {

    @Autowired
    PartitionServiceImpl partitionService;

    @GetMapping("/Partition")
    public Result getPartition(){
        Result result=new Result();
        result.setCode(200);
        result.setData(partitionService.getAllPartition());
        return result;
    }
}
