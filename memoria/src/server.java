/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Noel
 */
public class server {
    public static String [][]board= new String[4][4];
    public static String[][]cards= new String[4][4];
    public static Scanner scanner= new Scanner(System.in);
    
    public static void printBoard(){
        
        for(int i=0; i<4;i++){
            System.out.print("|");
            for(int j=0; j<4;j++){
                System.out.print(board[i][j]);
                System.out.print("|");
            
        }
            System.out.println("");
        }
    }
    
    
    public static void shuffleCards(){
        Random random= new Random();
        ArrayList<String> letters= new ArrayList<String>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        
        int index;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                index= random.nextInt(letters.size());
                cards[i][j]=letters.get(index);
                letters.remove(index);
            }
        }
        
        
    }
    
   public static void  checkInput(String[][]cards){
       while(true){
           if(!gameOver()){
              System.out.println("Row: (1-4)");
              int row1=scanner.nextInt();
              System.out.println("Column:(1-4)");
              int column1=scanner.nextInt();
              
              if(!board[row1-1][column1-1].equals("_")){
                  System.out.println("Already Entered");
                  System.out.println();
                  
                  
                  printBoard();
                  continue;
              }else{
                  board[row1-1][column1-1]=""+cards[row1-1][column1-1]+"";
                  printBoard();
                  
                  
              }
              System.out.println("Row: (1-4)");
              int row2=scanner.nextInt();
              System.out.println("Column:(1-4)");
              int column2=scanner.nextInt();
              
              if(!board[row2-1][column2-1].equals("_")){
                  System.out.println("Already entered");
                  board[row1-1][column1-1]="_";
                  System.out.println();
                  
                  
                  printBoard();
                  continue;
                  
              }else{
                  board[row2-1][column2-1]=" "+cards[row2-1][column2-1]+" ";
                  
                  
                  if(board[row1-1][column1-1].equals(board[row2-1][column2-1])){
                      printBoard();
                      System.out.println("Correcto");
                      
                  }else{
                      printBoard();
                      System.out.println("Incorrecto");
                      board[row1-1][column1-1]="_";
                      board[row2-1][column2-1]="_";
                      printBoard();
                  }
                  
              }
           }else{
               System.out.println("Fin del juego");
               break;
           }
       }
   }
    
   public static boolean gameOver(){
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               if(board[i][j].equals("_")){
                   return false;
               }
           }
       }
       return true;
   }
   
   public static void main(String[]args){
       while(true){
           System.out.println("press n for new game and Q to quit");
           String nq= scanner.nextLine();
           if(nq.equals("q")){
               System.out.println("saliendo");
               break;
           }else if(nq.equals("n")){
               
               shuffleCards();
               for(int i=0;i<4;i++){
                   for(int j=0;j<4;j++){
                       board[i][j]="_";
                       
                   }
               }
               printBoard();
               checkInput(cards);
               break;
           
       }else {
               System.out.println("Invalid character");
               continue;
           }
       }
   }
}
