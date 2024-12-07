class Node {
    int coefficient; 
    int exponent;  
    Node next;       
    
    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    Node head;  // Head node of the linked list
    
    public Polynomial() {
        head = null;
    }
    public void addTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null || head.exponent < exponent) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.exponent > exponent) {
                current = current.next;
            }
            if (current.next != null && current.next.exponent == exponent) {
                current.next.coefficient += coefficient;  // Combine like terms
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }
    public void printPolynomial() {
        Node current = head;
        while (current != null) {
            if (current != head && current.coefficient > 0) {
                System.out.print("+");
            }
            System.out.print(current.coefficient + "x^" + current.exponent);
            current = current.next;
            if (current != null) System.out.print(" ");
        }
        System.out.println();
    }
    public Polynomial add(Polynomial other) {
        Polynomial result = new Polynomial();
        Node p1 = this.head;
        Node p2 = other.head;
        
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                result.addTerm(p2.coefficient, p2.exponent);
                p2 = p2.next;
            } else if (p2 == null) {
                result.addTerm(p1.coefficient, p1.exponent);
                p1 = p1.next;
            } else if (p1.exponent > p2.exponent) {
                result.addTerm(p1.coefficient, p1.exponent);
                p1 = p1.next;
            } else if (p1.exponent < p2.exponent) {
                result.addTerm(p2.coefficient, p2.exponent);
                p2 = p2.next;
            } else {  // p1.exponent == p2.exponent
                int sum = p1.coefficient + p2.coefficient;
                if (sum != 0) {
                    result.addTerm(sum, p1.exponent);
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return result;
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        
        // Add terms to the first polynomial: 3x^3 + 4x^2 + 5x + 6
        poly1.addTerm(3, 3);
        poly1.addTerm(4, 2);
        poly1.addTerm(5, 1);
        poly1.addTerm(6, 0);
        
        // Add terms to the second polynomial: 4x^3 + 3x^2 + 2x + 1
        poly2.addTerm(4, 3);
        poly2.addTerm(3, 2);
        poly2.addTerm(2, 1);
        poly2.addTerm(1, 0);
        

        System.out.println("Polynomial 1: ");
        poly1.printPolynomial();
        System.out.println("Polynomial 2: ");
        poly2.printPolynomial();
        Polynomial result = poly1.add(poly2);
      
        System.out.println("Resultant Polynomial after addition: ");
        result.printPolynomial();
    }
}
