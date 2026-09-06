public class TreatmentStack {

    private TreatmentRecord[] stackArray;

    private int top;
    private int capacity;

    public TreatmentStack(int capacity) {

        this.capacity = capacity;

        stackArray =
                new TreatmentRecord[capacity];

        top = -1;
    }

    // ========================================
    // PUSH
    // ========================================

    public boolean push(
            TreatmentRecord treatment) {

        if (isFull()) {
            return false;
        }

        stackArray[++top] = treatment;

        return true;
    }

    // ========================================
    // POP
    // ========================================

    public TreatmentRecord pop() {

        if (isEmpty()) {
            return null;
        }

        TreatmentRecord treatment =
                stackArray[top];

        stackArray[top] = null;

        top--;

        return treatment;
    }

    // ========================================
    // PEEK
    // ========================================

    public TreatmentRecord peek() {

        if (isEmpty()) {
            return null;
        }

        return stackArray[top];
    }

    // ========================================
    // DISPLAY STACK
    // ========================================

    public void displayStack() {

        if (isEmpty()) {

            System.out.println(
                    "Treatment history stack is empty."
            );

            return;
        }

        System.out.println(
                "\n======= COMPLETED TREATMENT HISTORY ======="
        );

        System.out.println(
                "Most recently completed treatment is shown first."
        );

        for (int i = top; i >= 0; i--) {

            stackArray[i].displayTreatment();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}