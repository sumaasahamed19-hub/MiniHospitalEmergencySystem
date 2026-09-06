public class VisitLinkedList {

    private VisitNode head;

    public VisitLinkedList() {
        head = null;
    }

    // ========================================
    // ADD VISIT
    // ========================================

    public boolean addVisit(Visit visit) {

        // Prevent duplicate Visit IDs
        if (searchVisit(visit.getVisitId()) != null) {
            return false;
        }

        VisitNode newNode =
                new VisitNode(visit);

        if (head == null) {

            head = newNode;

            return true;
        }

        VisitNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return true;
    }

    // ========================================
    // REMOVE VISIT
    // ========================================

    public boolean removeVisit(int visitId) {

        if (head == null) {
            return false;
        }

        // Removing first node
        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            return true;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId()
                    == visitId) {

                current.next =
                        current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // ========================================
    // SEARCH VISIT
    // ========================================

    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId()
                    == visitId) {

                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // ========================================
    // DISPLAY VISITS
    // ========================================

    public void displayVisits() {

        if (head == null) {

            System.out.println(
                    "No previous hospital visits found."
            );

            return;
        }

        System.out.println(
                "\n========== PATIENT VISIT HISTORY =========="
        );

        VisitNode current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}