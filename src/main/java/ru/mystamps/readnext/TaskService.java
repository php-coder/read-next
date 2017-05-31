package ru.mystamps.readnext;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	public List<String> findAll() {
		return Arrays.asList("Task #1", "Task #2", "Task #3", "Task #4", "Task #5");
	}
	
}
