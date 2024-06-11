package com.Todolist.Todolist.Repository;

import com.Todolist.Todolist.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {

}
