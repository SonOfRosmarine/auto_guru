package form.pages.generate;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomDate {

    Faker faker = new Faker(new Locale("ru"));


    public static String getRandomName() {
        return new Faker(new Locale("ru")).name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker(new Locale("ru")).name().lastName();
    }

    public static String getEmail() {
        return new Faker().internet().emailAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray() {
        String[] randomArray = {"Male", "Female", "Other"};
        int index = getRandomInt(0, randomArray.length - 1);
        return randomArray[index];
    }

    public static String getRandomNumber() {
        String faker1 = "8" + new Faker().phoneNumber().subscriberNumber(9);
        return faker1;
    }

    public static String getRandomBirthMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int index = getRandomInt(0, months.length - 1);
        return months[index];
    }

    public static String getRandomBirthDay() {
        return String.valueOf(new Faker().number().numberBetween(1, 28));
    }

    public static String getRandomBirthYears() {
        return String.valueOf(new Faker().number().numberBetween(1966, 2023));
    }

    public static String getRandomSubjekt() {
        String[] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};
        int index = getRandomInt(0, subjects.length - 1);
        return subjects[index];
    }

    public static String getRandomHobbiess() {
        String[] hobbiess = {"Reading", "Sports", "Music"};
        int index = getRandomInt(0, hobbiess.length - 1);
        return hobbiess[index];
    }

    public static String getRandomAddress() {
        return new Faker(new Locale("ru")).address().streetAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = getRandomInt(0, states.length - 1);
        return states[index];
    }
    public static String getRandomCity(){
        String[]city;
        String resalt = GenerateRandomDate.getRandomState();
        String [] cityNCR = {"Delhi","Gurgaon","Noida"};
        String [] cityUttar = {"Agra","Lucknow","Merrut"};
        String [] cityHaryana = {"Karnal","Panipat"};
        String [] cityRajasthan = {"Jaipur","Jaiselmer"};

        if (resalt.equals("NCR")){
           city = cityNCR;
           int index = getRandomInt(0, city.length - 1);
           return city[index];
        }else if (resalt.equals("Uttar Pradesh")){
            city = cityUttar;
            int index = getRandomInt(0, city.length - 1);
            return city[index];
        }else if (resalt.equals("Haryana")){
            city = cityHaryana;
            int index = getRandomInt(0, city.length - 1);
            return city[index];
        }else {
            city = cityRajasthan;
            int index = getRandomInt(0, city.length - 1);
            return city[index];
        }
    }

}
