package com.app.tester;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Status;
import com.app.entities.Task;

import static com.app.utils.Validation.*;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Task> list = populatedList();
			boolean exit = false;
			int id;
			while (!exit) {
				System.out.println("1. Add New Task  \n2 .Display all Task \n3. Delete a task  \n4. Update task status "
						+ "\n5. Display all pending tasks  \n6. Display all pending tasks for today "
						+ "\n7. Display all tasks sorted by taskDate \n0. For Exit");
				System.out.println("Enter the choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						// taskName, description, taskDate
						System.out.println("Enter TaskName, Description, TaskDate");
						Task task = validateTask(sc.next(), sc.next(), sc.next(), list);
						list.add(task);
						System.out.println("Task added successfully");
						break;

					case 2:
						for (Task t : list) {
							System.out.println(t);
						}
						break;

					case 3:
						System.out.println("Enter the task id to delete the task");
						id = sc.nextInt();
						Iterator it = list.iterator();
						while (it.hasNext()) {
							Task task1 = (Task) it.next();
							if (id == task1.getTaskId()) {
								it.remove();
								System.out.println("Removed");
							}
//							else
//							{
//								System.out.println("Id is wrong");
//							}
						}
						break;

					case 4:
						System.out.println("Enter the task id to update the task status");
						id = sc.nextInt();
						for(Task t : list)
						{
							if(id == t.getTaskId())
							{
								t.setStatus(Status.COMPLETED);
								System.out.println("status updated");
							}
						}
						break;

					case 5:
						System.out.println("All pending tasks : ");
						for(Task t : list)
						{
							if(t.getStatus() == Status.PENDING) {
								System.out.println(t);
							}
						}
						break;

					case 6:

						break;

					case 7:
						Collections.sort(list, new Comparator<Task>() {
							@Override
							public int compare(Task o1, Task o2) {
								System.out.println("in anonymous class - compare");
								return o1.getTaskDate().compareTo(o2.getTaskDate());
							}
						});
						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
