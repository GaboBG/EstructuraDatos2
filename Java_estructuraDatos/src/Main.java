public class Main {
    public static void main(String[] args) {


        BinarySearchTree<Persona> bst = new BinarySearchTree<>();

        bst.insert(new Persona("Ana", 30));
        bst.insert(new Persona("Luis", 25));
        bst.insert(new Persona("Carlos", 35));
        bst.insert(new Persona("Bea", 28));

        System.out.println("Recorrido inorden:");
        bst.inOrderTraversal();

        System.out.println("\n¿Contiene a Luis (25)? " + bst.contains(new Persona("Luis", 25)));

        System.out.println("\nEliminando a Ana (30)...");
        bst.delete(new Persona("Ana", 30));

        System.out.println("\nRecorrido inorden después de eliminar:");
        bst.inOrderTraversal();

        System.out.println("\nTamaño del árbol: " + bst.size());

    }
}