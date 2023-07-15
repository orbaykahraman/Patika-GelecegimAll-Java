public class Employee {
    String name;
    double salary;

    int workHours;
    int hireYear;


    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    double bonus(){
        double bonusPrice;
        if (workHours > 40){
             bonusPrice = (workHours - 40) * 30;
            return bonusPrice;
        } else {
            bonusPrice = 0;
        }
        return bonusPrice;
    }

    double raiseSalary(){
        double bronzeIncrease = 0.05;
        double silverIncrease = 0.10;
        double goldIncrease = 0.15;
        double salaryIncrease = 0;
        if (hireYear < 10){
            salaryIncrease = (salary * bronzeIncrease);
        } if (hireYear > 9 && hireYear < 20){
            salaryIncrease = (salary * silverIncrease);
        } if (hireYear > 19){
            salaryIncrease = (salary * goldIncrease);
        }
        return salaryIncrease;
    }

    public double tax () {
        double tax = 0;
        if (salary > 1000) {
            tax += (salary * 3) / 100;
        }
        else {
            tax = 0;
        }
        return tax;
    }

    double totalSalary = (this.salary + this.bonus() + this.raiseSalary()) - this.tax();


    @Override
    public String toString() {
        return "Adı :" + this.name +
                "\nMaaşı :" + this.salary +
                "\nÇalışma saati :" + this.workHours +
                "\nBaşlangıç yılı :" + this.hireYear +
                "\nVergi :" + this.tax() +
                "\nBonus :" + this.bonus() +
                "\nMaaş artışı :" + this.raiseSalary()+
                "\nVergi ve Bonuslar ile birlikte maaş :" + ((this.salary + this.bonus()) - this.tax()) +
                "\nToplam Maaş :" + ((this.salary + this.bonus() + this.raiseSalary()) - this.tax());
    }
}
