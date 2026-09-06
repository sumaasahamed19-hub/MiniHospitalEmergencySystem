public class EmergencyQueue {

    private Patient[] queueArray;

    private int front;
    private int rear;
    private int size;
    private int capacity;

    public EmergencyQueue(int capacity) {

        this.capacity = capacity;

        queueArray = new Patient[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // ========================================
    // ENQUEUE
    // ========================================

    public boolean enqueue(Patient patient) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;

        queueArray[rear] = patient;

        size++;

        return true;
    }

    // ========================================
    // DEQUEUE
    // ========================================

    public Patient dequeue() {

        if (isEmpty()) {
            return null;
        }

        Patient patient = queueArray[front];

        queueArray[front] = null;

        front = (front + 1) % capacity;

        size--;

        return patient;
    }

    // ========================================
    // DISPLAY QUEUE
    // ========================================

    public void displayQueue() {

        if (isEmpty()) {

            System.out.println(
                    "Emergency queue is empty."
            );

            return;
        }

        System.out.println(
                "\n======= EMERGENCY WAITING QUEUE ======="
        );

        for (int i = 0; i < size; i++) {

            int index =
                    (front + i) % capacity;

            Patient patient =
                    queueArray[index];

            System.out.println(
                    (i + 1)
                            + ". Patient ID: "
                            + patient.getPatientId()
                            + " | Name: "
                            + patient.getPatientName()
                            + " | Condition: "
                            + patient.getMedicalCondition()
            );
        }

        System.out.println(
                "========================================"
        );
    }

    // ========================================
    // CHECK WHETHER PATIENT IS ALREADY WAITING
    // ========================================

    public boolean containsPatient(int patientId) {

        for (int i = 0; i < size; i++) {

            int index =
                    (front + i) % capacity;

            if (queueArray[index].getPatientId()
                    == patientId) {

                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }
}