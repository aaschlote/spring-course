package com.springcourse.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageModel<T> {
	
	private static final long serialVersionUID = 1l;
	
	private int totalElements;
	private int pageSize;
	private int totalPages;
	private List<T> elements;

}
