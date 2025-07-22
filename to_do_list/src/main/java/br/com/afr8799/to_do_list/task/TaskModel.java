package br.com.afr8799.to_do_list.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name ="tb_tasks")
public class TaskModel {
    
    @Id
    @GeneratedValue(generator = "UUId")
    private UUID id;
    private UUID idUser;
    
    @Column(length = 50)
    private String title;
    private String decription;
    private LocalDateTime startAt;
    private LocalDateTime EndAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createAt;
    

}
