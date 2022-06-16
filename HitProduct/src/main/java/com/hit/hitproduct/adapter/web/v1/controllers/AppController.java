package com.hit.hitproduct.adapter.web.v1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class AppController {
  @GetMapping("/")
  public String app() {
    return "index";
  }

  @GetMapping("/author")
  public String getAuthor() {
    return "Product Hit - Hãy để chúng tôi cùng góp phần trên con đường của bạn :v";
  }

}
