import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import  java.util.Scanner;

public class Main {
     static Scanner scanner = new Scanner(System.in);
    public static  void  main(String[] args){
       insertStudent();
       selectStudent();
       updateStudent();
       deleteStudent();
    }

    static void deleteStudent(){
        int rollNo =scanner.nextInt() ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where rollno='"+rollNo+"'");
            if (count>0){
                System.out.println("Student is deleted from database");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void updateStudent(){
          Student student = new Student();
          student.setRollno(scanner.nextInt());
          student.setName(scanner.next());
          student.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update student set name='"+student.getName()+"' ,email='"+student.getEmail()+"' where rollNo='"+student.getRollno()+"' ");
            selectStudent(student.getRollno());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
     static void selectStudent(){
        Student student = new Student();
        int rollNo= scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while (rs.next()){
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollno());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void selectStudent(int rollNo) {
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='" + rollNo + "'");
            while (rs.next()) {
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollno());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
     static void insertStudent(){
        Student student = new Student();
        student.setRollno(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('"+student.getRollno()+"','"+student.getName()+"','"+student.getEmail()+"')");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}