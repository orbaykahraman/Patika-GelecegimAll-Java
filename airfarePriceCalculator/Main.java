import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the distance in kilometers :");
        double km = input.nextDouble();

        System.out.print("Enter your age :");
        int age = input.nextInt();

        System.out.print("Enter the trip type (1 => One Way, 2 => Round Trip) :");
        int type = input.nextInt();

        double priceperdistance = 0.10;
        double totalprice = priceperdistance * km;
        double ageDiscount, typeDiscount,discountedAmount, totalDiscountedAmount;

        if (km > 0 && age > 0) {
            switch (type){
                case 1:
                    if (age < 12) {
                        ageDiscount = totalprice * 0.50;
                        discountedAmount = totalprice - ageDiscount;
                        System.out.println("total amount payable : " + discountedAmount + "Tl");
                    } else if (age >= 12 && age < 24) {
                        ageDiscount = totalprice * 0.10;
                        discountedAmount = totalprice - ageDiscount;
                        System.out.println("total amount payable : " + discountedAmount + "Tl");
                    } else if (age > 65) {
                        ageDiscount = totalprice * 0.30;
                        discountedAmount = totalprice - ageDiscount;
                        System.out.println("total amount payable : " + discountedAmount + "Tl");
                    } else {
                        System.out.println("total amount payable : " + totalprice);
                    }
                    break;
                case 2:
                    if (age < 12) {
                        ageDiscount = totalprice * 0.50;
                        discountedAmount = totalprice - ageDiscount;
                        typeDiscount = discountedAmount * 0.20;
                        totalDiscountedAmount = discountedAmount - typeDiscount;
                        System.out.println("total amount payable : " + totalDiscountedAmount + "Tl");
                    } else if (age >= 12 && age < 24 ) {
                        ageDiscount = totalprice * 0.30;
                        discountedAmount = totalprice - ageDiscount;
                        typeDiscount = discountedAmount * 0.20;
                        totalDiscountedAmount = discountedAmount - typeDiscount;
                        System.out.println("total amount payable : " + totalDiscountedAmount + "Tl");
                    } else if (age > 65) {
                        ageDiscount = totalprice * 0.30;
                        discountedAmount = totalprice - ageDiscount;
                        typeDiscount = discountedAmount * 0.20;
                        totalDiscountedAmount = discountedAmount - typeDiscount;
                        System.out.println("total amount payable : " + totalDiscountedAmount + "Tl");
                    } else {
                        System.out.println("total amount payable : " + totalprice);
                    }
                    break;
                default:
                    System.out.println("you have entered an incorrect number please dial 1 or 2:");
            }
        } else {
            System.out.println("Enter a positive value");
        }

    }
}
