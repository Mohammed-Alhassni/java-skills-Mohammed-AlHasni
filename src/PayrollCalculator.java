package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double weeklyPay = 0;
        if (hoursWorked > 0 && hourlyRate > 0) {
            switch (employeeType) {
                case "FULL_TIME":
                    if (hoursWorked > 40 && hourlyRate > 0) {
                        weeklyPay = 40 * hourlyRate;
                        weeklyPay += (hoursWorked - 40) * (hourlyRate * 1.5);
                    } else if (hoursWorked < 40 && hourlyRate > 0) {
                        weeklyPay = hoursWorked * hourlyRate;
                    }
                    break;
                case "PART_TIME":
                    if (hoursWorked > 25 && hourlyRate > 0) {
                        weeklyPay = 25 * hourlyRate;
                    } else if (hoursWorked < 25 && hourlyRate > 0) {
                        weeklyPay = hoursWorked * hourlyRate;
                    }
                    break;
                case "CONTRACTOR":
                    if (hoursWorked > 0 && hourlyRate > 0) {
                        weeklyPay = hoursWorked * hourlyRate;
                    }
                    break;
                case "INTERN":
                    if (hoursWorked > 20 && hourlyRate > 0) {
                        weeklyPay = 20 * (hourlyRate * 0.2);
                    } else if (hoursWorked < 20 && hourlyRate > 0) {
                        weeklyPay = hoursWorked * (hourlyRate * 0.2);
                    }
                    break;
                default:
                    System.out.println("Please enter valid employee type");
                    weeklyPay = -1;
            }
        } else {
            System.out.println("Please enter valid values");
            weeklyPay = -1;
        }
        return weeklyPay;
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxDeduction = 0;
        if (grossPay > 0 && grossPay < 500) {
            taxDeduction = grossPay * 0.10;
        } else if (grossPay > 501 && grossPay < 100) {
            taxDeduction = grossPay * 0.15;
        } else if (grossPay > 1001 && grossPay < 2000) {
            taxDeduction = grossPay * 0.20;
        } else if (grossPay > 2000) {
            taxDeduction = grossPay * 0.25;
        } else {
            System.out.println("Please enter valid values");
        }
        if (hasHealthInsurance) {
            taxDeduction = taxDeduction - 50;
        }

        return taxDeduction;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        ArrayList<Double> salaries = new ArrayList<>();

        for (int i = 0; i < employeeTypes.length; i++) {
            double weeklyPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            salaries.add(weeklyPay);
        }

        String highestPayEmployee = "";
        double max = salaries.get(0);
        String lowestPayEmployee= "";
        double min = salaries.get(0);

        for (int i = 0; i < names.length; i++) {
            if (salaries.get(i) > max) {
                highestPayEmployee = names[i];
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (salaries.get(i) < min) {
                lowestPayEmployee = names[i];
            }
        }

        double totalPay = 0;
        for (double salary : salaries) {
            totalPay = +salary;

        }
        double averagePay = totalPay / salaries.size();

        int overTimeCount = 0;
        for (double hour : hours) {
            if (hour > 40) {
                overTimeCount++;
            }
        }

        System.out.println("-----------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]+ " salary is: "+ salaries.get(i));
        }
        System.out.println("-----------------------------------\n");
        System.out.println("Highest paid employed is:" +highestPayEmployee);
        System.out.println("Lowest paid employed is:" +lowestPayEmployee);
        System.out.println("Average pay:" + averagePay);
        System.out.println(overTimeCount + " worked overtime");
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);

    }
}
