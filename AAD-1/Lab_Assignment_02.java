package Lab_Assignment_02;
import java.util.Scanner;
class Lab_Assignment_02{
    //Case - 01
    public static int sum(int[] arr, int n){
        if (n==0){
            return 0;
        }
        else{
            return arr[n-1] + sum(arr, n-1);
        }

    }
    //Case - 02
    public static int Min(int[] arr, int n){
        if(n==1){
            return arr[0];
        }
        return Math.min(arr[n-1], Min(arr, n-1));
    }
    public static int Max(int[] arr, int n){
        if(n==1){
            return arr[0];
        }
        return Math.max(arr[n-1], Max(arr, n-1));
    }
    //Case - 03
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    //Case - 04
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        else if(n==1 || n==2){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    //Case - 05
    public static int gcd(int n1, int n2){
        if(n2!=0){
            return gcd(n2, n1%n2);
        }
        else{
            return n1;
        }
    }
    //Case - 06
    public static int pow(int base, int pow){
        if(pow==0){
            return 1;
        return base*pow(base, n-1);
    }
    //Case - 07
    public static int Missing(int[] arr, int start, int end){
        if(start > end){
            return end + 1;
        }
        int mid = (start + mid)/2;
        if(arr[mid] != mid + 1){
            return Missing(arr, start, mid - 1);
        }
        else{
            return Missing(arr, mid + 1, end);
        }
    }
    //Case - 08
    public static void decToHex(int n) {
        if (n == 0) {
            System.out.print("0");
            return;
        }
        decToHex(n / 16);
        
        int rem = n % 16;
        if (rem < 10) {
            System.out.print(rem);
        } else {
            System.out.print((char) (rem - 10 + 'A'));
        }
    }
    

}