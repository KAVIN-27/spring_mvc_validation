package com.kavin.spring.mvc.model;

import com.kavin.spring.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class Customer {



    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "should be least 1 character length")
    private String lastName = "";

    @NotNull(message = "is required")
    @Range(min = 0,max = 10,message = "must be between 0 and 10")

    private Integer freePasses;

    @Pattern(regexp = "^[0-9]{6}",message = "invalid pinCode")
    private String pinCode;

    @CourseCode(value = "FC",message = "The course should start with FC")
    private String courseCode;

    public Customer(){

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
