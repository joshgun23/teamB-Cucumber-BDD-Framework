package utils;

import org.junit.Assert;

import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static utils.DBUtils.getColumnNames;

public class JDBCDemo {


    public static void main(String[] args) throws SQLException {

//        String url = "jdbc:mysql://apps-database.cb72canasobc.us-east-2.rds.amazonaws.com/loan";
////
//        Connection connection = DriverManager.getConnection(url, "duotech", "duotech2023");
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from tbl_mortagage");
//
//        resultSet.next();
//        //System.out.println(resultSet.getString(6));
//
//        while(resultSet.next()){
//             System.out.println(resultSet.getString(1) +"\t" + resultSet.getString(2) +"\t" + resultSet.getString(3) +"\t" + resultSet.getString(4) + "\t"
//                     + resultSet.getString(5) + "\t" + resultSet.getString(6));
//         }
//
//
//// UPDATE
//      DBUtils.executeUpdate("update users set email='myEmail@gmail.com', firstName='JDBC' where username='duotech2001'");

//
//        DBUtils.createConnection();
//
//        DBUtils.executeUpdate("INSERT INTO tbl_mortagage (b_firstName,b_lastName) values ('JOSH3','JOSH4')");

//        for (int listOfList : i) {
//            System.out.println(listOfList);
//        }

//        DBUtils.createConnection();
//        List<String> actuallycolumnNames = DBUtils.getColumnNames("SELECT b_firstName,\n" +
//                "b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home\n" +
//                "FROM tbl_mortagage\n");

        //String expectedColumnNames = "id, realtor_status, realtor_info, loan_officer_status, purpose_loan, est_purchase_price, down_payment, down_payment_percent, total_loan_amount, src_down_payment, add_fund_available, apply_co_borrower, b_firstName, b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home, c_firstName, c_middleName, c_lastName, c_suffix, c_email, c_dob, c_ssn, c_marital, c_cell, c_home, rent_own_status, monthly_rental_payment, first_mortagage_total_payment, employer_name, position, city, state, start_date, end_date, current_job, co_employer_name, co_position, co_city, co_state, co_start_date, co_end_date, co_current_job, gross_monthly_income, monthly_over_time, monthly_bonuses, monthly_commision, monthly_dividents, c_gross_monthly_income, c_monthly_over_time, c_monthly_bonuses, c_monthly_commision, c_monthly_dividents, add_belong, income_source, amount, eConsent_declarer, eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email, created_on, modified_on, loan_status, user_id, active";

// Convert the expected column names into a list of strings
        //List<String> expectedColumnNamesList = Arrays.asList(expectedColumnNames.split("\\s*,\\s*"));

// Compare the lists using Assert.assertEquals
       // Assert.assertEquals(columnNames, expectedColumnNamesList);
       // System.out.println(actuallycolumnNames);

//
//        String url = "jdbc:mysql://apps-database.cb72canasobc.us-east-2.rds.amazonaws.com/employees";
//
//        Connection connection = DriverManager.getConnection(url, "duotech", "duotech2023");
//
//        System.out.println("Connection established");
//
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select * from employees limit 10");
//
//         while(resultSet.next()){
//             System.out.println(resultSet.getString(1) +"\t" + resultSet.getString(2) +"\t" + resultSet.getString(3) +"\t" + resultSet.getString(3));
//         }


//          Util class demo
//
        // Establish connection to the DB
        DBUtils.createConnection();
//
//        List<List<Object>> listOfLists = DBUtils.getListOfLists("select * from users where username='duotech2001'");
//
//        System.out.println(listOfLists);
//
//        System.out.println( listOfLists.get(0).get(4));
//
//        List<Map<String, Object>> listOfMaps = DBUtils.getListOfMaps("select * from users where username='duotech2001'");
//
//
//        System.out.println(listOfMaps);
//
//        System.out.println(listOfMaps.get(0).get("email"));
//
//        List<String> columnNames = DBUtils.getColumnNames("select * from users where username='duotech2001'");
//
//        System.out.println(columnNames);
//
        //final List<List<Object>> select_email_from_tbl_user = DBUtils.getListOfLists("select email from tbl_user limit 5");

        //System.out.println(select_email_from_tbl_user);
//
//        // UPDATE
//        DBUtils.executeUpdate("update users set email='myEmail@gmail.com', firstName='JDBC' where username='duotech2001'");
//
//        //CREATE
//        DBUtils.executeUpdate("insert into users (username, firstName, lastName, email, password) values ('byeworld', 'Bye', 'World', 'bw@gmail.com', 'ca8193792644b5bd78269c737fb442c1')");
//
//        // DELETE
//        DBUtils.executeUpdate("DELETE FROM users WHERE username='byeworld'");


    }
}

