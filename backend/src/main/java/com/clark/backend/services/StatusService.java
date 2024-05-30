package com.clark.backend.services;

import com.clark.backend.model.Status;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
  public String checkStatus(int id, String name){
    Status status = new Status();

    status.setId(id);
    status.setName(name);
    status.setStatus("service-status");
    return status.getStatus();
  }
}
