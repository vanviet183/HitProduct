package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.BannerService;
import com.hit.hitproduct.domains.dtos.BannerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/banners")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("")
    public ResponseEntity<?> getBanners() {
        return VsResponseUtil.ok(bannerService.getBanners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBanner(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(bannerService.getBannerById(id));
    }

    @PostMapping("")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> createBanner(@RequestBody BannerDto bannerDto) {
        return VsResponseUtil.ok(bannerService.createBanner(bannerDto));
    }

    @PostMapping("/{id}/uploadImg")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> uploadImg(@PathVariable("id") Long id, @RequestParam("imgBanner") MultipartFile multipartFile) {
        return VsResponseUtil.ok(bannerService.uploadImgBanner(id, multipartFile));
    }

    @PatchMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> updateBanner(@PathVariable("id") Long id, @RequestBody BannerDto bannerDto) {
        return VsResponseUtil.ok(bannerService.updateBanner(id, bannerDto));
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteBanner(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(bannerService.deleteBanner(id));
    }

}
