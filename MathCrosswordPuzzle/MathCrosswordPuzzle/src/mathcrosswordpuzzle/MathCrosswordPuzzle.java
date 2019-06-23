
package mathcrosswordpuzzle;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
                    Palestine Polytechnic University -PPU-
               College of Information Technology and Computer Engineering
                    Object-Oriented Programming -OOP-

structured programming using Java language.

    Math crossword puzzle:

        Group Work : 

            -Name : Mohammed Samaheen       	 ID: 171004
            -Name : Abd-el Khaleq O Juniedi 	 ID: 171019

Important Notes :

    - In order to avoid " Error " preferably used NetBeans because of
        "cls()" metode as will as java does not have something like 
        System("cls") in c/c++ to clear the java-NetBeans console
        so we create an metode that do the same function that clear 
        the java-NetBeans console.
        pressbot on Holds CTRL key. then Holds L key. so if you pres 
        right click on the console you will see there are a clear  ctrl + L.
        
    -If you want to create new or special form of Math Crossword Puzzle
        just add it in mission file.
        
    -In every new Math Crossword Puzzle we create a
            
        -Random form of Math Crossword Puzzle.
        -Random operation Form.
        -Random operant.

     -This is not a optimal solution because of it does not takes care
        of OOP or CP 
        

*/

public class MathCrosswordPuzzle {

     static int [][] boolArr =new int[9][9];
     static double [][] userArray =new double[9][9];
     static  String [][] userStringArray =new String [9][9];
     static ArrayList<ArrayList<Integer> > equation =new ArrayList<>();
     static Random rand =new Random();
    
    
    public static void main(String[] args) throws  AWTException {
        
       
        
        
        Scanner scan ;
        scan=new Scanner(System.in);
        String answer;
        welcome();
        answer=scan.next();
        clear();
        if(answer.charAt(0)=='Y') {
            cls();
            createPuzzle();
                userOutput(0);
                userOutput(1);
                int choice=scan.nextInt();
            while (true) {                
            
                up:

                switch (choice) {
                    case 1:
                        cls();
                        solutionPuzzle();
                        userOutput(0);
                        System.out.println("do you want to create new Puzzle[Y,N]: ");
                        answer=scan.next();
                        if(answer.charAt(0)=='Y'){
                            choice=4;
                            break up;
                            
                        }
                        else
                            System.exit(0);
                        break;
                    case 2:
                        System.out.println("\nstart your solved from :"
                                +userStringArray[equation.get(0).get(2)][equation.get(0).get(3)]+" "+
                                userStringArray[equation.get(0).get(6)][equation.get(0).get(7)]+" "+
                                userStringArray[equation.get(0).get(0)][equation.get(0).get(1)]+" "+
                                userStringArray[equation.get(0).get(8)][equation.get(0).get(9)]+" "+
                                userStringArray[equation.get(0).get(4)][equation.get(0).get(5)]+" "
                        );
                        System.out.print("Enter your choice :");
                        
                        choice=scan.nextInt();
                        
                        break up;
                    case 3:
                        System.out.print("Enter the indecies of the cell you want to fill in your answer: ");
                        int valueX,valueY;
                        valueX=scan.nextInt();
                        valueY=scan.nextInt();
                        if(boolArr[valueX][valueY]==1)
                        {
                            System.out.print("\n Enter your value: ");
                           double userValue=scan.nextDouble();
                           userStringArray[valueX][valueY]=Double.toString(userValue);
                            cls();
                            userOutput(0);
                            userOutput(1);
                            choice=scan.nextInt();
                           
                        }
                        else 
                        {   
                            cls();
                            userOutput(0);
                            System.out.println("You can not filled this cell [ already filled ]... fill another one.");
                            
                            break up;
                            
                        }
                        break;
                    case 4:
                        cls();
                        clear();
                        createPuzzle();
                        userOutput(0);
                        userOutput(1);
                        choice=scan.nextInt();
                        
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Man I'm done with your jokes just enter what I printed for you to enter!!!");
                        break;
                }
            
            }
        } 
        else
            System.exit(0);
        
     
    }
    
