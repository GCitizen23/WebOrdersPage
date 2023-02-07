package utils;

import com.github.javafaker.Faker;
import org.bouncycastle.crypto.io.SignerOutputStream;

public class CommonUtils {

    private CommonUtils() {
    }

    private Faker faker;

    /**
     * this method generates a random String length is equl to length argument
     *
     * @param length will be decided at the time of usage
     * @return String
     */

    public static String generateRandomString(int length) {

        String source = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i <= length; i++) {
            int randomIndex = (int) (Math.random() * source.length());
            result += (String.valueOf(source.charAt(randomIndex)));
        }
        return result;
    }

    public static String generateRandomString(int length, boolean isUpperCase) {  //this is an overloaded method

        String source = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i <= length; i++) {
            int randomIndex = (int) (Math.random() * source.length());
            result += (String.valueOf(source.charAt(randomIndex)));
        }
        return isUpperCase ? result.toUpperCase() : result;

    }

    /**
     * this method will determine random number
     *
     * @param min
     * @param max
     * @return randome number between min and max
     */

    public static int generateRandomNumber(int min, int max) {
        int random = (int) (Math.random() * ((max - min) + 1)) + min;
        return random;
    }

    //the following main is used to test methods above
    public static void main(String[] args) {
        System.out.println(generateRandomString(30));
        System.out.println(generateRandomString(15, true));
        System.out.println(generateRandomNumber(5, 20));
    }

    public static String randomStringNumber(int limit) {
        String result = "";
        for (int i = 0; i <= limit; i++) {
            int random = (int) (Math.random() * 10);
            result += random;

        }
        return result;

        /*
        the method below is used to convert local time to GMT time
        DateFormat gmtFormat = new SimpleDateFormat();
        TimeZone gmtTime = TimeZone.getTimeZone("GMT");
        gmtFormat.setTimeZone(gmtTime);
        System.out.println("Current DateTime in GMT : " + gmtFormat.format(new Date()));

        or

        SimpleDateFormat gmtFormat = new SimpleDateFormat();
        gmtFormat.setTimeZone(TimeZone.getTimeZone(ID "GMT"););
        String format = gmtFormat.format(new Date())
         */
    }

}

