package sample;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.UUID;

public class Controller implements Initializable
{
    final String hostname = "java-db.cfxojoqiy3uc.us-east-1.rds.amazonaws.com";
    final String dbname = "syedDB";
    final String port = "3306";
    final String username = "syed3368";
    final String password = "syedcis3368";

    final String AWS_URL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?user=" + username + "&password=" + password;

    @FXML
    private JFXButton createDB;

    @FXML
    private JFXButton populate;

    @FXML
    private JFXButton delete;


    @FXML
    private JFXButton filter;

    @FXML
    private JFXButton female;

    @FXML
    private JFXButton bloodtype;

    @FXML
    private JFXListView <String> list;

    @FXML
    ObservableList<String> listItem;

    @FXML
    private JFXListView <String> list2;

    @FXML
    ObservableList<String> listItem2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       //GeneratePatients(10);

        listItem = list.getItems();
        listItem2 = list2.getItems();

        createDB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreateDB();
                //GeneratePatients();
                GeneratePatients(0);
            }
        });


        populate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                populatePatient();
                //GeneratePatients(10);
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                try
                {
                    Connection conn = DriverManager.getConnection(AWS_URL);
                    Statement stmt = conn.createStatement();
                    System.out.println("CONNECTION ESTABLISHED");

                    String sql = "DROP TABLE patient1 ";
                    stmt.executeUpdate(sql);
                    System.out.println("Table patient DELETED");


                }
                catch (Exception ex)
                {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }
        });


        filter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filterPatient();

            }
        });

        female.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filterPatient1();

            }
        });

        bloodtype.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filterPatient2();

            }
        });

    }

    private void CreateDB()
    {
        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");

            //ADDING PATIENTS
            System.out.println("ADDING patients TO TABLE");



            patient g1 = new patient();
            patient g2 = new patient();

            patient n1 = new patient();
            patient n2 = new patient();
            patient n3 = new patient();
            patient n4 = new patient();
            patient n5 = new patient();
            patient n6 = new patient();
            patient n7 = new patient();
            patient n8 = new patient();
            patient n9 = new patient();
            patient n10 = new patient();

            patient b1 = new patient();
            patient b2 = new patient();
            patient b3 = new patient();
            patient b4 = new patient();
            patient b5 = new patient();
            patient b6 = new patient();
            patient b7 = new patient();
            patient b8 = new patient();

            patient h1 = new patient();
            patient h2 = new patient();
            patient h3 = new patient();
            patient h4 = new patient();
            patient h5 = new patient();
            patient h6 = new patient();
            patient h7 = new patient();
            patient h8 = new patient();
            patient h9 = new patient();
            patient h10 = new patient();

            patient w1 = new patient();
            patient w2 = new patient();
            patient w3 = new patient();
            patient w4 = new patient();
            patient w5 = new patient();
            patient w6 = new patient();
            patient w7 = new patient();
            patient w8 = new patient();
            patient w9 = new patient();
            patient w10 = new patient();

            patient a1 = new patient();
            patient a2 = new patient();
            patient a3 = new patient();
            patient a4 = new patient();
            patient a5 = new patient();
            patient a6 = new patient();
            patient a7 = new patient();
            patient a8 = new patient();
            patient a9 = new patient();
            patient a10 = new patient();

            b1.BloodType = "A+";
            b2.BloodType = "A-";
            b3.BloodType = "B+";
            b4.BloodType = "B-";
            b5.BloodType = "O+";
            b6.BloodType = "O-";
            b7.BloodType = "AB+";
            b8.BloodType = "AB-";

            n1.name = "Syed  Hussain";
            n2.name = "Morgan  Fatima";
            n3.name = "Ali  Shaik";
            n4.name = "Stafani  Gale";
            n5.name = "Rose  White";
            n6.name = "Jacquelin  Brown";
            n7.name = "Tahreem  Shah";
            n8.name = "Murtaza  Qasim";
            n9.name = "Brandon  Ross";
            n10.name = "Marium   Sultana";

             g1.gender = "MALE";
             g2.gender = "FEMALE";

            UUID id1 = UUID.randomUUID();
            String sql = "INSERT INTO patient1 VALUES" + "('" + n1.name + "', '" + id1.toString() + "', '" + b1.BloodType + "', '" + w1.weight + "', '" + h1.height + "', '" + a1.AGE + "', '" + g1.gender + "')";
            stmt.executeUpdate(sql);

            UUID id2 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n2.name + "', '" + id2.toString() + "', '" + b2.BloodType + "', '" + w2.weight + "', '" + h2.height + "', '" + a2.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            UUID id3 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n3.name + "', '" + id3.toString() + "', '" + b3.BloodType + "', '" + w3.weight + "', '" + h3.height + "', '" + a3.AGE + "', '" + g1.gender +"')";
            stmt.executeUpdate(sql);

            UUID id4 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n4.name + "', '" + id4.toString() + "', '" + b4.BloodType + "', '" + w4.weight + "', '" + h4.height + "', '" + a4.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            UUID id5 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n5.name + "', '" + id5.toString() + "', '" + b5.BloodType + "', '" + w5.weight + "', '" + h5.height + "', '" + a5.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            UUID id6 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n6.name + "', '" + id6.toString() + "', '" + b6.BloodType + "', '" + w6.weight + "', '" + h6.height + "', '" + a6.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            UUID id7 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n7.name + "', '" + id7.toString() + "', '" + b7.BloodType + "', '" + w7.weight + "', '" + h7.height + "', '" + a7.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            UUID id8 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n8.name + "', '" + id8.toString() + "', '" + b8.BloodType + "', '" + w8.weight + "', '" + h8.height + "', '" + a8.AGE + "', '" + g1.gender +"')";
            stmt.executeUpdate(sql);

            UUID id9 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n9.name + "', '" + id9.toString() + "', '" + b2.BloodType + "', '" + w9.weight + "', '" + h9.height + "', '" + a9.AGE + "', '" + g1.gender +"')";
            stmt.executeUpdate(sql);

            UUID id10 = UUID.randomUUID();
            sql = "INSERT INTO patient1 VALUES" +"('" + n10.name + "', '" + id10.toString() + "', '" + b5.BloodType + "', '" + w10.weight + "', '" + h10.height + "', '" + a10.AGE + "', '" + g2.gender +"')";
            stmt.executeUpdate(sql);

            System.out.println("PATIENTS ADDED TO TABLE" );


        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    private void populatePatient()
    {
        listItem.clear();
        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");

            String SqlStatement = "SELECT bloodtype, age, weight, height, gender, id, name FROM patient1";
            ResultSet result = stmt.executeQuery(SqlStatement);
            while (result.next())
            {
                listItem.add("| ID: " + result.getString("id") + "  |  " + result.getString("name") + "  |  BLOODTYPE: " + result.getString("age")+ "  |  WEIGHT: " + result.getString("weight")+ "  |  HEIGHT: " + result.getString("height")+ "  |  AGE: " + result.getString("bloodtype")+ "  |  " + result.getString("gender"));

                System.out.print(result.getString("id"));
                System.out.print("\t");
                System.out.print(result.getString("name"));
                System.out.print("\t");
                System.out.print(result.getString("bloodtype"));
                System.out.print("\t");
                System.out.print(result.getString("weight"));
                System.out.print("\t");
                System.out.print(result.getString("height"));
                System.out.print("\t");
                System.out.print(result.getString("age"));
                System.out.print("\t");
                System.out.print(result.getString("gender"));
                System.out.println();
            }

        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    private void GeneratePatients(int x)
    {

        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");
            try
            {
                stmt.execute("CREATE TABLE patient1 (" +
                        "name VARCHAR(25), " +
                        "id VARCHAR(36), "+
                        "age VARCHAR(25), "+
                        "weight VARCHAR(25), "+
                        "height VARCHAR(25), "+
                        "bloodtype VARCHAR(25), " +
                        "gender VARCHAR(25))");

                System.out.println("TABLE CREATED");
            }
            catch (Exception ex)
            {
                System.out.println("ERROR: " + ex.getMessage());
            }

        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }
    private void filterPatient()
    {
        listItem2.clear();
        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");

            //String SqlStatement = "SELECT id FROM patient1";
           // String SqlStatement = "SELECT name FROM patient1" +
                                        //"WHERE gender = MALE";
            ResultSet result = stmt.executeQuery("SELECT id, weight, height, age, bloodtype,name, gender FROM patient1 WHERE gender LIKE 'MALE%' ");
            while (result.next())
            {

                String n = result.getString("name");
                String h = result.getString("gender");
                System.out.println(n + "\n" + h + "\n");
                //listItem2.add(result.getString("id") );
                listItem2.add(result.getString("id") + "  |  " + result.getString("name") + "  |  BLOODTYPE: " + result.getString("age")+ "  |  WEIGHT: " + result.getString("weight")+ "  |  HEIGHT: " + result.getString("height")+ "  |  AGE: " + result.getString("bloodtype")+ "  |  " + result.getString("gender"));

               /* System.out.print(result.getString("id"));
                System.out.print("\t");
                System.out.print(result.getString("name"));
                System.out.println();*/
            }

        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    private void filterPatient1()
    {
        listItem2.clear();
        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");

            //String SqlStatement = "SELECT id FROM patient1";
             //String SqlStatement = "SELECT name FROM patient1" +
            //"WHERE gender = MALE";
            ResultSet result = stmt.executeQuery("SELECT id, weight, height, age, bloodtype,name, gender FROM patient1 WHERE gender LIKE 'FEMALE%' ");
            while (result.next())
            {

                String n = result.getString("name");
                String h = result.getString("gender");
                System.out.println(n + "\n" + h + "\n");
                //listItem2.add(result.getString("id") );
                listItem2.add(result.getString("id") + "  |  " + result.getString("name") + "  |  BLOODTYPE: " + result.getString("age")+ "  |  WEIGHT: " + result.getString("weight")+ "  |  HEIGHT: " + result.getString("height")+ "  |  AGE: " + result.getString("bloodtype")+ "  |  " + result.getString("gender"));

               /* System.out.print(result.getString("id"));
                System.out.print("\t");
                System.out.print(result.getString("name"));
                System.out.println();*/
            }

        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    private void filterPatient2()
    {
        listItem2.clear();
        try
        {
            Connection conn = DriverManager.getConnection(AWS_URL);
            Statement stmt = conn.createStatement();
            System.out.println("CONNECTION ESTABLISHED");
            ResultSet result = stmt.executeQuery("SELECT id, weight, height, age, bloodtype,name, gender FROM patient1 WHERE age LIKE 'A+%' ");
            while (result.next())
            {

                String n = result.getString("name");
                String h = result.getString("bloodtype");
                System.out.println(n + "\n" + h + "\n");
                listItem2.add(result.getString("id") + "  |  " + result.getString("name") + "  |  BLOODTYPE: " + result.getString("age")+ "  |  WEIGHT: " + result.getString("weight")+ "  |  HEIGHT: " + result.getString("height")+ "  |  AGE: " + result.getString("bloodtype")+ "  |  " + result.getString("gender"));

            }

        }
        catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }
}
 /*stmt.execute("CREATE TABLE patient (" +
         "name VARCHAR(25), " +
         "id VARCHAR(36), " +
         "gender VARCHAR(25), " +
         "age VARCHAR(25), " +
         "weight VARCHAR(25), " +
         "height VARCHAR(25), " +
         "bloodtype VARCHAR(25))");*/