import java.util.*;

// Clase que representa un nodo en el árbol de Huffman
class Node {
    char ch;  // Carácter almacenado en el nodo
    int freq;  // Frecuencia del carácter
    Node left, right;  // Hijos izquierdo y derecho del nodo

    // Constructor para nodos hoja
    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    // Constructor para nodos internos
    Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el texto a comprimir:");
        String text = scanner.nextLine();

        // Contar frecuencias de caracteres
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Crear lista de nodos
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Construir el árbol de Huffman
        while (nodes.size() > 1) {
            // Ordenar nodos por frecuencia
            nodes.sort(Comparator.comparingInt(node -> node.freq));

            // Tomar dos nodos con menor frecuencia
            Node left = nodes.remove(0);
            Node right = nodes.remove(0);

            // Crear un nuevo nodo combinado
            Node combined = new Node(left.freq + right.freq, left, right);
            nodes.add(combined);
        }

        // El nodo restante es la raíz del árbol de Huffman
        Node root = nodes.get(0);

        // Generar códigos de Huffman para cada carácter
        Map<Character, String> codeMap = new HashMap<>();
        buildCodes(root, "", codeMap);

        // Codificar el texto de entrada usando los códigos de Huffman
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(codeMap.get(ch));
        }

        // Mostrar resultados
        System.out.println("Codificación de Huffman:");
        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Texto original: " + text);
        System.out.println("Texto codificado: " + encodedText.toString());

        // Decodificar el texto codificado
        String decodedText = decode(encodedText.toString(), root);
        System.out.println("Texto decodificado: " + decodedText);

        scanner.close();
    }

    // Método recursivo para construir los códigos de Huffman
    private static void buildCodes(Node node, String prefix, Map<Character, String> codeMap) {
        if (node != null) {
            // Si el nodo es una hoja, asignar el prefijo actual como el código del carácter
            if (node.left == null && node.right == null) {
                codeMap.put(node.ch, prefix);
            } else {
                // Recorrer los nodos hijos agregando '0' para la izquierda y '1' para la derecha
                buildCodes(node.left, prefix + '0', codeMap);
                buildCodes(node.right, prefix + '1', codeMap);
            }
        }
    }

    // Método para decodificar una cadena codificada usando el árbol de Huffman
    private static String decode(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            // Avanzar en el árbol de Huffman según el bit actual
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;
            // Si se llega a un nodo hoja, agregar el carácter correspondiente al resultado
            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.ch);
                currentNode = root;
            }
        }
        return decodedText.toString();
    }
}
