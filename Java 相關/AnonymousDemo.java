package com.example;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class AnonymousDemo {

	public static void main(String[] args) {
		
		Set<Student> students = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() > o2.getGrade())
					return 1;
				else if(o1.getGrade() == o2.getGrade())
					return 0;
				else
					return -1;
			}
			
		});
		
		students.add(new Student("Alex",80));
		students.add(new Student("Lily",90));
		students.add(new Student("Jack",70));
		students.add(new Student("Amy",60));
		
		for(Student student: students) {
			System.out.println(student);
		}

		/*
			Student [name=Amy, grade=60]
			Student [name=Jack, grade=70]
			Student [name=Alex, grade=80]
			Student [name=Lily, grade=90]
		 */
	}

}

class Student {
	
	String name;
	
	int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return grade == other.grade && Objects.equals(name, other.name);
	}
	
}