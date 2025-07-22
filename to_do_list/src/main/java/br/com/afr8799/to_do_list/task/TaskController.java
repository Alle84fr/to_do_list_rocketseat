package br.com.afr8799.to_do_list.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;
    
    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        System.out.println("Entrou no Controller ");
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
