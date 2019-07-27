package CS30;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

	final static int SIZE = 100;
	public static int digitFinder (int number, int placeValue)
	{
//		int modulus = 0;
		/*
		 * int [] manta = new int [2]; System.out.println("Number:" + number); for ( int
		 * i=0; i < (Math.log10(number) + 1); i++) {
		 * 
		 * System.out.println("number: " + number); modulus = number % 10; manta[i] =
		 * modulus; number = number/10;
		 * 
		 * System.out.print("Mod:" + modulus); System.out.println("\n"); }
		 */
		
		return (int) (number/(Math.pow(10, placeValue-1)) % 10); // number divided by 10 to the power of placeValue-1, then divided by 10, return modulus
	}
	public static void radixSort(int [] arr)
	{
		int modFront =0;
		int modBack =0;
		int temp = 0;

		for (int a=1; a < 4; a++) //three exponents 1-2-3
		{
			for ( int i=0; i < arr.length; i++)//outer comparison loop
			{
				
				for ( int x = i+1; x < arr.length; x++) //inner comparison loop
				{
					modFront = digitFinder(arr[i], a);
					modBack = digitFinder(arr[x], a);
					if ( modBack < modFront)
					{
							System.out.println("i:" + i + " x: " + x);
//							System.out.println("i-1: " + (int)(i-1));
//							System.out.println("Front: " + arr[i] + " Back:" + arr[x]);
							System.out.println(a + " -- Front: " + modFront + "/" + arr[i]+ " Back:" + modBack + "/" + arr[x]);
						temp = arr[i]; //swapping
						arr[i]= arr[x];
						arr[x] = temp;
//							System.out.println();
					}
				}
				display(arr);

			}
				System.out.println("_________________________________________________");
		}
	}
	public static void quickSort(int [] arr, int begin, int end)
	{
		/*int begin = arr[0];
		int end = arr[SIZE -1];*/
		int pivot = 0;
		int leftSlider = begin;
		int rightSlider = end;
		int temp =0;
		while(leftSlider != rightSlider)
		{				
//				System.out.println("QUICKSORT");
				while( arr[leftSlider] <= arr[pivot] && leftSlider < pivot)
				{
					/*
					if(arr[leftSlider] > arr[pivot] )
					{
						temp = arr[leftSlider];
						arr[leftSlider]= arr[pivot];
						arr[pivot]=temp;
						
					}*/
					leftSlider++;
				}						
				
				while ( arr[rightSlider] >= arr[pivot] && rightSlider > pivot)
					rightSlider--;
				System.out.println("Bigger: " + arr[leftSlider] + "  Smoler: " + arr[rightSlider]) ;
				temp = arr[leftSlider]; //swapping algorithm
				arr[leftSlider]= arr[rightSlider];
				arr[rightSlider]=temp;
				
				if ( leftSlider == pivot)
					pivot = rightSlider;
				else if ( rightSlider == pivot)
					pivot = leftSlider;
					
		}		
		
		System.out.println("QUICKSORT");
		display(arr);
		if (pivot - begin > 1)
			quickSort( arr, begin, pivot -1);
		else if (end - (pivot+1) > 1)
			quickSort(arr, pivot +1, end);
			
		display(arr);

	}
	public static void bubbleSort(int [] arr)
	{
		for ( int x = 0; x < SIZE-1; x++)
		{
			for ( int y = x+1; y < SIZE; y++)
			{
				if( arr[x] > arr[y] )
				{
					int temp = 0;
					temp = arr[y];
					arr[y] = arr[x];	
					arr[x] = temp;
				}
			}
		}		
	}
