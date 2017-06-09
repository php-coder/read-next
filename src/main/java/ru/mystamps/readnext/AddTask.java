package ru.mystamps.readnext;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTask {
	private String title;
	private String url;
	private Set<String> tags = new HashSet<>();
}
