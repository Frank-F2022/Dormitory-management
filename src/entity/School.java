package entity;

import java.util.ArrayList;

public class School {

    private int houseNum;
    private int roomNum;
    private int studentNum;
    private static ArrayList<House> houses = new ArrayList<House>();
    private static ArrayList<Student> students_all = new ArrayList<Student>();
    public School(int houseNum, int roomNum, int studentNum) {
        this.houseNum = houseNum;
        this.roomNum = roomNum;
        this.studentNum = studentNum;
        init();
    }

    public School(){
        init();
    }

    public void init() {
        System.out.println("School loading");

        students_all.add(new Student(666, "peterson", true, "software","cs",2021, "12345678901", 3));
        students_all.add(new Student(999, "frank", true, "math","HAHA",2025, "67898761", 2));

        ArrayList<Student> students_1 = new ArrayList<Student>();
        ArrayList<Student> students_2 = new ArrayList<Student>();
        students_1.add(students_all.get(0));
        students_2.add(students_all.get(1));


        ArrayList<Room> rooms_1 = new ArrayList<Room>();
        rooms_1.add(new Room(611, 5, students_1));

        ArrayList<Room> rooms_2 = new ArrayList<Room>();
        rooms_2.add(new Room(101, 1, students_2));


        houses.add(new House(5, "五舍", "开发区校区",6,100, 100, rooms_1));
        houses.add(new House(1, "一舍", "主校区",4,1000, 10000, rooms_2));

        System.out.println("School loaded!");
    }


    public boolean addStudent(Student s){
        students_all.add(s);
        return true;
    }
    public boolean removeStudent(Student s){
        students_all.remove(students_all.indexOf(s));
        return true;
    }

    public Student findStudent_ID(int id) {
        for(Student student:students_all){
            if(student.getID() == id){
                return student;
            }
        }
        return null;
    }

    public ArrayList findStudent(int houseID, int roomID, int bedID){
        for(House house : houses){
            if(house.getHouseID()==houseID){
                ArrayList result = house.findStudent(roomID, bedID);
                if(result==null){
                    System.out.println("Room not found");
                    return null;
                }
                result.add(house);
                return result;
            }
        }
        System.out.println("House not found");
        return null;
    }
    public ArrayList findRoom(int ID){
        for (House house : houses){
            if (house.findRoom(ID)!=null)
                {
                ArrayList result = house.findRoom(ID);
                result.add(house);
                return result;
            }
        }
        return null;
    }

    public boolean addHouse(int houseID, String houseName, String address, int floorNum, int maxNum, int roomNum){
        houses.add(new House(houseID, houseName, address, floorNum, maxNum, roomNum));
        return true;
    }
    public House getHouse(int HouseID){
        for(House house :houses){
            if(house.getHouseID()==HouseID)
                return house;
        }
        return null;
    }

    public boolean removeHouse(House h){
        houses.remove(houses.indexOf(h));
        return true;
    }

    public int getHouseNum() {
        this.houseNum = houses.size();
        return houseNum;
    }

    public int getRoomNum() {
        int num = 0;
        for(House house:houses)
        {
            num+=house.getRoomNum();
        }
        return roomNum;
    }

    public int getStudentNum() {
        this.studentNum = students_all.size();
        return studentNum;
    }

    public static ArrayList<House> getHouses() {
        return houses;
    }

    public static ArrayList<Student> getStudents_all() {
        return students_all;
    }
}
