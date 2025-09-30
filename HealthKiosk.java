//Task 0
import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Welcome to Ashesi Health Kiosk");

        //Task 1
        System.out.println("Enter the first letter of your desired service: ");
        char serviceCode= input.next().toUpperCase().charAt(0);
        String service = "";
        switch (serviceCode) {
            case 'P':
                service = "PHARMACY";
                System.out.println("Go to the pharmacy desk");
                break;
            case 'L':
                service = "LAB";
                System.out.println("Go to the lab desk");
                break;
            case 'T':
                service = "TRIAGE";
                System.out.println("Go to the triage desk");
                break;
            case 'C':
                service = "COUNSELING";
                System.out.println("Go to the counseling desk");
                break;
            default:
                System.out.println("Invalid Service Code");

        //Task 2
                double metricValue = 0;
                System.out.println("Enter a health metric: A for BMI, B for Dosage, C for Trig: ");
                char metricOption= input.next().toUpperCase().charAt(0);

                if (metricOption=='A') {
                    System.out.println("Enter your weight in kg: ");
                    double weight = input.nextDouble();
                    System.out.println("Enter your height in meters: ");
                    double height = input.nextDouble();
                    double BMI = weight / (height * height);
                    BMI = Math.round(BMI * 10) / 10.0;
                    metricValue = BMI;
                    String category;
                    if (BMI < 18.5) category = "Underweight";
                    else if (BMI < 25.0) category = "Normal";
                    else if (BMI < 30.0) category = "Overweight";
                    else category = "Obese";
                    System.out.println("The BMI is " + BMI + " and the category is " + category + ".");
                }
                else if (metricOption=='B') {
                    System.out.println("Enter the required dosage: ");
                    double dosage= input.nextDouble();
                    int tablets= (int) Math.ceil(dosage/250.0);
                    metricValue=tablets;
                    System.out.println("The required dosage is " + dosage + " mg, thus " + tablets + " tablets are needed.");
                }
                else if (metricOption=='C') {
                    System.out.println("Enter the angle in degrees: ");
                    double angle = input.nextDouble();
                    double radians = Math.toRadians(angle);
                    double sinVal = Math.round(Math.sin(radians) * 1000) / 1000.0;
                    double cosVal = Math.round(Math.cos(radians) * 1000) / 1000.0;
                    metricValue = Math.round(Math.sin(radians) * 100);
                    System.out.println("sin(" + angle + ") = " + sinVal);
                    System.out.println("cos(" + angle + ") = " + cosVal);
                }
                else {
                    System.out.println("Invalid option, try again");
                }
        //Task 3
                char randLetter= (char) ('A'+ (int) (Math.random() * 26));
                int d1 = 3 + (int)(Math.random() * 7);
                int d2 = 3 + (int)(Math.random() * 7);
                int d3 = 3 + (int)(Math.random() * 7);
                int d4 = 3 + (int)(Math.random() * 7);
                String ID=  "" + randLetter + d1 + d2 + d3 + d4;
                System.out.println("Generated ID: " + ID);

                if (ID.length() != 5) {
                    System.out.println("Invalid length");
                } else if (!Character.isLetter(ID.charAt(0))) {
                    System.out.println("Invalid: first char must be a letter");
                } else if (!(Character.isDigit(ID.charAt(1)) &&
                        Character.isDigit(ID.charAt(2)) &&
                        Character.isDigit(ID.charAt(3)) &&
                        Character.isDigit(ID.charAt(4)))) {
                    System.out.println("Invalid: last 4 must be digits");
                } else {
                    System.out.println("ID OK");
                }
        //Task 4
                System.out.print("Enter your first name: ");
                String firstName = input.next();
                char base = Character.toUpperCase(firstName.charAt(0));
                char shifted = (char) ('A' + (base - 'A' + 2) % 26);
                String lastTwo = ID.substring(3);
                int roundedMetric = (int) Math.round(metricValue);
                String displayCode = Character.toString(shifted) + lastTwo + "-" + roundedMetric;
                System.out.println("Display Code: " + displayCode);
        //Task 5
                if (service.equals("TRIAGE")) {
                    System.out.println("Summary: " + service + " | ID=" + ID +
                            " | BMI=" + metricValue + " | Code=" + displayCode);
                } else if (!service.equals("")) {
                    System.out.println("Summary: " + service + " | ID=" + ID +
                            " | Code=" + displayCode);
                }

                input.close();
        }
    }





}

