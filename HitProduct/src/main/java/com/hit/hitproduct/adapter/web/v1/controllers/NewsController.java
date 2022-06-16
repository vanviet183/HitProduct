package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.NewsService;
import com.hit.hitproduct.domains.dtos.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("")
    public ResponseEntity<?> getNews() {
        return VsResponseUtil.ok(newsService.getNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(newsService.getNewsById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createNews(@RequestBody NewsDto newsDto) {
        return VsResponseUtil.ok(newsService.createNews(newsDto));
    }

    @PostMapping("/{id}/uploadImg")
    public ResponseEntity<?> uploadImg(@PathVariable("id") Long id, @RequestParam("imgNews") List<MultipartFile> multipartFiles) {
        return VsResponseUtil.ok(newsService.uploadImgNews(id, multipartFiles));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateNews(@PathVariable("id") Long id, @RequestBody NewsDto newsDto) {
        return VsResponseUtil.ok(newsService.updateNews(id, newsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(newsService.deleteNews(id));
    }

}
