package com.example.agrimarket;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class PracticeController {
	
	private List<Students> slist = new ArrayList<>();
	
	/*
		Create API: POST /greet
		Input:
		{
		  "name": "Ketcy"
		}
		Output:
		Hello Ketcy 💖
	*/
	@PostMapping("/greet")
	public String greetUser(@RequestBody User name) {
		return "Hello "+name.getName();
	}
	
	
	/*
	 	GET with RequestParam: GET /square?num=5
		Output:
		Square is 25
	*/
	@GetMapping("/square")
	public String squareOfNum(@RequestParam("n") int n) {
		return "The result is "+(n*n);
	}
	
	/*
	 	GET with PathVariable: GET /cube/3
		Output:
		Cube is 27
	*/
	@GetMapping("/cube/{num}")
	public String cubeOfNum(@PathVariable int num) {
		return "The result is "+(num*num*num);
	}
	
	/*
		Store Students:
		Create:
		POST /students
		GET /students
		Student JSON:
		{
		  "name": "Muthu",
		  "marks": 90
		}
	*/
	@PostMapping("/students")
	public String postStudents(@RequestBody Students s) {
		slist.add(s);
		return "Student created with name "+s.getName()+" and "+s.getMarks()+" Marks";
	}
	
	@GetMapping("/students/showStudents")
	public String getStudents() {
		return "Name: "+slist.get(0).getName()+"\nMarks: "+slist.get(0).getMarks();
	}
	
	/*
		GET /students/{name}
		Output: Muthu - 90
	*/
	@GetMapping("/students/{name}")
	public String findStudent(@PathVariable String name) {
		for(Students s:slist) {
			if(s.getName().equals(name)) {
				return s.getName()+" - "+s.getMarks();
			}
		}
		return "No student found";
	}
	
	/*
	 	GET /students?marks=90
		👉 Return only students with 90 marks
	*/
	@GetMapping("/students")
	public String findStu(@RequestParam("marks") int marks) {
		for(Students s:slist) {
			if(s.getMarks() == marks) {
				return s.getName()+" obtained "+s.getMarks()+" marks";
			}
		}
		return "No student found";
	}
	
	/*
	 	POST:
	 	json
		[
		  {
		    "name": "A",
		    "marks": 80
		  },
		  {
		    "name": "B",
		    "marks": 90
		  }
		]
	*/
	@PostMapping("/students/bulk")
	public List<Students> postMultiStu(@RequestBody List<Students> li){
		for(Students s:li) {
			slist.add(s);
		}
		return li;
	}
	
	/*
	 	DELETE /students/{name}
	*/
	@DeleteMapping("/students/{name}")
	public String deleteStu(@PathVariable String name) {
		boolean removed = slist.removeIf(s -> s.getName().equals(name));
		return removed==true? "Student deleted" : "Student Not found";
	}
	

	/*
	 	GET /hello
		GET /hello?name=Ketcy
		👉 If no name: Hello Guest
		👉 If name: Hello Ketcy
	*/
	@GetMapping("/greetings")
	public String sayHello(
	        @RequestParam(value = "name", required = false) String name) {

	    if (name == null) {
	        return "Hello Guest";
	    }

	    return "Hello " + name;
	}
	
	
	/*
	 	GET /calc?num1=10&num2=5
		Output: Sum = 15
	*/
	@GetMapping("/calc")
	public String calculate(
	        @RequestParam("num1") int num1,
	        @RequestParam("num2") int num2) {

	    int sum = num1 + num2;
	    return "Sum = " + sum;
	}
	
	
}

class User {
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Students{
	private String name;
	private int marks;
	public Students() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMarks() {
		return this.marks;
	}
}
