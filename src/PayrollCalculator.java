package src;

public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double weeklyPay = 0;
        if (hoursWorked > 0 && hourlyRate >0){
            switch (employeeType) {
                case "FULL_TIME":
                    if (hoursWorked>40 && hourlyRate>0){
                        weeklyPay= 40 *  hourlyRate;
                        weeklyPay+= (hoursWorked-40) * (hourlyRate*1.5);
                    } else if (hoursWorked<40 && hourlyRate>0){
                        weeklyPay= hoursWorked *  hourlyRate;
                    }
                    break;
                case  "PART_TIME":
                    if (hoursWorked>25 && hourlyRate>0){
                        weeklyPay= 25 *  hourlyRate;
                    } else if (hoursWorked<25 && hourlyRate>0){
                        weeklyPay= hoursWorked *  hourlyRate;
                    }
                    break;
                case "CONTRACTOR":
                    if (hoursWorked>0 && hourlyRate>0){
                        weeklyPay= hoursWorked *  hourlyRate;
                    }
                    break;
                case "INTERN":
                    if (hoursWorked>20 && hourlyRate>0){
                        weeklyPay= 20 *  (hourlyRate * 0.2);
                    } else if (hoursWorked<20 && hourlyRate>0){
                        weeklyPay= hoursWorked *  (hourlyRate * 0.2);
                    }
                    break;
                default:
                    System.out.println("Please enter valid employee type");
                    weeklyPay= -1;
            }
        } else {
            System.out.println("Please enter valid values");
            weeklyPay= -1;
        }
        return weeklyPay;
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxDeduction = 0;
        if (grossPay > 0 && grossPay < 500){
            taxDeduction= grossPay * 0.10;
        } else if (grossPay > 501 && grossPay < 100){
            taxDeduction= grossPay * 0.15;
        } else if (grossPay > 1001 && grossPay < 2000){
            taxDeduction= grossPay * 0.20;
        } else if (grossPay > 2000){
            taxDeduction= grossPay * 0.25;
        } else {
            System.out.println("Please enter valid values");
        }

        if (hasHealthInsurance){taxDeduction= taxDeduction - 50;}

        return taxDeduction;
    }
}
