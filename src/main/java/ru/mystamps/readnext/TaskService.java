package ru.mystamps.readnext;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private final List<Task> tasks = new CopyOnWriteArrayList<>();
	private final AtomicLong taskCounter = new AtomicLong();
	
	{
		for (int i = 0; i < 5; i++) {
			long taskId = taskCounter.incrementAndGet();
			Task task = new Task(
				taskId,
				String.format("Task #%d", taskId),
				String.format("http://example.com/task-%d", taskId),
				Collections.singleton(String.format("tag-%d", i+1))
			);
			tasks.add(task);
		}
	}
	
	public List<Task> findAll() {
		return tasks;
	}
	
	public Task createTask(AddTask task) {
		Task newTask = new Task(
			taskCounter.incrementAndGet(),
			task.getTitle(),
			task.getUrl(),
			task.getTags()
		);
		tasks.add(newTask);
		return newTask;
	}
	
	public void completeTask(Long taskId) {
		tasks.remove(new Task(taskId, null, null, null));
	}

	public List<String> findAllTags() {
		return tasks.stream().map(Task::getTags).flatMap(Set::stream).collect(Collectors.toList());
	}
}
