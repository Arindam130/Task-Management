package com.example.TaskManagement.repository;

import com.example.TaskManagement.DTO.TaskDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskDTO,Long> {
    List<TaskDTO> findBytaskHolderName(String name);
}
