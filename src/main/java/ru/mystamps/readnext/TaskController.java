package ru.mystamps.readnext;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping("/tasks")
	public List<String> listTasks() {
		return taskService.findAll();
	}
	
}
