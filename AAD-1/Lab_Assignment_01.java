package Lab_Assignment_01;
import java.util.Scanner;

public class Lab_Assignment_01 {
	
	
	public static void sumOfNElements(int[] arr, int n) {
		int sum = 0;
		for(int i = 0; i<n; i++) {
			sum += arr[i];
		}
		System.out.println("Sum of the lements in the given array is = " + sum);
	}
	
	public static void minMax(int[] arr, int n) {
		int min = arr[0];
		int max = arr[0];
		for(int i=0;i<n;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
			else if (arr[i] < min) {
				min = arr[i];			}
		}
		System.out.println("Minimum element : "+ min);
		System.out.println("Maximum element : "+ max);
	}
	
	public static void findMissing(int[] arr , int n) {
		int sum = 0;
		for(int i =0;i<n;i++) {
			sum += arr[i];
		}
		int trueSum = ((n+1) * (n + 2))/2;
		int missing = trueSum - sum;
		System.out.println(trueSum);
		System.out.println(sum);
		System.out.println("The missing number is : " + missing);
	}
	
	public static void factorial(int n) {
		int fact = 1;
		for (int i = 1; i<= n;i++) {
			fact *= i;
		}
		System.out.println("Factorial of "+n+" is = "+fact);
	}
	
	public static void rotateArrayByRPlaces(int[] arr, int n, int r) {
	    // Handle case when r is greater than n
	    r = r % n;
	    
	    System.out.println("The original array is:");
	    // Print the array
	    for (int i = 0; i < n; i++) {
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();

	    // Reverse first R digits
	    reverse(arr, 0, r - 1);
	    
	    // Reverse next remaining digits
	    reverse(arr, r, n - 1);
	    
	    // Reverse the complete array
	    reverse(arr, 0, n - 1);

	    System.out.println("The rotated array is:");
	    // Print the array
	    for (int i = 0; i < n; i++) {
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	}

	private static void reverse(int[] arr, int start, int end) {
	    while (start < end) {
	        int temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    }
	}

	
	
	public static void maximumContiguousSubArray(int [] arr, int n) {
		int res = arr[0];
		int maxEnd = 0;
		for(int i = 1; i < n; i++) {
			maxEnd = Math.max(maxEnd + arr[i], arr[i]);
			
			res = Math.max(res, maxEnd);
		}
		
		System.out.println("The maximum contiguous subArray sum is : "+ res);
	}
	
	public static void minMaxSeries(int [] arr, int n) {
		//Given Sorted Array - O(n/2)
		int i = 0;
		while(i<n/2) {
			System.out.println(arr[i] + " " + arr[n]);
			i++;
			n--;
		}
	}
	
	public static void mergeSortedArray(int[] arr, int start, int end, int n1, int n2) {
		if(start >= end) {
			return;
		}
		int mid = start + (end - start)/2;
		mergeSortedArray(arr, start, mid, n1, n2);
		mergeSortedArray(arr, mid+1, end, n1, n2);
		merge(arr, start, mid, end);
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		for(int i=0;i<n1;i++) {
			arr1[i] = arr[i] ;
		}
		for(int i=0;i<n2;i++) {
			arr2[i] = arr[n1 + i] ;
		}
		System.out.println("First Sorted half");
		for(int i=0;i<n1;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("Second Sorted half");
		for(int i=0;i<n1;i++) {
			System.out.print(arr1[i] + " ");
		}
		for(int i=0;i<n2;i++) {
			System.out.print(arr1[n1 + i] + " ");
		}
		
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end + 1];
		int left =  start;
		int right = mid+1;
		int index = 0;
		while(left<=mid && right<=end) {
			if(arr[left]<=arr[right]) {
				temp[index] = arr[left];
				left ++;
				index ++;
			}
			else {
				temp[index] = arr[right];
				right++;
				index++;
			}
		}
		
		//Left over elements of left;
		while(left<=mid) {
			temp[index] = arr[left];
			index++;
			left++;
		}
		
		//Left over eleemts of right;
		while(right<=end) {
			temp[index] = arr[right];
			right++;
			right++;
		}
		
		//Copying back;
		index= 0;
		for(int i = start; i<=end;i++) {
			arr[i]=temp[index];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements :");
		int n=sc.nextInt();
		System.out.println("Enter the "+n+" elements :");
		int [] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter \n1 for q1, \n2 for q2 , \n3 for q3, \n4 for q4, \n5 for q5, \n6 for q6, \n7 for q7, \n8 for q8");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			sumOfNElements(arr, arr.length);
			break;
		case 2:
			minMax(arr, arr.length);
			break;
		case 3:
			findMissing(arr,arr.length);
			break;
		case 4:
			factorial(n);
			break;
			
		case 5:
			System.out.println("Enter number of places to rotate : ");
			int r= sc.nextInt();
			rotateArrayByRPlaces(arr,n, r);
			break;
		case 6:
			maximumContiguousSubArray(arr, n-1);
		default:
			System.out.println("Wrong Choice");
		}
	}

}
