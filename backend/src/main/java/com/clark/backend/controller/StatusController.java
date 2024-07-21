package com.clark.backend.controller;

import com.clark.backend.model.StatusEntity;
import com.clark.backend.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StatusController {

  StatusService statusService;

  @PostMapping("/status")
  public String checkStatus(@RequestParam int id, @RequestParam String name){
    return "test";
  }

  @GetMapping("/getstatus")
  public StatusEntity get(){
    return statusService.checkStatus(1, "clark");
  }

  @GetMapping("/gettest")
  public String gettest(){
    return "Hello!";
  }

}
