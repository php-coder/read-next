package ru.mystamps.readnext;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> listTasks() {
		return taskService.findAll();
	}
	
	@PostMapping("/tasks")
	public Task listTasks(AddTask taskDto) {
		Task task = taskService.createTask(taskDto);
		
		return task;
	}
	
	@PutMapping("/tasks/{id}")
	public void completeTask(@PathVariable("id") Long taskId, HttpServletResponse response) throws IOException {
		if (taskId == null || taskId < 1) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		taskService.completeTask(taskId);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
}
