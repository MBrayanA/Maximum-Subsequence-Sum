/*
This java program correctly solves the maximum subsequence sum problem through five different approaches
consequently having different time complexities for each approach. 
*/


import java.util.Scanner;
import java.io.*;

public class maximum_subsequence_sum{
        public static int MSS1(int[] a) {  //O(n^3)
                int maxSum = 0;
                for (int i = 0; i < a.length; i++) {
                        for (int j = i; j < a.length; j++) {
                                int sum = 0;
                                for (int k = i; k < j + 1; k++) {
                                        sum += a[k];  //adds the numbers in the array
                                        if(sum > maxSum) {
                                                maxSum = sum; //replaces the maxSum with sum if the sum is larger
                                        }
                                }

                        }
                }
                return maxSum;
        }
        public static int MSS2(int[] a) {  //O(n^2)
                int maxSum = 0;
                for (int i = 0; i < a.length; i++) {
                        int sum = 0;
                        for (int j = i; j < a.length; j++) {
                                sum += a[j];  //adds the numbers in the array
                                if (sum > maxSum) {
                                        maxSum = sum;  //replaces the maxSum with sum if the sum is larger
                                }
                        }
                }
                return maxSum;
        }
        public static int MSS3(int[] a, int low, int high) { //O(log2n^2)
            int maxSum;
            int maxLeftSum = 0;
            int maxRightSum = 0;
            int mid = (low + high)/2;  //finds the midpoint
            int sum = 0;

            if(low == high) {
                    return a[0];  //if the low and high are the same then it returns the first element in the array

            }
            for (int i = mid; i>= low; i--) {
                    sum += a[i];  //adds the numbers in the array

                    if (sum > maxLeftSum) {
                            maxLeftSum = sum;  //replaces maxLeftSum with sum if sum is greater than maxLeftSum
                    }
            }
            sum = 0;

            for(int j = mid +1; j < high; j++) {
                    sum += a[j];  //adds the numbers in the array
                    if (sum> maxRightSum) {
                            maxRightSum = sum;  //replaces maxRightSum with sum if sum is greater than maxRightSum

                    }
            }

            maxSum = Math.max((maxLeftSum + maxRightSum), Math.max(maxLeftSum,  maxRightSum));  //use math.max() function to compare the max of total array

            return Math.max(Math.max(MSS3(a, low, mid), MSS3(a, mid+1,high)), maxSum);


    }


    public static int MSS4(int[] a) {  //O(n)
        int maxSum = 0;
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
                sum += a[j];  //adds the numbers in the array
                if (sum > maxSum) {
                        maxSum = sum;  //replaces maxSum with sum if sum is greater than maxSum
                } else {
                        if (sum < 0) {
                                sum = 0;  //if the sum is less than zero then the sum is zero so it isn't a negative number
                        }
                }
        }
        return maxSum;
}



