package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.entities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {

    List<Image> getAll();

    Image getImageById(Long id);

    Image updateImage(Long id, MultipartFile multipartFile);

    TrueFalseResponse deleteImage(Long id);
}
