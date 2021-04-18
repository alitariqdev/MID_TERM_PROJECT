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
    private List<Assesment> AssesmentList;
    private List<Rubrics> RubricsList;
    private List<CLOS> closList;

    public List<Assesment> getAssesmentList() {
        return AssesmentList;
    }

    public void setAssesmentList(List<Assesment> AssesmentList) {
        this.AssesmentList = AssesmentList;
    }
    Student s;

    private RubricSystem() {
        stdList = new ArrayList<Student>();
        CourseList = new ArrayList<Course>();
        AssesmentList = new ArrayList<Assesment>();
        RubricsList = new ArrayList<Rubrics>();
        closList = new ArrayList<CLOS>();
    }

    public List<CLOS> getClosList() {
        return closList;
    }

    public void setClosList(List<CLOS> closList) {
        this.closList = closList;
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
            ex.printStackTrace();
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
            ex.printStackTrace();
        }

    }
//========================================COURSE FUNCTIONS========================

    public void addCourse(Course c) {

        CourseList.add(c);

    }

    public int searchCourse(String courseId) {
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
        int index = searchCourse(courseId);

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

    public boolean saveCourseData(List<Course> list) {
        boolean flag = false;
        try {

            FileWriter fr = new FileWriter("Courses.txt");

            for (int i = 0; i < list.size(); i++) {

                Course s = new Course();
                s = list.get(i);

                fr.write(s.getCourseTitle() + "," + s.getCourseId() + "," + s.getCreditHours() + "," + s.getCourseType() + "\n");
                flag = true;
            }
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occured! File Not Found");
            ex.printStackTrace();
            flag = false;
        }

        return flag;
    }

    public void loadCourseData() {

        try {

            FileReader fr = new FileReader("Courses.txt");
            BufferedReader br = new BufferedReader(fr);
            //   Scanner sc = new Scanner(readFile);

            String inputFromFile = br.readLine();
            for (int i = 0; inputFromFile != null; i++) {
                String[] arr = inputFromFile.split(",");

                Course s = new Course();
                s.setCourseTitle(arr[0]);
                s.setCourseId(arr[1]);
                s.setCourseTitle(arr[2]);
                s.setCourseType(arr[3]);
                CourseList.add(s);
                inputFromFile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();

        }

    }
//=======================================Assesments Functions=============================================

    public void addAssesment(Assesment a) {

        AssesmentList.add(a);

    }

    public int searchAssesment(String AssesmentName) {
        int index = -1;
        for (int i = 0; i < AssesmentList.size(); i++) {
            if (AssesmentList.get(i).getName().equals(AssesmentName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean deleteAssesment(String AssesmentName) {
        int index = searchCourse(AssesmentName);

        if (index == -1) {
            return false;
        } else {
            AssesmentList.remove(index);
            return true;
        }
    }

    public boolean updateAssesment(String AssesmentName, Assesment a) {
        int index = searchAssesment(AssesmentName);

        if (index == -1) {
            return false;
        } else {
            AssesmentList.set(index, a);
            return true;
        }
    }
//    =============================Assesment File Handling======================

    public boolean saveAssesmentData(List<Assesment> list) {
        boolean flag = false;
        try {

            FileWriter fr = new FileWriter("Assesments.txt");

            for (int i = 0; i < list.size(); i++) {

                Assesment s = new Assesment();
                s = list.get(i);

                fr.write(s.getName() + "," + s.getMarks() + "," + s.getWeightage() + "," + s.getQuestions() + "\n");
                flag = true;
            }
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occured! File Not Found");
            ex.printStackTrace();
            flag = false;
        }

        return flag;
    }

    public void loadAssesmentData() {

        try {

            FileReader fr = new FileReader("Assesments.txt");
            BufferedReader br = new BufferedReader(fr);
            //   Scanner sc = new Scanner(readFile);

            String inputFromFile = br.readLine();
            for (int i = 0; inputFromFile != null; i++) {
                String[] arr = inputFromFile.split(",");

                Assesment s = new Assesment();
                s.setName(arr[0]);
                s.setMarks(Integer.parseInt(arr[1]));
                s.setWeightage(arr[2]);
                s.setQuestions(Integer.parseInt(arr[3]));
                AssesmentList.add(s);
                inputFromFile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();

        }

    }

//    =========================================Rubrics Functions==============================
    public void addRubric(Rubrics r) {

        RubricsList.add(r);

    }

    public int searchRubric(String RubricName) {
        int index = -1;
        for (int i = 0; i < RubricsList.size(); i++) {
            if (RubricsList.get(i).getRubricName().equals(RubricName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean deleteRubric(String RubricName) {
        int index = searchRubric(RubricName);

        if (index == -1) {
            return false;
        } else {
            RubricsList.remove(index);
            return true;
        }
    }

    public List<Rubrics> getRubricsList() {
        return RubricsList;
    }

    public void setRubricsList(List<Rubrics> RubricsList) {
        this.RubricsList = RubricsList;
    }

    public boolean updateRubric(String RubricName, Rubrics a) {
        int index = searchStudent(RubricName);

        if (index == -1) {
            return false;
        } else {
            RubricsList.set(index, a);
            return true;
        }
    }
//========================RUBRICS File Handling================================

    public boolean saveRubricsData(List<Rubrics> list) {
        boolean flag = false;
        try {

            FileWriter fr = new FileWriter("Rubrics.txt");

            for (int i = 0; i < list.size(); i++) {

                Rubrics r = new Rubrics();
                r = list.get(i);

                fr.write(r.getRubricName() + "," + r.getAssignedCLO() + "\n");
                flag = true;
            }
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occured! File Not Found");
            ex.printStackTrace();
            flag = false;
        }

        return flag;
    }

    public void loadRubricsData() {

        try {

            FileReader fr = new FileReader("Rubrics.txt");
            BufferedReader br = new BufferedReader(fr);
            //   Scanner sc = new Scanner(readFile);

            String inputFromFile = br.readLine();
            for (int i = 0; inputFromFile != null; i++) {
                String[] arr = inputFromFile.split(",");

                Rubrics mr = new Rubrics();
                mr.setRubricName(arr[0]);
                mr.setAssignedCLO(arr[1]);

                RubricsList.add(mr);
                inputFromFile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();

        }

    }
//========================================CLOS FUNCTIONS=========================

    public void addCLO(CLOS c) {

        closList.add(c);

    }

    public int searchCLO(String CLOTitle) {
        int index = -1;
        for (int i = 0; i < closList.size(); i++) {
            if (closList.get(i).getTitle().equals(CLOTitle)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean deleteCLO(String CLOTitle) {
        int index = searchRubric(CLOTitle);

        if (index == -1) {
            return false;
        } else {
            closList.remove(index);
            return true;
        }
    }

    public boolean updateCLO(String CLOTitle, CLOS a) {
        int index = searchStudent(CLOTitle);

        if (index == -1) {
            return false;
        } else {
            closList.set(index, a);
            return true;
        }
    }

//  =========================================CLOS LIST=========================
    public boolean saveCLOData(List<CLOS> list) {
        boolean flag = false;
        try {

            FileWriter fr = new FileWriter("CLOS.txt");

            for (int i = 0; i < list.size(); i++) {

                CLOS r = new CLOS();
                r = list.get(i);

                fr.write(r.getTitle() + "," + r.getDescription() + "\n");
                flag = true;
            }
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occured! File Not Found");
            ex.printStackTrace();
            flag = false;
        }

        return flag;
    }

    public void loadCLOSData() {

        try {

            FileReader fr = new FileReader("CLOS.txt");
            BufferedReader br = new BufferedReader(fr);
            //   Scanner sc = new Scanner(readFile);

            String inputFromFile = br.readLine();
            for (int i = 0; inputFromFile != null; i++) {
                String[] arr = inputFromFile.split(",");

                CLOS c = new CLOS();
                c.setTitle(arr[0]);
                c.setDescription(arr[1]);

                closList.add(c);
                inputFromFile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();

        }

    }

}
