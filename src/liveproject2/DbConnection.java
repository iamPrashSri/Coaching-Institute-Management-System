/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liveproject2;
import java.sql.*;
/**
 *
 * @author Hp
 */
public class DbConnection {
    
     static oracle.jdbc.driver.OracleDriver od;
    static Connection conn;
    static PreparedStatement stmt,stmt1;
    
   public static int insert_student_enquiry(String enquiry_id,String fname,String mname,String lname,String mob,String email
            ,String subject,String pmob,String pemail,String college,String start_time,String end_time
           ,Date date_of_enquiry,String ref,String address)throws Exception
    {
        od=new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(od);
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
        
        stmt=conn.prepareStatement("insert into student_enquiry1 values(?,?,?,?,?,?,?)");
        stmt.setString(1,enquiry_id);
        stmt.setString(2,fname);
        stmt.setString(3,mname);
        stmt.setString(4,lname);
        stmt.setString(5,mob);
        stmt.setString(6,email);
        stmt.setString(7,subject); 
        int val=stmt.executeUpdate();
        
        stmt1=conn.prepareStatement("insert into student_enquiry2 values(?,?,?,?,?,?,?,?,?)");
        stmt1.setString(1,enquiry_id);
        stmt1.setString(2,pmob);
        stmt1.setString(3,pemail);
        stmt1.setString(4,college);
        stmt1.setString(5,start_time);
        stmt1.setString(6,end_time);
        stmt1.setDate(7,date_of_enquiry);
        stmt1.setString(8,ref);
        stmt1.setString(9,address);
     
        int val1=stmt1.executeUpdate();
        
        stmt.close();
        stmt1.close();
        return (val*val1);
    }
 public static ResultSet check_for_enquiry_id()throws Exception
 {
     od=new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(od);
     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
     
     stmt=conn.prepareStatement("select enquiry_id from student_enquiry1");
     ResultSet rs = stmt.executeQuery();
     
     stmt.close();
     rs.close();
     return rs;
 }
 public static ResultSet check_for_enquiry_id(String enquiry_id)throws Exception
 {
     od=new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(od);
     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
     
     stmt=conn.prepareStatement("select * from student_enquiry1 where enquiry_id=?");
     stmt.setString(1,enquiry_id);
     ResultSet rs = stmt.executeQuery();
     
     
     stmt.close();
     rs.close();
     return rs;
 }
 public static ResultSet check_for_enquiry_id2(String enquiry_id)throws Exception
 {
     od=new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(od);
     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
     
     stmt=conn.prepareStatement("select * from student_enquiry2 where enquiry_id=?");
     stmt.setString(1,enquiry_id);
     ResultSet rs = stmt.executeQuery();
     
     
     stmt.close();
     rs.close();
     return rs;
 }
 public static int insert_into_student_admission(String admission_id,String batch_id,String subject_id,String fname,String mname,String lname
                ,String mob,String email,String pmob,String pemail,String college,Date date_of_admission,String address)throws Exception
 {   od=new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(od);
     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");

     stmt=conn.prepareStatement("insert into student_admission1 values(?,?,?,?,?,?,?,?)");
     stmt.setString(1,admission_id);
     stmt.setString(2,batch_id);
     stmt.setString(3,subject_id);
     stmt.setString(4,fname);
     stmt.setString(5,mname);
     stmt.setString(6,lname);
     stmt.setString(7,mob);
     stmt.setString(8,email);
     int val1=stmt.executeUpdate();
     
     stmt1=conn.prepareStatement("insert into student_admission2 values(?,?,?,?,?,?)");
     stmt1.setString(1,admission_id);
     stmt1.setString(2,pmob);
     stmt1.setString(3,pemail);
     stmt1.setString(4,college);
     stmt1.setDate(5,date_of_admission);
     stmt1.setString(6,address);
     int val2=stmt1.executeUpdate();

     stmt.close();
     stmt1.close();
     return (val1*val2);
 }
 public static ResultSet check_for_admission_id()throws Exception
 {
    od=new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(od);
     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
     
     stmt=conn.prepareStatement("select admission_id from student_admission1");
     ResultSet rs = stmt.executeQuery();
     
//     stmt.close();
//     rs.close();  
     return rs;
 }
public static int insert_into_admin_login(String admin_id,String fname,String mname,String lname,String email,String username,String password)throws Exception 
  {
       od=new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(od);
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
        
        stmt=conn.prepareStatement("insert into adminlogin values(?,?,?,?,?,?,?)");
        stmt.setString(1,admin_id);
        stmt.setString(2,fname);
        stmt.setString(3,mname);
        stmt.setString(4,lname);
        stmt.setString(5,email);
        stmt.setString(6,username);
        stmt.setString(7,password); 
        int val=stmt.executeUpdate();
        
        stmt.close();
        return val;
  }

public static ResultSet check_for_adminlogin() throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select username,password from adminlogin");
    ResultSet rs=stmt.executeQuery();


    return rs;
  }
