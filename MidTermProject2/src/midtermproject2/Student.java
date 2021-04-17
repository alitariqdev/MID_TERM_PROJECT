package midtermproject2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ali tariq
 */
public class Student extends Character {

    private String RegNo;
    private String Section;

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }
// ==================================VALIDATORS================================
// STUDENT NAME VALIDATOR

    public boolean validateStudentName(String name) {
        boolean flag = true;
        if (name.length() <= 40) {
            for (int i = 0; i < name.length(); i++) {
                if (!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) == ' '))) {
                    flag = false;
                }
            }
        } else {
            flag = false;
        }

        return flag;
    }

// REG.NO VALIDATOR
    public boolean validateRegistrationNumber(String regNo) {
        boolean flag = true;
        int size = regNo.length();

        if (size == 11) {
            if (!(regNo.charAt(0) == '2' && regNo.charAt(1) == '0' && regNo.charAt(2) >= '0' && regNo.charAt(2) <= '9' && regNo.charAt(3) >= '0' && regNo.charAt(3) <= '9' && regNo.charAt(4) == '-')) {
                flag = false;
            }

            if (!(regNo.charAt(5) >= 'A' && regNo.charAt(5) <= 'Z' && regNo.charAt(6) >= 'A' && regNo.charAt(6) <= 'Z') && regNo.charAt(7) == '-') {
                flag = false;
            }
            for (int i = 8; i < 11; i++) {
                if (!(regNo.charAt(i) >= '0' && regNo.charAt(i) <= '9')) {
                    flag = false;
                }
            }
        } else {
            flag = false;
        }

        return flag;

    }

// VALIDATE  STUDENT SECTION
    public boolean validateStudentSection(String section) {

        if (section.charAt(0) >= 'A' && section.charAt(0) <= 'Z') {
            return true;
        }
        return false;
    }

// VALIDATE STUDENT CONTACT NUMBER    
    public boolean validateStudentContactNumber(String contact) {
        boolean flag = true;

        if (contact.length() <= 11) {

            for (int i = 0; i < 11; i++) {
                if (contact.charAt(i) >= 0 && contact.charAt(i) <= 9) {
                    flag = true;
                }

            }

        } else {
            flag = false;
        }

        return flag;
    }

    public boolean validateAllData(String FirstName, String LastName, String RegNo, String Contact, String section) {

        boolean flag = true;

        if (validateStudentName(FirstName) && validateStudentName(LastName) && validateRegistrationNumber(RegNo) && validateStudentContactNumber(Contact) && validateStudentSection(section)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
// FILE HANDLLING===================================================================================

//    public boolean saveData(List<Student> list) {
//        boolean flag = false;
//        try {
//
//            FileWriter writefile = new FileWriter("Student.txt");
//
//            for (int i = 0; i < list.size(); i++) {
//
//                Student s = new Student();
//                s = list.get(i);
//
//                writefile.write(s.getFirstName() + "," + s.getLastName() + "," + s.getRegNo() + "," + s.getEmail() + "," + s.getSection() + "," + s.getPhoneNumber() + "\n");
//                flag = true;
//            }
//            writefile.close();
//
//        } catch (IOException ex) {
//            System.out.println("An error occured! File Not Found");
//            flag = false;
//        }
//
//        return flag;
//    }
//
//    public void loadData() {
//
////        ToolBooth tb = new ToolBooth();
//        Student s = new Student();
//        try {
//
//            FileReader readFile = new FileReader("Student.txt");
//            BufferedReader br = new BufferedReader(readFile);
//            Scanner sc = new Scanner(readFile);
//
//            String inFromFile = br.readLine();
//
//            String[] arr = inFromFile.split(",");
//
////            Car c3 = new Car();
//            s.setFirstName(arr[0]);
//            s.setLastName(arr[1]);
//            s.setRegNo(arr[2]);
//            s.setEmail(arr[3]);
//            s.setSection(arr[4]);
//            s.setPhoneNumber(arr[5]);
//            RubricSystem RS = RubricSystem.getInstance();
//            RS.getStdList().add(s);
//
//            br.close();
//            readFile.close();
//
//        } catch (IOException ex) {
//            System.out.println("An error occurred.");
//
//        }
//
//    }
}
