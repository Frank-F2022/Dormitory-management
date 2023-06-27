package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    static Scanner input = new Scanner(System.in);
    private static School school = new School();

    private int userID;
    private String userName;
    private String job;
    private String password;

    public User(int userID, String userName, String job, String password) {
        this.userID = userID;
        this.userName = userName;
        this.job = job;
        this.password = password;
    }

    public void changeRoom(){

        System.out.print("input StudentID: ");
        int ID = getChoice(1, 999999);
        ArrayList result= school.findRoom(ID);
        Student s;
        Room room =null;
        if(result!=null){
            for(Object o : result)
                System.out.println(o);
            s = (Student) result.get(0);
            room = (Room) result.get(1);
        }
        else{
            s = school.findStudent_ID(ID);
            if(s==null){
                System.out.println("Student not exist");
                return;
            }
            System.out.println("Student has no Room");
        }

        System.out.print("input houseID: ");
        int houseID = getChoice(1, 999999);
        System.out.print("input roomID: ");
        int roomID = getChoice(1, 999999);
        System.out.print("input bedID: ");
        int bedID = getChoice(1, 999999);

        ArrayList rr = school.findStudent(houseID, roomID, bedID);
        if(result == null){
            System.out.println("new Room not exist");
            return;
        }
        if(rr.get(0) instanceof Student){
            System.out.println("Position already allocated");
            return;
        }

        if(room.removeStudent(s)){
                System.out.println("student removed");
        }else{
                System.out.println("remove student failed");
        }

        Room new_room = (Room) rr.get(0);
        if(new_room.addStudent(s)){
            System.out.println("student added");
        }
        else{
            System.out.println("student add failed");
        }
    }

    public void findRoom(){
        System.out.print("input StudentID: ");
        int ID = getChoice(1, 999999);
        ArrayList result= school.findRoom(ID);
        if(result == null){
            System.out.println("No Room found");
        }else{
            for (Object o : result)
                System.out.print(o.toString());
        }
    }


    public void findStudent(){
        System.out.print("input HouseID: ");
        int houseID = getChoice(1, 999999);
        System.out.print("input roomID: ");
        int roomID = getChoice(1, 999999);
        System.out.print("input bedID: ");
        int bedID = getChoice(1, 4);
        ArrayList s = school.findStudent(houseID, roomID, bedID);
        if(s == null){
            System.out.println("student not found");
        }else
            System.out.println(((Student)s.get(0)).toString());
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public static School getSchool() {
        return school;
    }

    public static void setSchool(School school) {
        User.school = school;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword() {
        int choice=-1;
        do {
            System.out.print("input old password:");
            String old = input.next();
            if(old.equals(this.password)){
                String newpwd = input.next();
                this.password = newpwd;
                System.out.println("password changed successfully");
            }
            else {
                System.out.println("password wrong");
                System.out.println("press 0 to try again, 1 to quit");
                choice = getChoice(0, 1);
            }
        }while(choice==0);
    }


    public static int getChoice(int min, int max) {
        int choice = -1;
        while (true) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                }
            }
            System.out.println("请输入正确数字");
            input.nextLine();
        }
        return choice;
    }

    public static boolean getYN() {
        while (true) {
            System.out.print(" （Y/N）：");
            String min = input.next();
            Character choice = min.charAt(0);
            if (choice.equals('Y') || choice.equals('y'))
                return true;
            else if (choice.equals('N') || choice.equals('n'))
                return false;
            System.out.println("wrong choice");
        }
    }
}