public static void main(String[] args) {
        boolean valid;
        String again_answer;
        boolean again = true;

        Scanner in = new Scanner(System.in);

        //initializes the start and end times for all of the algorithms
        long start_time_1;
        long start_time_2;
        long start_time_3;
        long start_time_4;
        long end_time_1;
        long end_time_2;
        long end_time_3;
        long end_time_4;

        while (again) {  //for running again
                try {
                        System.out.println("Please enter a filename");
                String inFilename = in.nextLine();  //saves the filename
                String answer;
                        BufferedReader reader = new BufferedReader(new FileReader(inFilename));  //opens the file
                        String line = reader.readLine();
                        String[] input_array = line.split(",");  //splits the string array
                        int[] a = new int[input_array.length];
                        for (int i = 0; i < input_array.length; i++) {
                                a[i] = Integer.parseInt(input_array[i]);  //creates an int array with the string numbers in the previous array
                        }


                                //prints different types algorithms to run or run all of them
                                System.out.println("Which would you like to run?");
                                System.out.println("(1) O(n^3)");
                                System.out.println("(2) O(n^2)");
                                System.out.println("(3) O(n*log(n))");
                                System.out.println("(4) O(n)");
                                System.out.println("(5) all algorithms");
        
                                answer = in.nextLine();
        
                                if (answer.equals("1")) {
                                        start_time_1 = System.nanoTime();  //gets the start nanoTime for this algorithm
                                        int MSS_1 = MSS1(a);
                                        end_time_1 = System.nanoTime();  //gets the end nanoTime for this algorithm
                                        System.out.println("Alogirthm 1: MSS is " + MSS_1 + ": Runtime is " + ((end_time_1 - start_time_1) * 0.000001) + " milli-seconds");  //turns nano into milli prints it along with maxSum                     
                                } else if (answer.equals("2")) {
                                        start_time_2 = System.nanoTime();  
                                        int MSS_2 = MSS2(a);
                                        end_time_2 = System.nanoTime();  
                                        System.out.println("Alogirthm 2: MSS is " + MSS_2 + ": Runtime is " + ((end_time_2 - start_time_2) * 0.000001) + " milli-seconds");                
                                } else if (answer.equals("3")) {
                                        start_time_3 = System.nanoTime();  
                                        int MSS_3 = MSS3(a, 0, a.length);
                                        end_time_3 = System.nanoTime(); 
                                        System.out.println("Alogirthm 3: MSS is " + MSS_3 + ": Runtime is " + (end_time_3 - start_time_3) + " nano-seconds");  
                                } else if (answer.equals("4")) {
                                        start_time_4 = System.nanoTime();  
                                        int MSS_4 = MSS4(a);
                                        end_time_4 = System.nanoTime();  
                                        System.out.println("Alogirthm 4: MSS is " + MSS_4 + ": Runtime is " + (end_time_4 - start_time_4) + " nano-seconds");  
                                } else if(answer.equals("5")) {
                                        start_time_1 = System.nanoTime();  
                                        int MSS_1 = MSS1(a);
                                        end_time_1 = System.nanoTime();  
                                        System.out.println("Alogirthm 1: MSS1 is " + MSS_1 + ": Runtime is " + ((end_time_1 - start_time_1) * 0.000001) + " milli-seconds");  
        
                                        start_time_2 = System.nanoTime();  
                                        int MSS_2 = MSS2(a);
                                        end_time_2 = System.nanoTime();  
                                        System.out.println("Alogirthm 2: MSS2 is " + MSS_2 + ": Runtime is " + ((end_time_2 - start_time_2) * 0.000001) + " milli-seconds");  
        
                                        start_time_3 = System.nanoTime();  
                                        int MSS_3 = MSS3(a, 0, a.length);
                                        end_time_3 = System.nanoTime();
                                        System.out.println("Alogirthm 3: MSS3 is " + MSS_3 + ": Runtime is " + (end_time_3 - start_time_3) + " nano-seconds");  
        
                                        start_time_4 = System.nanoTime();  
                                        int MSS_4 = MSS4(a);
                                        end_time_4 = System.nanoTime();  
                                        System.out.println("Alogirthm 4: MSS4 is " + MSS_4 + ": Runtime is " + (end_time_4- start_time_4) + " nano-seconds"); 
        
        
                                }
                            } catch (FileNotFoundException e) {  //prints an error message and stops the program if there is a FileNotFoundException
                                System.out.println(e.getMessage());
                                System.exit(1);
                        } catch (IOException e) {  //prints an error message and stops the program if there is a IOException
                                System.out.println(e.getMessage());
                                System.exit(0);
                        }
                        valid = false;
                        while(!valid) {  //asks if they want to run again
                                System.out.println("Do you wannt run the program again(y/n)");
                                again_answer = in.nextLine();
                                if (again_answer.equalsIgnoreCase("y")) {
                                        valid = true;
                                } else if (again_answer.equalsIgnoreCase("n")) {
                                        again = false;
                                        valid = true;
                                }
                        }
                }
        }
}
        