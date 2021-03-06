package ru.mystamps.readnext;

import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Task {
	private final Long id;
	private final String title;
	private final String url;
	private final Set<String> tags;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (! (obj instanceof Task)) {
			return false;
		}
		Task task = (Task)obj;
		return Objects.equals(this.id, task.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}
}
