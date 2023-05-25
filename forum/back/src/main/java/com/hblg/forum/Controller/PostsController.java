package com.hblg.forum.Controller;

import com.hblg.forum.Entity.Posts;
import com.hblg.forum.Service.impl.PostsServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("api")
public class PostsController {
    @Autowired
    PostsServiceImpl postsService;

    @GetMapping("/getPosts/{pid}")
    public Result getAllPosts(@PathVariable Long pid){
        Result result=new Result();
        result.setCode(200);
        result.setData(postsService.getAllPosts(pid));
        return result;
    }

    @PostMapping("/Posts")
    public Result addPosts(@RequestBody Posts posts){
        postsService.addPosts(posts);
        return new Result(200);
    }

    @GetMapping("/findPost/{id}")
    public Result findPost(@PathVariable Long id){
        return new Result(postsService.findPostById(id));
    }

    @PostMapping("imageUpload")
    public Result imgUpload(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){
            try{
                String originalFilename = file.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + UUID.randomUUID().toString() + "." + extension;
                byte[] bytes = file.getBytes();
                Path path = Paths.get("D:/imgs/", newFilename);
                Files.write(path, bytes);
                return new Result(path);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        return new Result();
    }

    @PostMapping("/delPost")
    public Result delPost(@RequestBody Posts posts){
//        System.out.println(posts.getId());
        int flag=200;
        if(posts.getId()!=null) {
            try{
                postsService.delPostById(posts.getId());
            }
            catch (Exception e){
                flag=0;
            }
        }
        return new Result(flag);
    }
}
