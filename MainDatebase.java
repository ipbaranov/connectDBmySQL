package com.example.scrapeTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDatebase {



    public static void main(String[] args) {
        List<String> tempOneList = new ArrayList<String>();
        List<String> templist1 = new ArrayList<String>();


        try {
            String url = "jdbc:mysql://begetwin.beget.tech:3306/begetwin_chek";
            String username = "begetwin_chek";
            String password = "123456AbC";
            Class.forName("com.mysql.cj.jdbc.Driver")/*.getDeclaredConstructor().newInstance()*/;

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement st = conn.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM  checker ");

                while (res.next()) {
                    tempOneList.add(res.getString("whatBuy"));
                }

                ResultSet resOne = st.executeQuery("SELECT * FROM  checker");
                while (resOne.next()) {
                    templist1.add(resOne.getString("price"));
                }
                for (int i=0; i <tempOneList.size(); i++){
                    System.out.println( tempOneList.get(i));


                }
                for (int b = 0; b < templist1.size(); b++) {
                    System.out.println("\n" + templist1.get(b) );
                }

            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("problem in connection");
            }



            /*савка данных пример*/
                /*Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT checker (`whatBuy`, `number`, `price`, `action`) VALUES ('samsung', '1', '200', 'delit');");
                System.out.printf("Added %d rows", rows);

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }*/
            /*конец операции*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }}
