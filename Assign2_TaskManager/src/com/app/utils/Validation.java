package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Task;

public class Validation 
{
	//String taskName, String description, LocalDate taskDate
	public static Task validateTask(String taskName, String description, String taskDate, List<Task>task)
	{
		LocalDate td = LocalDate.parse(taskDate);
		return new Task(taskName, description, td);
	}
	
	public static List<Task> populatedList()
	{
		Task t1 = new Task("Task1", "Description1", LocalDate.parse("2020-02-02"));
		Task t2 = new Task("Task2", "Description2", LocalDate.parse("2023-12-22"));
		Task t3 = new Task("Task3", "Description3", LocalDate.parse("2019-05-02"));
		Task t4 = new Task("Task4", "Description4", LocalDate.parse("2022-10-12"));
		Task t5 = new Task("Task5", "Description5", LocalDate.parse("2018-08-09"));
		Task t6 = new Task("Task6", "Description6", LocalDate.parse("2021-06-02"));
		Task[] task = {t1, t2, t3, t4, t5, t6};
		List<Task>list = new ArrayList<Task>();
		for(Task t : task)
			list.add(t);
		return list;
	}
}
