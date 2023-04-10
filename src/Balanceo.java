import java.util.Scanner;
import java.util.Stack;
public class Balanceo {

    public static boolean balancear(String simbolos) {
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < simbolos.length(); i++) {
            char simbolo = simbolos.charAt(i);
            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                pila.push(simbolo);
            } else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                if (pila.isEmpty()) {
                    return false;
                } else if (simbolo == ')' && pila.peek() == '('  ||
                        simbolo == ']' && pila.peek() == '[' ||
                        simbolo == '}' && pila.peek() == '{') {
                    pila.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String simbolos;
        System.out.println("Ingrese la expresión: ");
        simbolos = sc.nextLine();
        if (balancear(simbolos)==false) {
            System.out.println("La expresión no está balanceada.");
        } else {
            System.out.println("La expresión está balanceada.");
        }
    }
}