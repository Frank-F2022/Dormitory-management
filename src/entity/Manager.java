package entity;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Manager extends User{
    public Manager(int userID, String userName, String job, String password) {
        super(userID, userName, job, password);
    }

    public void studentManage(){
        int choice=-1;
        do {
            System.out.println("1.修改学生信息 2.删除学生 3.增加学生 0.返回");
            choice = getChoice(0, 3);
            switch (choice) {
                case 1 -> this.changeStudent();
                case 2 -> this.deleteStudent();
                case 3 -> this.addStudent();
            }
        }while (choice!=0);
    }


    public void addStudent(){
        System.out.println("input ID: ");
        int ID = getChoice(1, 999999);
        Student s = this.getSchool().findStudent_ID(ID);
        if(s!=null){
            System.out.println("Student ID already exist");
            return;
        }
        System.out.print("input name:");
        String new_name = input.next();
        System.out.print("input gender(1.male 2.female):");
        boolean newGender;
        if(getChoice(1, 2)==1)
            newGender=true;
        else
            newGender=false;
        System.out.print("input dept:");
        String new_dept = input.next();
        System.out.print("input major:");
        String new_major = input.next();
        System.out.print("input grade:");
        int new_grade = getChoice(2000,2050);
        System.out.print("input phone:");
        String new_phone = input.next();
        if(this.getSchool().addStudent(new Student(ID, new_name, newGender, new_dept, new_major, new_grade, new_phone)))
            System.out.println("added successfully");
        else{
            System.out.println("Student add failed");
        }

    }
    public void deleteStudent(){
        System.out.println("input ID: ");
        int ID = getChoice(1, 999999);
        Student s = this.getSchool().findStudent_ID(ID);
        if(s==null){
            System.out.println("Student not exist");
            return;
        }
        if(getYN()==false)
            return;
        if(this.getSchool().removeStudent(s)){
            System.out.println("Student removed successfully");
        }else{
            System.out.println("Student removed failed");
        }

    }
    public void changeStudent(){
        System.out.println("input ID: ");
        int ID = getChoice(1, 999999);
        Student s = this.getSchool().findStudent_ID(ID);
        if(s==null){
            System.out.println("Student not exist");
            return;
        }
        System.out.println("Student information: ");
        System.out.println(s);
        System.out.println("changing information:");
        System.out.print("input ID:");
        int newID = getChoice(1, 99999);
        Student ss = this.getSchool().findStudent_ID(ID);
        if(ss!=null){
            System.out.println("ID already used");
            return;
        }
        System.out.print("input name:");
        String new_name = input.next();
        System.out.print("input gender(1.male 2.female):");
        boolean newGender;
        if(getChoice(1, 2)==1)
            newGender=true;
        else
            newGender=false;
        System.out.print("input dept:");
        String new_dept = input.next();
        System.out.print("input major:");
        String new_major = input.next();
        System.out.print("input grade:");
        int new_grade = getChoice(2000,2050);
        System.out.print("input phone:");
        String new_phone = input.next();

        s.setID(newID);
        s.setName(new_name);
        s.setGender(newGender);
        s.setDept(new_dept);
        s.setMajor(new_major);
        s.setGrade(new_grade);
        s.setPhone(new_phone);
        System.out.println("changed successfully");
    }
    public void roomManage(){
        int choice=-1;
        do {
            System.out.println("1.修改宿舍信息 2.删除宿舍 3.增加宿舍 0.返回");
            choice = getChoice(0, 3);
            switch (choice) {
                case 1 -> this.changeRoom_information();
                case 2 -> this.deleteRoom();
                case 3 -> {
                    try {
                        this.addRoom();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }while (choice!=0);
    }

    public void addRoom() throws Exception {
        System.out.print("HouseID: ");
        int houseID = getChoice(1, 999999);
        System.out.print("RoomID: ");
        int roomID = getChoice(1, 999999);
        ArrayList result = this.getSchool().findStudent(houseID, roomID, -1);
        if(result==null){
            System.out.println("House not exist");
            return;
        } else if (result.size()==2) {
            System.out.println("Room already exist");
            return;
        }else if(result.size()==3){
            throw new Exception("error: bedID is -1");
        }
        if(this.getSchool().getHouse(houseID).addRoom(roomID))
            System.out.println("Room added successfully");
        else
            System.out.println("Room add failed");
    }

    public void deleteRoom(){
        System.out.print("HouseID: ");
        int houseID = getChoice(1, 999999);
        System.out.print("RoomID: ");
        int roomID = getChoice(1, 999999);
        ArrayList result = this.getSchool().findStudent(houseID, roomID, -1);
        if(result==null){
            System.out.println("Room not exist");
            return;
        }
        Room room = (Room)result.get(0);
        System.out.println("Confirm to delete Room "+ room.toString());
        if(getYN()==false)
            return;
        House house = (House)result.get(1);
        if(house.removeRoom(room))
            System.out.println("Room deleted");
        else
            System.out.println("Room delete failed");
    }


    public void changeRoom_information(){
        System.out.print("HouseID: ");
        int houseID = getChoice(1, 999999);
        System.out.print("RoomID: ");
        int roomID = getChoice(1, 999999);
        ArrayList result = this.getSchool().findStudent(houseID, roomID, -1);
        if(result==null){
            System.out.println("Room not exist");
            return;
        }
        Room room = (Room)result.get(0);
        System.out.print("new RoomID: ");
        int newID = getChoice(1, 9999);
        room.getRoomID();
        System.out.println("RoomID changed successfully");
    }
    public void houseManage(){
        int choice=-1;
        do {
            System.out.println("1.修改宿舍楼信息 2.删除宿舍楼 3.增加宿舍楼 0.返回");
            choice = getChoice(0, 3);
            switch (choice) {
                case 1 -> this.changeHouse();
                case 2 -> this.deleteHouse();
                case 3 -> this.addHouse();
            }
        }while (choice!=0);
    }

    public void addHouse(){
        System.out.print("houseID: ");
        int houseID = getChoice(1, 999999);
        House house = this.getSchool().getHouse(houseID);
        if(house!=null){
            System.out.println("HouseID already used");
            return;
        }
        System.out.print("houseName: ");
        String houseName = input.next();
        System.out.print("address: ");
        String address = input.next();
        System.out.print("floorNum: ");
        int floorNum = getChoice(1, 999);
        System.out.print("maxNum: ");
        int maxNum = getChoice(1, 999);
        System.out.print("roomNum: ");
        int roomNum = getChoice(1, 999);
        if(this.getSchool().addHouse(houseID, houseName, address, floorNum, maxNum, roomNum))
            System.out.println("House added successfully");
        else
            System.out.println("House add failed");

    }

    public void deleteHouse(){
        int houseID = getChoice(1, 999999);
        House house = this.getSchool().getHouse(houseID);
        if(house==null){
            System.out.println("House not exists");
            return;
        }
        System.out.println("confirm to delete House "+house.toString());
        if(getYN()==false)
            return;
        if(this.getSchool().removeHouse(house))
            System.out.println("House delete successfully");
        else {
            System.out.println("House delete failed");
        }
    }
    public void changeHouse(){
        System.out.print("HouseID: ");
        int houseID = getChoice(1, 999999);
        House house = this.getSchool().getHouse(houseID);
        if(house==null){
            System.out.println("House not exists");
            return;
        }
        System.out.print("new houseID:");
        int newHouseID = getChoice(1, 9999);
        if(this.getSchool().getHouse(newHouseID)!=null){
            System.out.println("new HouseID already used");
            return;
        }
        System.out.print("new houseName:");
        String new_name = input.next();
        System.out.print("new address:");
        String new_address = input.next();
        System.out.print("new floorNum:");
        int floor = getChoice(1, 9999);
        System.out.print("new maxNum:");
        int max = getChoice(1, 9999);
        System.out.print("new roomNum:");
        int roomNum = getChoice(1, 9999);
        house.setHouseID(newHouseID);
        house.setHouseName(new_name);
        house.setAddress(new_address);
        house.setFloorNum(floor);
        house.setRoomNum(roomNum);
        house.setMaxNum(max);
        System.out.println("House changed successfully");
    }

}
