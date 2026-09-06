import java.util.Scanner;

public class HospitalApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final PatientBST patientBST =
            new PatientBST();

    private static final EmergencyQueue emergencyQueue =
            new EmergencyQueue(20);

    private static final TreatmentStack treatmentStack =
            new TreatmentStack(20);


    public static void main(String[] args) {

        boolean running = true;

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "     MINI HOSPITAL EMERGENCY MANAGEMENT"
        );

        System.out.println(
                "                  SYSTEM"
        );

        System.out.println(
                "=============================================="
        );


        while (running) {

            displayMenu();

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayAllPatients();
                    break;

                case 5:
                    addPatientToEmergencyQueue();
                    break;

                case 6:
                    treatNextEmergencyPatient();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    completeTreatment();
                    break;

                case 9:
                    removeLatestTreatment();
                    break;

                case 10:
                    treatmentStack.displayStack();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    removePatientVisit();
                    break;

                case 13:
                    searchPatientVisit();
                    break;

                case 14:
                    displayPatientVisitHistory();
                    break;

                case 0:

                    running = false;

                    System.out.println(
                            "\nThank you for using the Mini Hospital Emergency Management System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid menu option."
                    );
            }
        }

        scanner.close();
    }


    // ========================================
    // MAIN MENU
    // ========================================

    private static void displayMenu() {

        System.out.println(
                "\n============== MAIN MENU =============="
        );

        System.out.println(
                "\n--- Patient Records - BST ---"
        );

        System.out.println(
                "1. Register New Patient"
        );

        System.out.println(
                "2. Search Patient"
        );

        System.out.println(
                "3. Delete Patient"
        );

        System.out.println(
                "4. Display All Patients"
        );


        System.out.println(
                "\n--- Emergency Queue ---"
        );

        System.out.println(
                "5. Add Patient to Emergency Queue"
        );

        System.out.println(
                "6. Treat Next Emergency Patient"
        );

        System.out.println(
                "7. Display Emergency Queue"
        );


        System.out.println(
                "\n--- Treatment Stack ---"
        );

        System.out.println(
                "8. Add Completed Treatment"
        );

        System.out.println(
                "9. Remove Latest Treatment Record"
        );

        System.out.println(
                "10. Display Treatment History"
        );


        System.out.println(
                "\n--- Patient Visit Linked List ---"
        );

        System.out.println(
                "11. Add Patient Visit"
        );

        System.out.println(
                "12. Remove Patient Visit"
        );

        System.out.println(
                "13. Search Patient Visit"
        );

        System.out.println(
                "14. Display Patient Visit History"
        );


        System.out.println(
                "\n0. Exit"
        );

        System.out.println(
                "======================================="
        );
    }


    // ========================================
    // BST - REGISTER PATIENT
    // ========================================

    private static void registerPatient() {

        System.out.println(
                "\n===== REGISTER PATIENT ====="
        );

        int patientId =
                readInt("Patient ID: ");

        System.out.print(
                "Patient Name: "
        );

        String patientName =
                scanner.nextLine();

        int age =
                readInt("Age: ");

        System.out.print(
                "Contact Number: "
        );

        String contactNumber =
                scanner.nextLine();

        System.out.print(
                "Medical Condition: "
        );

        String medicalCondition =
                scanner.nextLine();


        Patient patient =
                new Patient(
                        patientId,
                        patientName,
                        age,
                        contactNumber,
                        medicalCondition
                );


        if (patientBST.insert(patient)) {

            System.out.println(
                    "Patient registered successfully."
            );

        } else {

            System.out.println(
                    "A patient with this ID already exists."
            );
        }
    }


    // ========================================
    // BST - SEARCH PATIENT
    // ========================================

    private static void searchPatient() {

        int patientId =
                readInt(
                        "Enter Patient ID to search: "
                );

        Patient patient =
                patientBST.search(patientId);


        if (patient != null) {

            System.out.println(
                    "\nPatient found:"
            );

            patient.displayPatient();

        } else {

            System.out.println(
                    "Patient not found."
            );
        }
    }


    // ========================================
    // BST - DELETE PATIENT
    // ========================================

    private static void deletePatient() {

        int patientId =
                readInt(
                        "Enter Patient ID to delete: "
                );


        if (patientBST.delete(patientId)) {

            System.out.println(
                    "Patient deleted successfully."
            );

        } else {

            System.out.println(
                    "Patient not found."
            );
        }
    }


    // ========================================
    // QUEUE - ENQUEUE
    // ========================================

    private static void addPatientToEmergencyQueue() {

        int patientId =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient is not registered."
            );

            return;
        }


        if (emergencyQueue.containsPatient(patientId)) {

            System.out.println(
                    "Patient is already in the emergency queue."
            );

            return;
        }


        if (emergencyQueue.enqueue(patient)) {

            System.out.println(
                    "Patient added to emergency queue successfully."
            );

        } else {

            System.out.println(
                    "Emergency queue is full."
            );
        }
    }


    // ========================================
    // QUEUE - DEQUEUE
    // ========================================

    private static void treatNextEmergencyPatient() {

        Patient patient =
                emergencyQueue.dequeue();


        if (patient == null) {

            System.out.println(
                    "Emergency queue is empty. No patient is waiting."
            );

            return;
        }


        System.out.println(
                "\nNext patient sent for treatment:"
        );

        patient.displayPatient();
    }


    // ========================================
    // STACK - PUSH COMPLETED TREATMENT
    // ========================================

    private static void completeTreatment() {

        System.out.println(
                "\n===== COMPLETE TREATMENT ====="
        );

        int patientId =
                readInt("Patient ID: ");

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        int treatmentId =
                readInt("Treatment ID: ");


        System.out.print(
                "Treatment Date: "
        );

        String treatmentDate =
                scanner.nextLine();


        System.out.print(
                "Doctor Name: "
        );

        String doctorName =
                scanner.nextLine();


        System.out.print(
                "Treatment Details: "
        );

        String treatmentDetails =
                scanner.nextLine();


        TreatmentRecord treatment =
                new TreatmentRecord(
                        treatmentId,
                        patient.getPatientId(),
                        patient.getPatientName(),
                        treatmentDate,
                        doctorName,
                        treatmentDetails
                );


        if (treatmentStack.push(treatment)) {

            System.out.println(
                    "Completed treatment added to stack successfully."
            );

        } else {

            System.out.println(
                    "Treatment stack is full."
            );
        }
    }


    // ========================================
    // STACK - POP
    // ========================================

    private static void removeLatestTreatment() {

        TreatmentRecord treatment =
                treatmentStack.pop();


        if (treatment == null) {

            System.out.println(
                    "Treatment history stack is empty."
            );

            return;
        }


        System.out.println(
                "\nMost recent treatment record removed:"
        );

        treatment.displayTreatment();
    }


    // ========================================
    // LINKED LIST - ADD VISIT
    // ========================================

    private static void addPatientVisit() {

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        int visitId =
                readInt("Visit ID: ");


        System.out.print(
                "Visit Date: "
        );

        String visitDate =
                scanner.nextLine();


        System.out.print(
                "Doctor Name: "
        );

        String doctorName =
                scanner.nextLine();


        System.out.print(
                "Diagnosis: "
        );

        String diagnosis =
                scanner.nextLine();


        System.out.print(
                "Treatment: "
        );

        String treatment =
                scanner.nextLine();


        Visit visit =
                new Visit(
                        visitId,
                        visitDate,
                        doctorName,
                        diagnosis,
                        treatment
                );


        if (patient
                .getVisitHistory()
                .addVisit(visit)) {

            System.out.println(
                    "Visit added successfully."
            );

        } else {

            System.out.println(
                    "A visit with this Visit ID already exists."
            );
        }
    }


    // ========================================
    // LINKED LIST - REMOVE VISIT
    // ========================================

    private static void removePatientVisit() {

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        int visitId =
                readInt(
                        "Enter Visit ID to remove: "
                );


        if (patient
                .getVisitHistory()
                .removeVisit(visitId)) {

            System.out.println(
                    "Visit removed successfully."
            );

        } else {

            System.out.println(
                    "Visit not found."
            );
        }
    }


    // ========================================
    // LINKED LIST - SEARCH VISIT
    // ========================================

    private static void searchPatientVisit() {

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        int visitId =
                readInt(
                        "Enter Visit ID to search: "
                );


        Visit visit =
                patient
                        .getVisitHistory()
                        .searchVisit(visitId);


        if (visit != null) {

            System.out.println(
                    "\nVisit found:"
            );

            visit.displayVisit();

        } else {

            System.out.println(
                    "Visit not found."
            );
        }
    }


    // ========================================
    // LINKED LIST - DISPLAY VISITS
    // ========================================

    private static void displayPatientVisitHistory() {

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                patientBST.search(patientId);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        System.out.println(
                "\nVisit history for "
                        + patient.getPatientName()
                        + ":"
        );


        patient
                .getVisitHistory()
                .displayVisits();
    }


    // ========================================
    // INTEGER INPUT VALIDATION
    // ========================================

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            try {

                return Integer.parseInt(
                        input.trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}