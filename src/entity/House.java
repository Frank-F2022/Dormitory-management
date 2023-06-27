package entity;

import java.util.ArrayList;

public class House {
    private int houseID;
    private String houseName;
    private String address;
    private int floorNum;
    private int maxNum;
    private int roomNum;

    private ArrayList<Room> rooms = new ArrayList<Room>();

    public House(int houseID, String houseName, String address, int floorNum, int maxNum, int roomNum) {
        this.houseID = houseID;
        this.houseName = houseName;
        this.address = address;
        this.floorNum = floorNum;
        this.maxNum = maxNum;
        this.roomNum = roomNum;
    }
public House(int houseID, String houseName, String address, int floorNum, int maxNum, int roomNum, ArrayList<Room> rooms) {
        this.houseID = houseID;
        this.houseName = houseName;
        this.address = address;
        this.floorNum = floorNum;
        this.maxNum = maxNum;
        this.roomNum = roomNum;
        this.rooms = rooms;
    }

    public ArrayList findStudent(int roomID, int bedID) {
        for (Room room : rooms){
            if(room.getRoomID() == roomID){
                ArrayList result = room.findStudent(bedID);
                result.add(room);
                return result;
            }
        }
        return null;
    }

    public ArrayList findRoom(int ID){
        for (Room room : rooms){
            if(room.findRoom(ID)!=null)
            {
                ArrayList result = room.findRoom(ID);
                result.add(room);
                return result;
            }
        }
        return null;
    }

    public String toString() {
        return "houseID: "+houseID+", houseName: "+houseName+", address:"+address+", floorNum:"+floorNum+", maxNum:"+maxNum+", roomNum:"+roomNum+"\n";
    }
    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getRoomNum() {
        this.roomNum = rooms.size();
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public boolean removeRoom(Room room) {
        rooms.remove(rooms.indexOf(room));
        return true;
    }
    public boolean addRoom(int RoomId) {
        rooms.add(new Room(RoomId, this.houseID));
        return true;
    }
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
