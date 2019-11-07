package org.sun.bean;

import org.sun.test.annotations.Required;
import org.sun.test.annotations.Validations;

public class Employee 
{
	int id;
	String name;
	String lastName;
	Department dept;
	int rating;
	
	
	public Employee(int i) {
		
		this.id = i;
	}
	/**
	 * @return the id
	 */
	@Validations(required=@Required,name = "Serial Id",min = 1,max=1000)
	public int getId() {
		return id;
	}
	
	
	/**
	 * @return the name
	 */
	@Validations(required=@Required,name = "Employee's Name",minLength =1)
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	@Validations(required = @Required,name = "Employee's LastName",minLength =1)
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dept
	 */
	@Validations(isnull=false, required = @Required,name = "His Department")
	public Department getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	/**
	 * @return the rating
	 */
	@Validations(required = @Required,name = "Rating Scale",min=1,max=5)
	public int getRating() {
		return rating;
	}
	
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
