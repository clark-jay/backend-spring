package com.clark.backend.controller;

import com.clark.backend.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {
  @Autowired
  StatusService statusService;

  @PostMapping("/status")
  public String checkStatus(@RequestParam int id, @RequestParam String name){
    return statusService.checkStatus(id, name);
  }

}