    public static void createPuzzle(){
        int puzzleF =rand.nextInt(3)+1;
        String puzzleFile="src\\mathcrosswordpuzzle\\mission\\CrosswordPuzzleForm"+Integer.toString(puzzleF);
        File puzzleData ;
        puzzleData = new File(puzzleFile);
        try {
            
            Scanner scan =new Scanner(puzzleData);
            int equationNum;
            int randNum;
            equationNum=scan.nextInt();
            
            for (int i = 0; i < equationNum; i++)
            {
               equation.add(new ArrayList<>(11));
                randNum=scan.nextInt();
                int c1,c2,index1,index2;
                c1=rand.nextInt(34)+1;
                c2=rand.nextInt(4)+1;
                
                
                index1=scan.nextInt();
                index2=scan.nextInt();
                equation.get(i).add(index1);
                equation.get(i).add(index2);
                boolArr[index1][index2]=1;
                userStringArray[index1][index2]=" ";
                
                index1=scan.nextInt();
                index2=scan.nextInt();
                equation.get(i).add(index1);
                equation.get(i).add(index2);
                switch (randNum) {
                    case 2:
                        userArray[index1][index2]=c1;
                        userStringArray[index1][index2]=Integer.toString(c1);
                        index1=scan.nextInt();
                        index2=scan.nextInt();
                        equation.get(i).add(index1);
                        equation.get(i).add(index2);
                        userArray[index1][index2]=c1*c2;
                        userStringArray[index1][index2]=Integer.toString(c1*c2);
                        break;
                    case 1:
                        
                        boolArr[index1][index2]=1;
                        userStringArray[index1][index2]=" ";
                        index1=scan.nextInt();
                        index2=scan.nextInt();
                        equation.get(i).add(index1);
                        equation.get(i).add(index2);
                        userArray[index1][index2]=c1;
                        userStringArray[index1][index2]=Integer.toString(c1);
                       
                        break;
                    default:
                        boolArr[index1][index2]=1;
                        userStringArray[index1][index2]=" ";
                        index1=scan.nextInt();
                        index2=scan.nextInt();
                        equation.get(i).add(index1);
                        equation.get(i).add(index2);
                        boolArr[index1][index2]=1;
                        userStringArray[index1][index2]=" ";
                        break;
                }
                int operation =rand.nextInt(4);
                index1=scan.nextInt();
                index2=scan.nextInt();
                
                equation.get(i).add(index1);
                equation.get(i).add(index2);
                userArray[index1][index2]=operation;
                userStringArray[index1][index2]=operationForm(operation);
                
                index1=scan.nextInt();
                index2=scan.nextInt();
                equation.get(i).add(index1);
                equation.get(i).add(index2);
                userStringArray[index1][index2]="=";
                
            }
            
            
            scan.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MathCrosswordPuzzle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Enstalling : CrosswordPuzzleForm.txt does not found");
        }
          
    }
    public static String operationForm(int x){
        switch (x) {
            case 3:
                return "/ ";
            case 2:
                return "x ";
            case 1:
                return "- ";
            default:
                return "+ ";
        }
    }
    
