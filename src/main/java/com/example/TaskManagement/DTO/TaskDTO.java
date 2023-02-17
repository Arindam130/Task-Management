package com.example.TaskManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Task_Table")
public class TaskDTO {
    @Id
    Long taskId;
    String taskHolderName;
    String taskDate;
    String taskName;
    String taskStatus;
}