public static int insert_into_teacher_login(String teacher_id,String username,String password)throws Exception 
  {
       od=new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(od);
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
        
        stmt=conn.prepareStatement("insert into teacherlogin values(?,?,?)");
        stmt.setString(1,teacher_id);
        stmt.setString(2,username);
        stmt.setString(3,password); 
        int val=stmt.executeUpdate();
        
        stmt.close();
        return val;
  }
public static ResultSet check_for_teacherlogin() throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select username,password from teacherlogin");
    ResultSet rs=stmt.executeQuery();
    

    return rs;
  }
public static int insert_into_student_login(String student_id,String username,String password)throws Exception 
  {
       od=new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(od);
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
        
        stmt=conn.prepareStatement("insert into studentlogin values(?,?,?)");
        stmt.setString(1,student_id);
        stmt.setString(2,username);
        stmt.setString(3,password); 
        int val=stmt.executeUpdate();
        
        stmt.close();
        return val;
  }
public static ResultSet check_for_studentlogin() throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select username,password from studentlogin");
    ResultSet rs=stmt.executeQuery();
    

    return rs;
  }
public static int insert_into_teacher_all_info(String teacher_id,String fname,String mname,String lname,String email,String mob,String sub)throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("insert into teacher_all_info values(?,?,?,?,?,?,?)");
    stmt.setString(1,teacher_id);
    stmt.setString(2,fname);
    stmt.setString(3,mname);
    stmt.setString(4,lname);
    stmt.setString(5,email);
    stmt.setString(6,mob);
    stmt.setString(7,sub); 
    int val=stmt.executeUpdate();
        
    stmt.close();
    return val;
  }
public static ResultSet check_for_teacher_id(String teacher_id)throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select teacher_id from teacher_all_info");
    ResultSet rs=stmt.executeQuery();


    return rs;
  }
public static int insert_into_subjects(String subject_id,String name)throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("insert into subjects values(?,?)");
    stmt.setString(1,subject_id);
    stmt.setString(2,name);
    int val=stmt.executeUpdate();
    
    stmt.close();
    return val;
  }
public static ResultSet check_for_subject_id(String subject_id)throws Exception
{
  od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select * from subjects");
    ResultSet rs=stmt.executeQuery();
    

    return rs;  
}
public static ResultSet check_for_subject_id2(String name)throws Exception
{
  od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("select subject_id from subjects where name=?");
    stmt.setString(1,name);
    ResultSet rs=stmt.executeQuery();
    
    return rs;    
}
public static int insert_into_batches(String batch_id,String subject_id,String start_time,String end_time)throws Exception
  {
    od=new oracle.jdbc.driver.OracleDriver();
    DriverManager.registerDriver(od);
    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
    
    stmt=conn.prepareStatement("insert into batches values(?,?,?,?)");
    stmt.setString(1,batch_id);
    stmt.setString(2,subject_id);
    stmt.setString(3,start_time);
    stmt.setString(4,end_time);
    int val=stmt.executeUpdate();
    
    stmt.close();
    return val;
  }
public static ResultSet select_all_batch_ids()throws Exception
 {
  od=new oracle.jdbc.driver.OracleDriver();
  DriverManager.registerDriver(od);
  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
  
  stmt=conn.prepareStatement("select batch_id,start_time,end_time from batches order by subject_id");
  ResultSet rs = stmt.executeQuery();

  return rs;
 }
public static void delete_from_student_enquiry(String enquiry_id)throws Exception
 {
  od=new oracle.jdbc.driver.OracleDriver();
  DriverManager.registerDriver(od);
  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
  
  stmt=conn.prepareStatement("delete from student_enquiry2 where enquiry_id=?");
  stmt.setString(1,enquiry_id);
  stmt.executeUpdate();
  
  stmt1=conn.prepareStatement("delete from student_enquiry1 where enquiry_id=?");
  stmt1.setString(1,enquiry_id);
  stmt1.executeUpdate();
  
  stmt.close();
  stmt1.close();
 }
public static int insert_into_teachers_batches(String teacher_id,String batch_id,String subject,String start_time,String end_time)throws Exception
{
  od=new oracle.jdbc.driver.OracleDriver();
  DriverManager.registerDriver(od);
  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant"); 
  
  stmt=conn.prepareStatement("insert into teachers_batches values(?,?,?,?,?)");
  stmt.setString(1,teacher_id);
  stmt.setString(2,batch_id);
  stmt.setString(3,subject);
  stmt.setString(4,start_time);
  stmt.setString(5,end_time);
  int val=stmt.executeUpdate();

  stmt.close();
  return val;
}
public static ResultSet check_for_batch_id(String batch_id)throws Exception
{
  od=new oracle.jdbc.driver.OracleDriver();
  DriverManager.registerDriver(od);
  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");  
  
  stmt=conn.prepareStatement("select start_time,end_time from batches where batch_id=?");
  stmt.setString(1,batch_id);
  ResultSet rs = stmt.executeQuery();
  

  return rs;
}
}
