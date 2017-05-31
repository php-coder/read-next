package ru.mystamps.readnext;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Task {
	private final Long id;
	private final String title;
}
