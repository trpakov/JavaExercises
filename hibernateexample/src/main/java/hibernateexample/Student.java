package hibernateexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "students")
public class Student {
 
    @Id
    @Column(name = "id")
    private String id;
     
    @Column(name = "firstName")
    private String firstName;
     
    @Column(name= "lastName")
    private String lastName;
       
    @Column(name= "facNumber")
    private String facNumber;
     
    public Student() {
    }
 
    public Student(String id, String firstName, String lastName, String facNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facNumber = facNumber;
    }
     
//    public Student(String firstName, String lastName) {
//        this.title = title;
//        this.author = author;
//    }
     
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFacNumber() {
		return facNumber;
	}
    
    public void setFacNumber() {
		this.facNumber = facNumber;
	}
     
    @Override
    public String toString() {
        return "Student " + this.id + ": " + this.firstName + " " + this.lastName + " " + this.facNumber;
    }
     
}