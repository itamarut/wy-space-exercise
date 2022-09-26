package com.wy.spaceexercise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Getter
@Setter
@Accessors(chain = true)
public class Satellite {
	private String name;

	private Integer bandwidth;

	private LocalTime startTime;

	private LocalTime endTime;
}
