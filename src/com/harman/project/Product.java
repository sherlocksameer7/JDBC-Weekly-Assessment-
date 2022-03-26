package com.harman.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Product
{

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        int option;

        while (true)
        {
            System.out.println("Select an Option :");
            System.out.println("1. Add the Product ");
            System.out.println("2. View All Products ");
            System.out.println("3. Search a Product using Product  Code ");
            System.out.println("4. Update Product details using Product Code ");
            System.out.println("5. Delete a Product  using product Code ");
            System.out.println("6. Display all the Details of Products  whose price  is Greater than 50000 ");
            System.out.println("7. Display the Count of total number of Products  in the Company ");
            System.out.println("8. Display all the Product Details in Alphabetical Order ");
            System.out.println("9. Exit ");


            option = in.nextInt();


            switch (option)
            {
                case 1 :
                    try
                    {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false","root","");


                        String product_Code, product_name, brand , price , model, year_of_manufacturing , expiry_date; // These values doesn't depends on the data base name

                        System.out.println("Enter the Product Code :");
                        product_Code = in.next();
                        System.out.println("Enter the Product Name :");
                        product_name = in.next();
                        System.out.println("Enter the Brand :");
                        brand = in.next();
                        System.out.println("Enter the Price :");
                        price = in.next();
                        System.out.println("Enter the Model :");
                        model = in.next();
                        System.out.println("Enter the Year of Manufacturing :");
                        year_of_manufacturing = in.next();
                        System.out.println("Enter the Expiry Date :");
                        expiry_date = in.next();


                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`(`product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacturing`, `expiry_date`)" +
                                "VALUES("+product_Code+",'"+product_name+"','"+brand+"',"+price+",'"+model+"',"+year_of_manufacturing+","+expiry_date+")");

                        System.out.println("Inserted Sucessfully !!!");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 2 :
                    System.out.println("View All Product : ");
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacturing`, `expiry_date` FROM `products` WHERE 1");

                        while (rs.next())
                        {
                            System.out.println("product code = " + rs.getInt("product_code"));
                            System.out.println("product name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 3 :
                    try
                    {
                        int productcode;

                        System.out.println("Enter the Product Code to be Searched : ");
                        productcode = in.nextInt();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `product_code` = "+productcode);

                        while (rs.next())
                        {
                            System.out.println("product name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 4 :
                    try
                    {
                        int productcode;

                        System.out.println("Enter the Product Code to be Updated : ");
                        productcode = in.nextInt();

                        String productname, brand , price , model, yearofmanufacturing , expirydate;

                        System.out.println("Enter the Product Name to be Updated : ");
                        productname = in.next();
                        System.out.println("Enter the Brand to be Updated : ");
                        brand = in.next();
                        System.out.println("Enter the Price to be Updated : ");
                        price = in.next();
                        System.out.println("Enter the Model to be Updated : ");
                        model = in.next();
                        System.out.println("Enter the Year of Manufacturing to be Updated : ");
                        yearofmanufacturing = in.next();
                        System.out.println("Enter the Expiry Date to be Updated : ");
                        expirydate = in.next();


                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        stmt.executeUpdate("UPDATE `products` SET `product_name`='"+productname+"',`brand`='"+brand+"',`price`="+price+",`model`='"+model+"',`year_of_manufacturing`="+yearofmanufacturing+",`expiry_date`="+expirydate+" WHERE `product_code`="+productcode);
                        System.out.println("Updated sucessfully");

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 5 :
                    try
                    {
                        int productcode;

                        System.out.println("Enter the Product Code to be Deleted : ");
                        productcode = in.nextInt();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        stmt.executeUpdate("DELETE FROM `products` WHERE `product_code`="+productcode);
                        System.out.println("Deleted Sucessfully !!!");


                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 6 :
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `price` > 50000");
                        while (rs.next())
                        {
                            System.out.println("product code = " + rs.getInt("product_code"));
                            System.out.println("product name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expiry_date"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;




                case 7 :
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM `products`");


                        rs.next();
                        int count = rs.getInt(1);  // This for counting all the products in the given Data
                        System.out.println("The Total Count of the Products = " + count);

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;




                case 8 :
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacturing`, `expiry_date` FROM `products` WHERE 1 order by product_name asc ");
                        while (rs.next())
                        {
                            System.out.println("product code = " + rs.getInt("product_code"));
                            System.out.println("product name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expiry_date"));
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 9:
                    System.exit(0);



                default:
                    System.out.println("Invalid Option = ??? ");

            }
        }
    }
}
