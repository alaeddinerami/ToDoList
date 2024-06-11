package com.Todolist.Todolist.Service;

import com.Todolist.Todolist.Model.Task;
import com.Todolist.Todolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
        @Autowired
        private TaskRepository taskRepository;
        public List<Task> getAllTasks(){
            return taskRepository.findAll();
        }
        public Task getTaskById(int id){
            return taskRepository.findById(id).orElse(null);
        }
        public Task saveTask(Task task){
            taskRepository.save(task);
            return task;
        }
        public void deleteTaskById(int id ){
            taskRepository.deleteById(id);
        }

}
