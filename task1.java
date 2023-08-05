import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        char[] array = new char[size];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next().charAt(0);
        }
        
        System.out.println("ASCII codes:");
        for (int i = 0; i < size; i++) {
            int ascii = (int) array[i];
            System.out.println(array[i] + ": " + ascii);
        }
        
        scanner.close();
    }
}
