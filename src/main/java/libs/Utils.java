package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    private Logger log;

    public Utils(){
        log = Logger.getLogger(getClass());
    }

    /**
     * Taking screenshot into .//target// + pathToScreenShot
     * @param pathToScreenShot
     * @param driver
     */
    public void screenShot(String pathToScreenShot, WebDriver driver){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToScreenShot));
            log.info("ScreenShot: " + pathToScreenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Hard wait
     * @param second
     */
    public static void waitABit(int second){
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method returned SystemDateAndTime In Format yyyy-MM-dd_HH-mm-ss
     * @return
     */
    public static String getDateAndTimeFormatted(){
        return getDateAndTime("yyyy-MM-dd_HH-mm-ss");
    }

    /**
     * Method returned SystemDateAndTime
     * @return
     */
    public static String getDateAndTime(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        System.out.println(dateFormatted);
        return dateFormatted;
    }

    /**
     * Method returns pseudo random number in given range (inclusive)
     * @param minLimit minimal limit
     * @param maxLimit maximal limit
     * @return random int number in a range
     */
    public static int limitedRandomizer(int minLimit, int maxLimit) {
        if (minLimit >= maxLimit) {
            throw new IllegalArgumentException("C'mon, maximum must be greater than minimum :)");
        }
        Random random = new Random();
        return random.nextInt((maxLimit - minLimit) + 1) + minLimit;
    }
}
