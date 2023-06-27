package entity;

import java.util.Date;

public class Student {
    private int ID;
    private String name;
    private boolean gender;


    private String dept;

    private String major;
    private int grade;
    private String phone;

    private int bedID=-1;
    private Date inDate;
    private Date outDate;

    public String toString() {
        String str = "ID: "+ ID+" name: "+ name+" gender: "+ gender+" dept: "+ dept+" major: "+ major
                +" grade: "+ grade+" phone: "+ phone+" bedID: "+ bedID+" inDate: "+ inDate+" outDate: "+outDate+'\n';
        return str;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Student(int ID, String name, boolean gender, String dept, String major, int grade, String phone, int bedID) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dept = dept;
        this.major = major;
        this.grade = grade;
        this.phone = phone;
        this.bedID = bedID;
//        this.inDate = inDate;
    }
    public Student(int ID, String name, boolean gender, String dept, String major, int grade, String phone) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dept = dept;
        this.major = major;
        this.grade = grade;
        this.phone = phone;
//        this.bedID = bedID;
//        this.inDate = inDate;
    }



}
