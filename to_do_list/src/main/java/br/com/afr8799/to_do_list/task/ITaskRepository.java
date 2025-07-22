package br.com.afr8799.to_do_list.task;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID>{
    
    List<TaskModel> findByIdUser (UUID idUser);
}
