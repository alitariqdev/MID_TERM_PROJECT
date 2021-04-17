/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ali tariq
 */
public class RubricSystem {

    private static RubricSystem instance;

    private List<Student> stdList;
    private List<Course> CourseList;
    Student s;

    private RubricSystem() {
        stdList = new ArrayList<Student>();
        CourseList = new ArrayList<Course>();

    }

    public static RubricSystem getInstance() {

        if (instance == null) {

            instance = new RubricSystem();
        }
        return instance;
    }

    public List<Course> getCourseList() {
        return CourseList;
    }

    public void setCourseList(List<Course> CourseList) {
        this.CourseList = CourseList;
    }

    public void addStudent(Student s) {

        stdList.add(s);

    }

    public List<Student> getStdList() {
        return stdList;
    }

    public int searchStudent(String regNo) {
        int index = -1;
        for (int i = 0; i < stdList.size(); i++) {
            if (stdList.get(i).getRegNo().equals(regNo)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean deleteStudent(String regNo) {
        int index = searchStudent(regNo);

        if (index == -1) {
            return false;
        } else {
            stdList.remove(index);
            return true;
        }
    }

    public boolean updateStudent(String regNo, Student s) {
        int index = searchStudent(regNo);

        if (index == -1) {
            return false;
        } else {
            stdList.set(index, s);
            return true;
        }
    }

    public boolean saveData(List<Student> list) {
        boolean flag = false;
        try {

            FileWriter fr = new FileWriter("Student.txt");

            for (int i = 0; i < list.size(); i++) {

                Student s = new Student();
                s = list.get(i);

                fr.write(s.getFirstName() + "," + s.getLastName() + "," + s.getRegNo() + "," + s.getEmail() + "," + s.getSection() + "," + s.getPhoneNumber() + "\n");
                flag = true;
            }
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occured! File Not Found");
            flag = false;
        }

        return flag;
    }

    public void loadData() {
        //List<Student> list = new ArrayList<Student>();
        try {

            FileReader fr = new FileReader("Student.txt");
            BufferedReader br = new BufferedReader(fr);
            //   Scanner sc = new Scanner(readFile);

            String inputFromFile = br.readLine();
            for (int i = 0; inputFromFile != null; i++) {
                String[] arr = inputFromFile.split(",");

                Student s = new Student();
                s.setFirstName(arr[0]);
                s.setLastName(arr[1]);
                s.setRegNo(arr[2]);
                s.setEmail(arr[3]);
                s.setSection(arr[4]);
                s.setPhoneNumber(arr[5]);
                stdList.add(s);
                inputFromFile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");

        }

    }
//========================================COURSE FUNCTIONS========================

    public void addCourse(Course c) {

        CourseList.add(c);

    }

    public int searchCAourse(String courseId) {
        int index = -1;
        for (int i = 0; i < CourseList.size(); i++) {
            if (CourseList.get(i).getCourseId().equals(courseId)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean deleteCourse(String courseId) {
        int index = searchStudent(courseId);

        if (index == -1) {
            return false;
        } else {
            CourseList.remove(index);
            return true;
        }
    }

    public boolean updateCourse(String courseId, Course c) {
        int index = searchStudent(courseId);

        if (index == -1) {
            return false;
        } else {
            CourseList.set(index, c);
            return true;
        }
    }

}
