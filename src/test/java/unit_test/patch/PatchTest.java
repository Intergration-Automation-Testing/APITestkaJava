package unit_test.patch;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import api_testka.utils.driver_manager.DriverManager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class PatchTest {

    public static DriverManager driverManager;

    @BeforeClass
    public static void setDriver() {
        driverManager = null;
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9939,
                    Path.of("").toAbsolutePath() + "/generate_apitestka_driver_win.exe",
                    "windows"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterTest() {
        driverManager.quit();
    }

    @Test
    public void testPATCHAPIOnlyMethodAndURL(){
        System.out.println(driverManager.apiTest.testApiMethod("PATCH", "http://httpbin.org/PATCH"));
    }

    @Test
    public void testPATCHAPIMethodAndURLAndCheck(){
        HashMap<String, ? super Object> hashMap = new HashMap<>();
        hashMap.put("status_code", 200);
        System.out.println(driverManager.apiTest.testApiMethod("PATCH", "http://httpbin.org/PATCH"
                , hashMap));
    }

    @Test
    public void testPATCHAPIALL(){
        HashMap<String, ? super Object> hashMap = new HashMap<>();
        hashMap.put("status_code", 200);
        System.out.println(driverManager.apiTest.testApiMethod("PATCH", "http://httpbin.org/PATCH"
                , false, false, false, hashMap));
    }

    @Test
    public void testPATCHAPIOnlyMethodAndURLAndSoap(){
        System.out.println(driverManager.apiTest.testApiMethod("PATCH", "http://httpbin.org/PATCH", true));
    }

    @Test
    public void testPATCHAPIRecord(){
        System.out.println(driverManager.apiTest.testApiMethod("PATCH", "http://httpbin.org/PATCH", false, false));
    }


}