    public static boolean floodFill(int x1,int y1,int x2,int y2){
         
                return !(((x2==x1)&&(y2==y1-1))||((x2==x1-1)&&(y1==y2)));
           
        
      
    }
    public static void clear(){
        for (int i = 0; i < 9; i++) {           
            Arrays.fill(boolArr[i], 0, 9, 0);
            Arrays.fill(userStringArray[i],0,9,"#");
            Arrays.fill(userArray[i], 0, 9, 0.0);
            
        }
        equation.clear();
    }
    public static void solutionPuzzle()
    {
        for (int i = 0; i < equation.size(); i++) 
        {
            boolean isReverse=floodFill(equation.get(i).get(0), equation.get(i).get(1),
                                        equation.get(i).get(8), equation.get(i).get(9));
            int operator=(int) userArray[equation.get(i).get(6)][equation.get(i).get(7)];
            double value;
            
            if(!(isReverse))
            {
                
                value=myOperator(userArray[equation.get(i).get(2)][equation.get(i).get(3)],
                        userArray[equation.get(i).get(4)][equation.get(i).get(5)], operator);
            }
            else{
                isReverse=floodFill(equation.get(i).get(0), equation.get(i).get(1),
                                        equation.get(i).get(6), equation.get(i).get(7));
                
                switch (operator) {
                    case 0:
                        value=myOperator(userArray[equation.get(i).get(4)][equation.get(i).get(5)],
                                userArray[equation.get(i).get(2)][equation.get(i).get(3)], 1);
                        break;
                    case 1:
                        if(!(isReverse))
                            value=myOperator(userArray[equation.get(i).get(2)][equation.get(i).get(3)],
                                    userArray[equation.get(i).get(4)][equation.get(i).get(5)], 1);
                        else
                            value=myOperator(userArray[equation.get(i).get(4)][equation.get(i).get(5)],
                                    userArray[equation.get(i).get(2)][equation.get(i).get(3)], 0);
                        break;
                    case 2:
                        value=myOperator(userArray[equation.get(i).get(4)][equation.get(i).get(5)],
                                userArray[equation.get(i).get(2)][equation.get(i).get(3)], 3);
                        break;
                    default:
                        if(!(isReverse))
                            value=myOperator(userArray[equation.get(i).get(2)][equation.get(i).get(3)],
                                    userArray[equation.get(i).get(4)][equation.get(i).get(5)], 3);
                        else
                            value=myOperator(userArray[equation.get(i).get(4)][equation.get(i).get(5)],
                                    userArray[equation.get(i).get(2)][equation.get(i).get(3)], 2);
                        break;
                }
                
                
                    
            }
            int fixed=(int) (value*100);
                value=fixed/100.0;
                    userArray[equation.get(i).get(0)][equation.get(i).get(1)]=value;
                    userStringArray[equation.get(i).get(0)][equation.get(i).get(1)]=Double.toString(value);
            
        }
        
    }
    
    public static double myOperator (double operant1,double operant2,int operator){
        
            switch (operator) {
                case 3:
                    int fixed=(int) ((operant1/operant2)*100);                  
                    return (fixed)/100.0;
                case 2:
                    return (operant1*operant2);
                case 1:
                    return (operant1-operant2);
                default:
                    return (operant1+operant2);
            }        
        
            
        
    }
    
    public static void userOutput(int x){
        if(x==0){
            System.out.print("\t");
        for (int i = 0; i < 9; i++) {
            System.out.print(i+"\t");
        }
        System.out.println("\n");
        
        for (int i = 0; i < 9; i++) {
            System.out.print(i+":\t");
            for (int j = 0; j < 9; j++) {
                System.out.print(userStringArray[i][j]+"\t");
                
            }
            System.out.println("");
            
        }
        }
        else if(x==1){
            System.out.println("\nchoice one of the following statements :\n"
                             + "\t\t1-show the solution.\n"
                              + "\t\t2-Hint.\n"
                                + "\t\t3-solve this puzzle.\n"
                                    + "\t\t4-create new Puzzle\n."
                                     + "\t\t5-exit.");
            System.out.print("Enter your choice : ");
        }
    }
    
    public static void welcome(){
        System.out.println("\t\t\tPalestine Polytechnic University -PPU-\n"
                         + "\t\tCollege of Information Technology and Computer Engineering\n"
                         + "\t\t\tObject-Oriented Programming -OOP-\n" 
        );
        System.out.println("\tMath crossword puzzle:\n\n"
                            + "\t\tGroup Work : \n"
                            + "\t\t\t-Name : Mohammed Samaheen       \t ID: 171004\n"
                            + "\t\t\t-Name : Abd-el Khaleq O Juniedi \t ID: 171019\n");
        System.out.print("Enter YES to create Puzzle:(Y/N):");
    }
    public static void cls() throws  AWTException
    {
     try {
    Robot pressbot = new Robot();
    pressbot.keyPress(17); // Holds CTRL key.
    pressbot.keyPress(76); // Holds L key.
    pressbot.keyRelease(17); // Releases CTRL key.
    pressbot.keyRelease(76); // Releases L key.
} catch (AWTException ex) {
         System.out.println("Error");
}
    }
}
   