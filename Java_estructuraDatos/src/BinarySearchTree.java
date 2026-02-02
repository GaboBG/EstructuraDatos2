public class BinarySearchTree<T extends Comparable<T>> {

    // Raíz del árbol. Es genérico y compara usando Comparable.
    private Node<T> root;
    private int size = 0;

    public void insert(T value) {
        // Inserta el valor manteniendo la propiedad del ABB.
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        // Compara el valor a insertar con el del nodo actual.
        int cmp = value.compareTo(current.data);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, value);
        }
        // Si cmp == 0 se considera duplicado y no se inserta.
        return current;
    }

    public boolean contains(T value) {
        // Verifica si el árbol contiene el valor.
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> current, T value) {
        if (current == null) return false;

        int cmp = value.compareTo(current.data);
        if (cmp == 0) return true;
        return cmp < 0
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }


    public void delete(T value) {
        // Elimina un valor y reajusta enlaces para mantener el ABB.
        root = deleteRecursive(root, value);
    }

    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) return null;

        int cmp = value.compareTo(current.data);
        if (cmp < 0) {
            current.left = deleteRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = deleteRecursive(current.right, value);
        } else {

            // Caso 1 y 2: nodo con 0 o 1 hijo se elimina directamente.
            if (current.left == null) {
                size--;
                return current.right;
            }
            if (current.right == null) {
                size--;
                return current.left;
            }

            // Caso 3: nodo con 2 hijos ...
            T minValue = findMin(current.right);
            current.data = minValue;
            current.right = deleteRecursive(current.right, minValue);
        }
        return current;
    }

    private T findMin(Node<T> node) {
        // Busca el mínimo más a la izquierda en un subárbol.
        while (node.left != null) node = node.left;
        return node.data;
    }


    public void inOrderTraversal() {
        // Recorre el árbol en orden: izquierda, nodo, derecha.
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.data);
            inOrderRecursive(node.right);
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}