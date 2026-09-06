public class PatientBST {

    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    // ========================================
    // INSERT PATIENT
    // ========================================

    public boolean insert(Patient patient) {

        PatientNode newNode = new PatientNode(patient);

        if (root == null) {
            root = newNode;
            return true;
        }

        PatientNode current = root;
        PatientNode parent = null;

        while (current != null) {

            parent = current;

            if (patient.getPatientId()
                    < current.patient.getPatientId()) {

                current = current.left;

            } else if (patient.getPatientId()
                    > current.patient.getPatientId()) {

                current = current.right;

            } else {

                // Duplicate Patient ID
                return false;
            }
        }

        if (patient.getPatientId()
                < parent.patient.getPatientId()) {

            parent.left = newNode;

        } else {

            parent.right = newNode;
        }

        return true;
    }

    // ========================================
    // SEARCH PATIENT
    // ========================================

    public Patient search(int patientId) {

        PatientNode current = root;

        while (current != null) {

            if (patientId == current.patient.getPatientId()) {

                return current.patient;

            } else if (patientId
                    < current.patient.getPatientId()) {

                current = current.left;

            } else {

                current = current.right;
            }
        }

        return null;
    }

    // ========================================
    // DELETE PATIENT
    // ========================================

    public boolean delete(int patientId) {

        if (search(patientId) == null) {
            return false;
        }

        root = deleteNode(root, patientId);

        return true;
    }

    private PatientNode deleteNode(
            PatientNode node,
            int patientId) {

        if (node == null) {
            return null;
        }

        if (patientId < node.patient.getPatientId()) {

            node.left = deleteNode(
                    node.left,
                    patientId
            );

        } else if (patientId > node.patient.getPatientId()) {

            node.right = deleteNode(
                    node.right,
                    patientId
            );

        } else {

            // Case 1 and Case 2
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Case 3 - node has two children
            PatientNode successor =
                    findMinimum(node.right);

            node.patient = successor.patient;

            node.right = deleteNode(
                    node.right,
                    successor.patient.getPatientId()
            );
        }

        return node;
    }

    private PatientNode findMinimum(
            PatientNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // ========================================
    // IN-ORDER TRAVERSAL
    // ========================================

    public void displayAllPatients() {

        if (root == null) {

            System.out.println(
                    "No patient records available."
            );

            return;
        }

        System.out.println(
                "\n========== PATIENT RECORDS =========="
        );

        inOrder(root);
    }

    private void inOrder(PatientNode node) {

        if (node != null) {

            inOrder(node.left);

            node.patient.displayPatient();

            inOrder(node.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}