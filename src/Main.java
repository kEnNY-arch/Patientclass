import java.util.ArrayList;

abstract class Personnel {
    String name;
    int age;

    public Personnel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void displayInformation();
}

class Patient extends Personnel {
    String illness;
    double bill;

    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
        this.bill = 0.0;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public void displayInformation() {
        System.out.println("Patient - Name: " + name + ", Age: " + age + ", Illness: " + illness + ", Bill: " + bill);
    }
}

class PeopleGroup {
    ArrayList<Personnel> peopleList = new ArrayList<>();

    public void addPerson(Personnel person) {
        peopleList.add(person);
    }

    public void listPeople() {
        for (Personnel person : peopleList) {
            person.displayInformation();
        }
    }
}

class Hospital extends PeopleGroup {
    public void admitPatient(Patient patient) {
        addPerson(patient);
    }

    public void listPatients() {
        listPeople();
    }

    public void updateBill(Patient patient, double amount) {
        double currentBill = patient.getBill();
        patient.setBill(currentBill + amount);
    }
}
