package com.clark.backend.services;

import com.clark.backend.model.StatusEntity;
import com.clark.backend.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
  @Autowired
  private StatusRepository statusRepository;

  public StatusEntity saveStatus(StatusEntity statusEntity) {
    return statusRepository.save(statusEntity);
  }

  public StatusEntity getStatusById(int id) {
    return statusRepository.findById((long)id).orElse(null);
  }

  public List<StatusEntity> getAllStatuses() {
    return statusRepository.findAll();
  }

  public void deleteStatus(int id) {
    statusRepository.deleteById((long)id);
  }
}
