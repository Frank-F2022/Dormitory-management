package entity;

import java.util.ArrayList;

public class Room {
    private int roomID;
    private int houseID;

    private ArrayList<Student> students = new ArrayList<Student>();

    public Room(int roomID, int houseID, ArrayList<Student> students) {
        this.roomID = roomID;
        this.houseID = houseID;
        this.students = students;
    }

    public Room(int roomID, int houseID) {
        this.roomID = roomID;
        this.houseID = houseID;
    }



    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student){
        students.remove(students.indexOf(student));
        return true;
    }


    public String toString() {
        return "RoomID: "+roomID+", houseID: "+houseID+", studentsNum:"+students.size()+"\n";
    }
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList findStudent(int bedID){
        ArrayList result = new ArrayList();
        for (Student student:students){
            if(student.getBedID()==bedID)
            {
                result.add(student);
                return result;
            }
        }
        return result;
    }

    public ArrayList findRoom(int ID){
        for (Student student:students){
            if(student.getID()==ID)
            {
                ArrayList result = new ArrayList();
                result.add(student);
                return result;
            }
        }
        return null;
    }

}
