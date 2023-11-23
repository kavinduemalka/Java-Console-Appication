import java.util.Scanner;

class Main{
    static Scanner sc = new Scanner(System.in);
    
    public static void BubbleSortTotal(Student[] arr, int number){
        int n = number;
        boolean swapped;
        for(int i = 0; i<n-1; i++){
            swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if (arr[j].Total < arr[j+1].Total){
                    Student temp = arr [j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void BubbleSortPFMarks(Student[] arr, int number){
        int n = number;
        boolean swapped;
        for(int i = 0; i<n-1; i++){
            swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if (arr[j].PFmarks < arr[j+1].PFmarks){
                    Student temp = arr [j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void BubbleSortDBMarks(Student[] arr, int number){
        int n = number;
        boolean swapped;
        for(int i = 0; i<n-1; i++){
            swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if (arr[j].DBmarks < arr[j+1].DBmarks){
                    Student temp = arr [j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Student [] starray = new Student [10];
        int count = 0;
        while (true) {
            System.out.println("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
            System.out.println("[1] Add New Student                             [2] Add New Student With Marks");
            System.out.println("[3] Add Marks                                   [4] Update Student Details");
            System.out.println("[5] Update Marks                                [6] Delete Student");
            System.out.println("[7] Print Student Details                       [8] Print Student Ranks");
            System.out.println("[9] Best in Programming Fundamentals            [10] Best in Database Management System");
            System.out.print("Enter an option to continue > ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1){
                while(true){
                    System.out.println("ADD NEW STUDENT");
                    System.out.print("Enter Student ID    : ");
                    String id = sc.nextLine();
                    System.out.print("Enter Student Name    : ");
                    String name = sc.nextLine();
                    boolean existStud = false;

                    for (int i = 0; i < count; i++){
                        if (starray[i].id.equals(id)){
                            System.out.println("The entered student already exists");
                            existStud = true;
                        }
                    }
                    if(existStud == false){
                        Student st = new Student (id, name,0,0);
                        starray[count]= st ;
                        count++;
                        System.out.print("Student has been added successfully.Do you want to add a new student (Y/n) : " );
                        String check = sc.nextLine();
                        if (check.equals("n")){
                            break;
                        }
                    }
                }
            }

            else if (option == 2) {
                while (true) {
                    System.out.println("ADD NEW STUDENT WITH MARKS");
                    System.out.print("Enter Student ID    : ");
                    String id = sc.nextLine();
                    System.out.print("Enter Student Name    : ");
                    String name = sc.nextLine();
            
                    System.out.print("Programming Fundamental Marks   : ");
                    double PFmarks = sc.nextDouble();
                    if (PFmarks < 0 || PFmarks > 100) {
                        System.out.println("Invalid marks. Please enter correct marks.");
                        sc.nextLine(); // Consume the newline character
                        continue;  // Skip the rest of the loop and start a new iteration
                    }
            
                    System.out.print("Database Management Marks   : ");
                    double DBmarks = sc.nextDouble();
                    if (DBmarks < 0 || DBmarks > 100) {
                        System.out.println("Invalid marks. Please enter correct marks.");
                        sc.nextLine(); // Consume the newline character
                        continue;  // Skip the rest of the loop and start a new iteration
                    }
            
                    // Check if the student already exists before adding
                    boolean existStud = false;
                    for (int i = 0; i < count; i++) {
                        if (starray[i] != null && starray[i].id.equals(id)) {
                            existStud = true;
                            System.out.println("Student with ID " + id + " already exists. Please enter a different ID.");
                            break;
                        }
                    }
            
                    String check = "Y";
                    if (!existStud) {
                        Student st = new Student(id, name, PFmarks, DBmarks);
                        starray[count] = st;
                        count++;
                        System.out.print("Student has been added successfully. Do you want to add a new student (Y/n)");
                        check = sc.nextLine();
                        sc.nextLine();
                        if (check.equals("n")) {
                            break;
                        }
                    }
                }
            }
            
            else if(option == 3){
                while (true){
                System.out.println("ADD MARKS");
                System.out.print("Enter Student ID    : ");
                String id = sc.nextLine();
                System.out.print("Enter Student Name    : ");
                String name = sc.nextLine();
                boolean existStud = false;
                for (int i = 0; i < count; i++){
                    if (starray[i].id.equals(id)){
                        existStud = true;
                        System.out.print("Programming Fundemental Marks   : ");
                        double PFmarks = sc.nextDouble();
                        System.out.print("Database Management Marks   : ");
                        double DBmarks = sc.nextDouble();
                        Student st = new Student(id, name, PFmarks, DBmarks);
                        starray[i] = st;
                    }
                }
                if(existStud == false){
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n)");
                        String check = sc.nextLine();
                        sc.nextLine();
                        if (check.equals("n")) {
                            break;
                        }
                    }    
            }
        }

            else if(option == 4){
                System.out.println("UPDATE STUDENT DETAILS");
                System.out.print("Enter Student ID    : ");
                String id = sc.nextLine();
                boolean existStud = false;
                for (int i = 0; i < count; i++){
                    if (starray[i].id.equals(id)){
                        existStud = true;
                        System.out.print("Enter Student Name    : ");
                        String name = sc.nextLine();
                        Student st = new Student(id, name,0,0);
                        starray[i] = st;
                        System.out.println("Student details have been updated successfully.");
                    }
                }
                if (existStud== false){
                    System.out.println("Invalid student ID. Do you want to search again ?");
                }

            }

            else if(option == 5){
                System.out.println("UPDATE MARKS");
                System.out.print("Enter Student ID    : ");
                String id = sc.nextLine();
                boolean existStud = false;
                for (int i = 0; i < count; i++){
                    if (starray[i].id.equals(id)){
                        existStud = true;
                        System.out.print("Enter Student Name    : ");
                        String name = sc.nextLine();
                        System.out.print("Programming Fundemental Marks   : ");
                        double PFmarks = sc.nextDouble();
                        System.out.print("Database Management Marks   : ");
                        double DBmarks = sc.nextDouble();
                        Student st = new Student(id, name, PFmarks, DBmarks);
                        starray[i] = st;
                        System.out.println("Marks have been updated successfully.");
                        System.out.println("Do you want to update marks for another student ? ");
                    }
                }
                 if (existStud== false){
                    System.out.println("Invalid student ID. Do you want to search again ?");
                 }
                }

                else if(option == 6){
                      System.out.println("DELETE STUDENT");    
                      System.out.println("Enter student id"); 
                      String id = sc.nextLine();
                      boolean existStud = false;
                      for (int i = 0; i < count; i++){
                        if (starray[i].id.equals(id)){
                            existStud = true;
                            int Dlt = i;
                            for (int j = Dlt ; j < count; j++){
                                starray[j] = starray[j+1];
                            }
                            System.out.println("Student has been deleted successfully.");
                            System.out.println("Do you want to delete another student ? (Y/n) ");
                            count--;
                    }else {
                        System.out.println("Invalid student ID. Do you want to search again ?");
                    }
                    }
                }
    
            else if(option == 7){
                System.out.println("PRINT STUDENT DETAILS");
                System.out.print("Enter Student ID    : ");
                String id = sc.nextLine();
                System.out.print("Enter Student Name    : ");
                String name = sc.nextLine();
                boolean existStud = false;
                for (int i = 0; i < count ; i++ ){
                    if (starray[i].id.equals(id) && starray[i].name.equals(name)){
                        existStud = true;
                        if (starray[i].DBmarks==0  && starray[i].PFmarks==0){
                            System.out.println("Marks yet to be added");
                            System.out.println("Do you want to search another student details ? (Y/n)" );
                        }
                        else {
                            System.out.println("Programming Fundamental Marks     "+ starray[i].PFmarks);
                            System.out.println("Database Management Marks         "+ starray[i].DBmarks);
                            Double Total = starray[i].PFmarks + starray[i].DBmarks ;
                            System.out.println("Total Marks                       "+ Total);
                            Double Avg = Total/2;
                            System.out.println("Avg. Marks                        "+Avg);
                        }
                }
                }
            }   
            else if (option == 8){
                System.out.println("PRINT STUDENT RANKS"); 
                BubbleSortTotal(starray, count);
                for (int i = 0; i < count; i++){
                    System.out.println(i+1 + "  " + starray[i].id + "  "+ starray[i].name + "  "+ starray[i].Total + "  "+ starray[i].Total/2);
                }
            }
            else if (option == 9){
                System.out.println("BEST IN PROGRAMMING FUNDAMENTALS");
                BubbleSortPFMarks(starray, count);
                for (int i = 0; i < count; i++){
                    System.out.println(starray[i].id + "  "+ starray[i].name + "  "+ starray[i].PFmarks + "  "+ starray[i].DBmarks);
                }    
            } 

            else if (option == 10){
                System.out.println("BEST IN DATABASE MANAGEMENT SYSTEM");
                BubbleSortDBMarks(starray, count);
                for (int i = 0; i < count; i++){
                    System.out.println(starray[i].id + "  "+ starray[i].name + "  "+ starray[i].PFmarks + "  "+ starray[i].DBmarks);
                }    
            } 

            else if(option == 11){
                for (int i = 0; i < count; i++){
                    System.out.println(starray[i].id + "  "+ starray[i].name + "  "+ starray[i].PFmarks + "  "+ starray[i].DBmarks);
                } 
            }


        }
    }
}
    
    
