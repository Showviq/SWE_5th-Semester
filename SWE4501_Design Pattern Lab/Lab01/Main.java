class MyDate {
    public int year;
    public int month;
    public int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

class Student extends Person {
    public String status;

    public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }
}

class Employee extends Person {
    public String office;
    public double salary;
    public MyDate dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, MyDate dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }
}

class Faculty extends Employee {
    public String officeHours;
    public String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, MyDate dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public double getSalary() {
        return salary;
    }

}

class Staff extends Employee {
    String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }
}

class FullTime extends Staff {
    public FullTime(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired, title);
    }
}

class PartTime extends Staff {
    public double hourlyRate;
    public double workedHours;

    public PartTime(String name, String address, String phoneNumber, String emailAddress,
            String office, double hourlyRate, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, 0, dateHired, title);
        this.hourlyRate = hourlyRate;
        this.workedHours = 0;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public double getSalary() {
        return hourlyRate * workedHours;
    }
}

public class Main {
    public static void main(String[] args) {
        MyDate hireDate = new MyDate(2023, 8, 18);

        Faculty facultyMember = new Faculty("John Doe", "123 Main St", "555-1234", "john@example.com",
                "Building A, Room 101", 60000, hireDate, "9 AM - 5 PM", "Professor");

        Staff partTimeStaff = new PartTime("Jane Smith", "456 Elm St", "555-5678", "jane@example.com",
                "Building B, Room 201", 15, hireDate, "Clerk");

        PartTime partTimeEmployee = (PartTime) partTimeStaff; // Downcasting
        partTimeEmployee.setWorkedHours(20); // Set worked hours
        System.out.println(facultyMember);
        System.out.println("Salary: $" + facultyMember.getSalary());

        System.out.println(partTimeStaff);
        System.out.println("Salary: $" + partTimeStaff.getSalary());
    }
}
