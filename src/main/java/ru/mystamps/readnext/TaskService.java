package ru.mystamps.readnext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private final List<Task> tasks = new CopyOnWriteArrayList<>();
	private final AtomicLong taskCounter = new AtomicLong();
	
	{
		for (int i = 0; i < 5; i++) {
			long taskId = taskCounter.incrementAndGet();
			Task task = new Task(taskId, String.format("Task #%d", taskId));
			tasks.add(task);
		}
	}
	
	public List<Task> findAll() {
		return tasks;
	}
	
}
