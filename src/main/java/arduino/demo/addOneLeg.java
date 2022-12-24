/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arduino.demo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aehol
 */
@RestController
public class addOneLeg {
    @RequestMapping("/getAllLed")
    public ResponseEntity<?> addOneLeg() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/arduino";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");
    String query = "SELECT * FROM leg";
    Statement st = (Statement) conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    ArrayList list = new ArrayList();
    Map<String, Object> user;
    while (rs.next())
      {
        String name = rs.getString("name");
        Timestamp time = rs.getTimestamp("time");
        String newTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(time);
        Boolean status = rs.getBoolean("status");
        // print the results
        System.out.format("%s\n", name);
        user = new HashMap<>();
        user.put("name",name);
        user.put("status",status);
        user.put("time",newTime);
        list.add(user);
      }
    return ResponseEntity.ok(list);
    }
    @RequestMapping("/addOnLedOne")
    public ResponseEntity<?> addOnLedOne() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/arduino";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");
    String query = "INSERT INTO `leg`(`name`, `status`, `time`) VALUES ('LED 1',1,now())";
    Statement st = (Statement) conn.createStatement();
    boolean rs = st.execute(query);
    return ResponseEntity.ok("ok");
    }
    @RequestMapping("/addOffLedOne")
    public ResponseEntity<?> addOffLedOne() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/arduino";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");
    String query = "INSERT INTO `leg`(`name`, `status`, `time`) VALUES ('LED 1',0,now())";
    Statement st = (Statement) conn.createStatement();
    boolean rs = st.execute(query);
    return ResponseEntity.ok(" off ok");
    }
    @RequestMapping("/addOffLedTwo")
    public ResponseEntity<?> addOffLedTwo() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/arduino";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");
    String query = "INSERT INTO `leg`(`name`, `status`, `time`) VALUES ('LED 2',0,now())";
    Statement st = (Statement) conn.createStatement();
    boolean rs = st.execute(query);
    return ResponseEntity.ok(" off ok");
    }
    @RequestMapping("/addOnLedTwo")
    public ResponseEntity<?> addOnLedTwo() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/arduino";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");
    String query = "INSERT INTO `leg`(`name`, `status`, `time`) VALUES ('LED 2',1,now())";
    Statement st = (Statement) conn.createStatement();
    boolean rs = st.execute(query);
    return ResponseEntity.ok(" off ok");
    }
}
