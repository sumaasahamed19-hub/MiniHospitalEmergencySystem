Mini Hospital Emergency Management System

CIT300 - Data Structures and Algorithms

Project Overview

The Mini Hospital Emergency Management System is a Java console application developed to demonstrate the practical use of fundamental data structures in a hospital environment.

The application manages patient registration, emergency waiting patients, completed treatments, and individual patient visit histories.

Data Structures Used

1. Binary Search Tree - Patient Records

Patient records are stored in a Binary Search Tree using Patient ID as the key.

Operations implemented:

- Insert patient
- Search patient
- Delete patient
- In-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

2. Queue - Emergency Patients

Emergency patients are managed using a custom Queue implementation.

Operations implemented:

- Enqueue
- Dequeue
- Display waiting patients
- Empty queue handling

The queue follows the FIFO (First-In, First-Out) principle.

3. Stack - Treatment History

Completed treatment records are stored using a custom Stack.

Operations implemented:

- Push
- Pop
- Peek
- Display completed treatments
- Empty stack handling

The stack follows the LIFO (Last-In, First-Out) principle.

4. Singly Linked List - Patient Visit History

Each patient has an individual Singly Linked List containing their previous hospital visits.

Operations implemented:

- Add visit
- Remove visit
- Search visit
- Display visit history

Each visit stores:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

Technologies

- Java
- Object-Oriented Programming
- Git
- GitHub

Main Classes

- Patient.java
- PatientNode.java
- PatientBST.java
- EmergencyQueue.java
- TreatmentRecord.java
- TreatmentStack.java
- Visit.java
- VisitNode.java
- VisitLinkedList.java
- HospitalApp.java

How to Run

Compile the Java source files:

javac Patient.java PatientNode.java PatientBST.java EmergencyQueue.java TreatmentRecord.java TreatmentStack.java Visit.java VisitNode.java VisitLinkedList.java HospitalApp.java

Run the application:

java HospitalApp

Author

