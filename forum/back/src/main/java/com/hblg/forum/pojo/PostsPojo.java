package com.hblg.forum.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class PostsPojo {
        @TableId(type = IdType.AUTO)
        Long id;
        String cover;
        String title;
        String author;
        String date;
        String description;
        String context;
        Long pid;
        Long visited;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCover() {
                return cover;
        }

        public void setCover(String cover) {
                this.cover = cover;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getContext() {
                return context;
        }

        public void setContext(String context) {
                this.context = context;
        }

        public Long getPid() {
                return pid;
        }

        public void setPid(Long pid) {
                this.pid = pid;
        }

        public Long getVisited() {
                return visited;
        }

        public void setVisited(Long visited) {
                this.visited = visited;
        }
}
