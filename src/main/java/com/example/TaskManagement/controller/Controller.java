package com.example.TaskManagement.controller;

import com.example.TaskManagement.DTO.TaskDTO;
import com.example.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class Controller {

    @Autowired
    TaskRepository repository;

    @PostMapping("/save")
    TaskDTO save(@RequestBody TaskDTO dto){
        repository.save(dto);
        return dto;
    }

    @GetMapping("/GetAllTasks")
    List<TaskDTO> getAllTasks(){
        List<TaskDTO> list= (List<TaskDTO>) repository.findAll();
        return list;
    }

    @GetMapping("/delete/{id}")
    TaskDTO deleteTask(@PathVariable("id") Long id){
        Optional<TaskDTO> dto=repository.findById(id);
        repository.deleteById(id);
        return dto.get();
    }

    @GetMapping("/change/{id}/{status}")
    TaskDTO changeTaskStatus(@PathVariable("status") String status,@PathVariable("id") Long id){
        TaskDTO dto=repository.findById(id).get();
        dto.setTaskStatus(status);
        repository.save(dto);
        return dto;
    }

    @GetMapping("/GetByTaskHolderName/{name}")
    List<TaskDTO> findByOwnerName(@PathVariable("name") String name){
        List<TaskDTO> dtoList=repository.findBytaskHolderName(name);
        return dtoList;
    }
}