//	final static int SIZE = 100;
	public static void insertionSort(int [] arr)
	{
		int largest = 0;
		int smallest = 100;
		int x = -1; //initially plus 1 = 0;
		int [] manta = arr;
//		int largestAdd =0;
		int smallestAdd = 0;
//		System.out.println("");
		for (int a=0; a < arr.length; a++)
		{		
//			display(arr);
			display(manta);
			for ( int b = a; b < arr.length; b++) // run through array to find smallest
			{
				smallest = 100;
				System.out.println(arr[b]);
				if ( arr[b] < smallest) // find the smaller number
				{
					System.out.println(arr[b] +"<"+ smallest);					
					smallest = arr[b];	
					smallestAdd = b;
				}
			}
//			manta[x] = smallest;
//			smallest = arr[a];
			x++;	// x is the position of the smallest number in manta[]
			for (int c= smallestAdd-1; c >= x; c--) { //shuffling!
				arr[c] = manta[c+1]; //move over
				manta[x] = smallest; //insert
			}
			display(manta);
		}
		
		
	}
	public static void selectionSort(int [] arr)
	{
		int largest = 0;
		int smallest = arr[0];
		int temp =0;
		int largestAdd =0;
		int smallestAdd = 0;
		for (int a=0; a < arr.length; a++)//starting @ arr[0]
		{
			/*largestAdd =a+1;
			smallestAdd =a+1;*/
			largest = 0;
			smallest = arr[a];
			for (int b= a+1; b < arr.length; b++) //starting @arr[i+1]
			{
				if (arr[b] > largest) //find biggest number
				{
					largest = arr[b];
					largestAdd = b;
				}
					
				if (arr[b] < smallest)
				{
					smallest = arr[b]; // find smallest number	
					smallestAdd = b;
				}
/*				System.out.println("Largest:"+ largest );
				System.out.println("Smallest:" + smallest);
*/				
						
			}
			temp =arr[a] ;
			arr[a] =smallest;
			arr[smallestAdd] = temp;
//			display (arr);	
			temp = arr[largestAdd];
			arr[arr.length -1] = largest;
			arr[largestAdd] = temp;
			
		}
	}
	public static void binarySearch(int [] arr)
	{
		Scanner input = new Scanner (System.in);
		bubbleSort(arr);
		int min = arr[0];
		int max = arr[99];
		int find = 0;
		
		System.out.println("Insert number you want to find:");
		find = input.nextInt();
		
		for (int i = 0; i < arr.length; i++)
		{
//			System.out.println(arr[i]);
//			System.out.println("tester");
			int average = (max + min)/2;
			if(average < find)
				min = average;
			else if (average > find)
				max = average;
//			System.out.println("Max:" + max +"--"+ "Min" + min);
			if (average == find)
			{
				System.out.println("The number is at: " + i);
				break;
			}
			if( i== arr.length && find != 100)
				System.out.println("Number does not exist in array");
				
		}		
	}
	public static void display(int [] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] sort (int[] arr)
	{
		int[] sortedArr = arr;
		Arrays.sort(sortedArr);
		return sortedArr;
	}
	
	public static void shuffle (int[] arr)
	{
//		Arrays.asList(arr);
//		Collections.shuffle(arr); // does not work - cannot resolve type
		int temp = 0;
		
		for (int x = 0; x< 100; x++)
		{
			int randElement = (int)(Math.random()* arr.length);
			temp = arr[x];
			arr[x] = arr[randElement];
			arr[randElement] = temp;	
		}
	}

	public static void findNumber ( int go, int[] arr)
	{
		Scanner input = new Scanner (System.in);
//		boolean found = false; //if found or not
		int find = 0;
		int replace= 0;
		int counter =0;
		System.out.println("Insert the number you want to find:");
		find = input.nextInt(); // number to find
		if(go ==11)//replace method
		{
			System.out.println("The number you want to replace with:");
			replace = input.nextInt();
		}
		
		for ( int i =0; i < arr.length; i++) // shouldn't it be <= because there exists arr[SIZE]
		{
			if(arr[i]== find && go ==5) //found the number
			{
				System.out.println("First occurence is " + i);
				break;
			}
			if( arr[i] == find && go ==11)
				arr[i]=replace;
			else if (go ==5 && i == 98) //(found = false ) // not found - not in scope to change boolean
				System.out.println("First occurence is -1" );
			if(arr[i]== find && go == 10)
				counter++;
		}
		if(go ==10)
			System.out.println("Number of occurence(s): " + counter);
	}	
	public static boolean ascend(int go, int [] arr)
	{
		int[] ascArr = new int[arr.length];
		int counter = 0;
		boolean comparing = false;
		for (int i =0;  i < arr.length ; i++)
			ascArr[i] = arr[i];
		Arrays.sort(ascArr);	//refer to sort method
		for (int i =0;  i < arr.length ; i++)	
		{
			if(ascArr[i] != arr[i])
			{
				if (go ==6)
					System.out.println("Not ascending");
				comparing = false;
				break;// when found first unmatch, immediately break off to sop
			}
			else if (ascArr[i]== arr[i])
			{
				counter++;
				comparing = true;
			}
//			System.out.println(counter);
			if (counter == arr.length && go ==6)//all SIZE match
				System.out.println("Ascending");
		}
		return comparing;
	}	
	public static void rank(int go, int [] arr, int SIZE) //highest lowest number
	{
		int [] ascArr = new int[SIZE];
		for (int i =0;  i < arr.length ; i++)
			ascArr[i] = arr[i];
		Arrays.sort(ascArr);	//refer to sort method
		if (go == 8)
			System.out.println("The lowest number is " + ascArr[0]);
		if (go == 9)
			System.out.println("The highest number is " + ascArr[SIZE]);
	}
	
	public static void untilAscending (int go, int[] arr)
	{
		boolean comparing = ascend(go, arr);
		int counter = 0;
		int[] sortedArr = sort(arr);
		
		if (comparing == true)// if array is already in order
			System.out.println("Array is already ascending - no shuffling neeeded");
		while (counter < 10000 && comparing ==false)
		{	
			
			for (int i =0;  i < arr.length-1 ; i++)
			{
				shuffle(arr);
				if(arr[i] > arr[i+1]) //comparing 2 consecutive number
				{
					comparing = false;
					counter++;
					break;
				}	
			}
		}			
		System.out.println("Number of suffling done:" + counter);
	}
	public static void replace(int go ,int[] arr)
	{	
		findNumber(go, arr);
	}
	public static void sum(int go ,int[] arr)
	{	
		int sum=0;
		int address = 0;
		for (int i =0;  i < arr.length-10 ; i++)// -10 or else out of bound
		{
			int temp=0;
			temp = arr[i]+ arr[i+1]+ arr[i+2]+ arr[i+3]+ arr[i+4]+ arr[i+5]+arr[i+6]+ arr[i+7]+ arr[i+8]+ arr[i+9]; //adding 10 consecutive
			if(temp>sum)
			{
				sum= temp;
				address = i;
			}
				
		}
		System.out.println("The biggest sum is " + sum + " starting at address " + address);
	}
	
	public static void main(String[] args) //MAIN
	{
		final int SIZE = 100;
		int max = 200;
		int min = 0;
		int [] arr = new int [SIZE];
		Scanner input = new Scanner (System.in);
		int go =0;
		
		do //main loop
		{
			// instructions
			System.out.println("\n" + "0: exit program" + "\n" + "1: populate array randomly" + "\n" +"2: populate array sequentially");
			System.out.println("3: display array"+"\n"+ "4: shuffle array" + "\n"+ "5: Find first occurence of number");
			System.out.println("6: check to see if the list is in ascending order"+ "\n" + "7: shuffle list until it is in ascending order - or 10000 times");
			System.out.println("8: print lowest value"+ "\n" + "9: print highest value" + "\n" + "10: Number of occurences of inserted number");
			System.out.println("11: Replace numbers"+ "\n" + "12: Greatest sum of 10 consecutive number");
			System.out.println("13: Binary Search"+ "\n" + "14: Selection Sort");
			System.out.println("15: Insertion Sort" + "\n" + "16: Quick Sort" + "\n" + "17: Radix Sort");
			go = input.nextInt();
			if (go == 1) //populate
			{
				for (int x=0; x <SIZE ; x++)
					arr[x] = (int)(Math.random()*(max-min +1)+ min);
			}
			else if (go == 2) //sequential
				arr = sort(arr); 
			else if (go == 3) //display
				display(arr);
			else if (go == 4) //shuffle existed or create new array
				shuffle(arr);
			else if (go == 5)//first occurence
				findNumber(go,arr);
			else if (go ==6) //compare
				ascend(go, arr);
			else if(go==7) //shuffle until ascend or 10 000
				untilAscending(go, arr);
			else if (go ==8)//lowest value
				rank(go,arr,SIZE);
			else if (go ==9)//highest value
				rank(go,arr,SIZE);
			else if (go == 10)//number of occurences
				findNumber(go,arr);
			else if ( go ==11)//replace number
				findNumber(go,arr);
			else if (go == 12)//highest sum of 10
				sum (go, arr);
			else if (go == 13)
				binarySearch(arr);
			else if (go == 14)
				selectionSort(arr);
			else if (go == 15)
				insertionSort(arr);
			else if (go == 16)
				quickSort(arr, 0, SIZE-1);
			else if (go == 17)
				radixSort(arr);

		} while (go != 0);
		System.out.println("Thank you for using the UI menu."); //exited
		input.close();
		
//		binarySearch(arr);
	}


}
