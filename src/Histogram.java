
import java.util.Scanner;


public class Histogram {

    public static void main(String[] args) {
    
        Scanner keyboard = new Scanner(System.in);
        
        int grade = 0, number0to29 = 0, number30to39 = 0, number40to69 = 0, number70to100 = 0, 
            highestGrade, lowestGrade ;
        
        boolean acceptableInput = false ;
        
        float average, numberOfStudents, total, passes;
        
        numberOfStudents = 0 ;
        total = 0 ;
        passes = 0 ;
        
        // asks the user to enter grades and takes the line entered as a string
        System.out.println("Enter Grades:");
        String input = keyboard.nextLine();
        
        // boolean acceptable is declared as false so the program will check
        // the input using a try catch (then if it works, an if to check - vs +)
        // until the result comes back valid (any positive integer)
        while (!acceptableInput)
        {
            try 
            {
                grade = Integer.parseInt(input);
                acceptableInput = true ;
            }
            catch (NumberFormatException e) 
            {
                System.out.println("Note that \"" + input + "\" is invalid and will not be counted.");
                input = keyboard.nextLine();
            }
            
            if (acceptableInput && grade < 0)
            {    
                acceptableInput = false ;
                System.out.println("Note that \"" + input + "\" is invalid and will not be counted.");
                input = keyboard.nextLine();
            }
        }
        
        // until more is inputted, the first grade will be the highest and lowest
        lowestGrade = grade ;
        highestGrade = grade ;
                
        // until the expception is entered (any grade over 100)
        while (grade < 101)
        {
            // adds one to the correct category for each grade
            if (grade >= 70) number70to100 += 1 ;
            else if (grade >= 40) number40to69 += 1 ;
            else if (grade >= 30) number30to39 += 1 ;
            else number0to29 += 1 ;
            
            // for extra statistics
            numberOfStudents += 1 ;
            total += grade ;        
            
            if (grade >= 40) passes += 1 ;
            
            if (grade > highestGrade) highestGrade = grade ;
            if (grade < lowestGrade) lowestGrade = grade ;
            
            // asks for new input - acceptable input is reset to false to check validity
            acceptableInput = false ;
            input = keyboard.nextLine();
            
            while (!acceptableInput)
            {
                try 
                {
                    grade = Integer.parseInt(input);
                    acceptableInput = true ;
                }
                catch (NumberFormatException e) 
                {
                    System.out.println("Note that \"" + input + "\" is invalid and will not be counted.");
                    input = keyboard.nextLine();
                }

                if (acceptableInput && grade < 0)
                {    
                    acceptableInput = false ;
                    System.out.println("Note that \"" + input + "\" is invalid and will not be counted.");
                    input = keyboard.nextLine();
                }
            }   
        }
        
        System.out.print("\n"); //formatting
        
        // prints out the horizontal histogram when the user is done inputting
        
        int x = 0; 
        
        System.out.print("00 - 29 : ");
        
            while (x < number0to29)
            {
                System.out.print("* ");
                x += 1;
            }
            
            x = 0; 
            System.out.print("\n"); //formatting
            
        System.out.print("30 - 39 : ");
        
            while (x < number30to39)
            {
                System.out.print("* ");
                x += 1;
            }  
            
            x = 0; 
            System.out.print("\n"); //formatting

        System.out.print("40 - 69 : ");
        
            while (x < number40to69)
            {
                System.out.print("* ");
                x += 1;
            }  
            
            x = 0; 
            System.out.print("\n"); //formatting
        
        System.out.print("70 - 100: ");
        
            while (x < number70to100)
            {
                System.out.print("* ");
                x += 1;
            }      
            
            System.out.println("\n"); //formatting
            
        // prints out additional statistics
            
        average = total / numberOfStudents ; 
        
        System.out.print("Number of inputted grades: "); 
        System.out.printf("%.0f", numberOfStudents);
        System.out.print("\n" + "Number of passing grades: "); // \n is formatting
        System.out.printf("%.0f", passes);
        System.out.println("\n" + "Highest: " + highestGrade); // \n is formatting
        System.out.println("Lowest: " + lowestGrade);
        System.out.print("Average: ");
        System.out.printf("%.2f", average);
           
        // pints out the addition, vertical, histogram
        
        System.out.println("\n");
        System.out.println("00 - 29     30 - 39     40 - 69     70 - 100");
       
        while (number70to100 > 0 || number40to69 > 0 || number30to39 > 0 || number0to29 > 0)
        {
            System.out.print("   ");

                if (number0to29 > 0)
                {
                    System.out.print("*");
                    number0to29 -= 1;
                }
                else
                    System.out.print(" ");
            
            System.out.print("           ");
            
                if (number30to39 > 0)
                {
                    System.out.print("*");
                    number30to39 -= 1;
                }
                else
                    System.out.print(" ");
            
            System.out.print("           ");
            
                if (number40to69 > 0)
                {
                    System.out.print("*");
                    number40to69 -= 1;
                }
                else
                    System.out.print(" ");
            
            System.out.print("           ");
            
                if (number70to100 > 0)
                {
                    System.out.print("*");
                    number70to100 -= 1;
                }
                else
                    System.out.print(" ");
            
            System.out.print("\n");
        }
        
    }
    
}
