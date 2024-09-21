package steps;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestNg {

    @Test(priority = 1)
    public static void test2() {
        System.out.println("Test2 executed");
    }

    @Test(dependsOnMethods = "test2")
    public static void test3() throws InterruptedException {
        Thread.sleep(3);
        System.out.println("Test3 executed");
    }

    @Test(priority = 1)
    public static void test4() {
        System.out.println("Test4 executed");
    }

    @Test(priority = 0)
    public static void test1() {
        System.out.println("Test1 executed");
    }

    public void dbConnection() throws SQLException {
        DriverManager.getConnection("");
    }



}
