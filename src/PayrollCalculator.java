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
}
