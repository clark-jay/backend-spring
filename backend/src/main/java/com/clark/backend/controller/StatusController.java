package com.clark.backend.controller;

import com.clark.backend.model.StatusEntity;
import com.clark.backend.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {
  @Autowired
  StatusService statusService;

  @PostMapping("/register")
  public StatusEntity createStatus(@RequestBody StatusEntity statusEntity) {
    System.out.println("Recieved name: "+ statusEntity.getName());
    System.out.println("Recieved name: "+ statusEntity.getStatus());
    return statusService.saveStatus(statusEntity);
  }

  @GetMapping("/get/{id}")
  public StatusEntity getStatusById(@PathVariable int id) {
    return statusService.getStatusById(id);
  }

  @GetMapping("/getall")
  public List<StatusEntity> getAllStatuses() {
    return statusService.getAllStatuses();
  }

  @DeleteMapping("/delete/{id}")
  public void deleteStatus(@PathVariable int id) {
    statusService.deleteStatus(id);
  }

}
