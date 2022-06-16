package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.NewsDto;
import com.hit.hitproduct.domains.entities.Image;
import com.hit.hitproduct.domains.entities.News;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface NewsService {

    List<News> getNews();

    News getNewsById(Long id);

    List<Image> uploadImgNews(Long id, List<MultipartFile> multipartFiles);

    News createNews(NewsDto newsDto);

    News updateNews(Long id, NewsDto newsDto);

    TrueFalseResponse deleteNews(Long id);

}
