package com.clark.backend.services;

import com.clark.backend.model.StatusEntity;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

  public StatusEntity checkStatus(int id, String name){
    StatusEntity status = new StatusEntity();
    status.setId(id);
    status.setName(name);
    status.setStatus("service-status");
    return status;
  }
}
