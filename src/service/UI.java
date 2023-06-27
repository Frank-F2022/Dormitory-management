package service;

import entity.Manager;
import entity.User;

import java.util.Scanner;

public class UI {

    static Scanner input = new Scanner(System.in);
    static private Operation op = new Operation();


    public static void main(String[] args){
        Operation op = new Operation();
        UI h = new UI();
        User u = login();
        if(u==null) {
            System.out.println("System out");
            return;
        }
        while (true){
            System.out.print("\n1.根据宿舍查找学生 2.根据学生查找宿舍 3.调换宿舍 4.学生信息管理 5.宿舍楼管理 6.房间管理 7.退出\nplease input:");
            int choice = getChoice(1, 6);
            switch (choice) {
                case 1 -> u.findStudent();
                case 2 -> u.findRoom();
                case 3 -> u.changeRoom();
                case 4 -> {
                    if(u instanceof Manager) {
                        Manager m = (Manager) u;
                        m.studentManage();
                    }
                    else
                        System.out.println("permission denied");
                }
                case 5 -> {
                    if(u instanceof Manager){
                        Manager m = (Manager)u;
                        m.houseManage();
                    }
                    else
                        System.out.println("permission denied");
                }
                case 6 -> {
                    if(u instanceof Manager){
                        Manager m = (Manager)u;
                        m.roomManage();
                    }
                    else
                        System.out.println("permission denied");
                }
                case 7 -> {
                    System.out.println("System out");
                    return;}
            }
        }
    }
    
    public static User login(){
        int choice = -1;
        do {
            System.out.print("input userID: ");
            int userID = getChoice(1, 9999999);
            System.out.print("input password: ");
            String password = input.next();
            if (op.findUser(userID, password) != null) {
                System.out.println("login successfully");
                return op.findUser(userID, password);
            } else {
                System.out.println("login failed");
                System.out.println("press 0 to try again, 1 to quit");
                choice = getChoice(0, 1);
            }
        }while(choice==0);
        return null;
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

}

