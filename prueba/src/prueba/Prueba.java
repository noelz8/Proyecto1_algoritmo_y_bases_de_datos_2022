/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package prueba;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


/**
 *
 * @author Noel
 */
public class Prueba extends Application implements Runnable{
    
    //Network
    private final String ip= "localhost";
    private final int port=22222;
    private final Thread thread;
    
    
    private Socket socket;
    private ServerSocket serverSocket;
    private DataOutputStream outputTurn;
    private DataInputStream inputTurn;
    private ObjectOutputStream outputBoard;
    private ObjectInputStream inputBoard;
    
    private boolean isServer=false;
    private boolean ClientConnected=false;
    
    private boolean lostConnection=false;
    private int numErros=0;
    

    
    //Logica del juego
    private boolean myTurn=false;
    private final String[] wordList; //Tablero para nombre no imagenes
    private String[] board;
    
    private ToggleButton selected1;
    private ToggleButton selected2;
    private int myMatches =0; //control de parejas hechas
    private int opMatches =0;//control de parejas hechas por el otro jugador
    
    private boolean gameOver=false;
    private boolean gameStateUpdate=false;
    private ToggleButton ultimoSeleccionado;
    
    
    //GUI
    private final int numCols;
    private final int numRows;
    private TilePane tilePane;
    private Stage stage;
    private final double TILE_SIZE=100;
    
    
    
    
    public Prueba(){
        //recordar que la lista de palabras ocupa ser un numero par
        wordList=new String[]{"A,B,C;D;E;F;G;H"};
        
        numCols=(int)Math.ceil(Math.sqrt(wordList.length*2));
        numRows=numCols;
        
        
        //Buscar servidor a conectarse, sino volverse el server
        if (!connectToserver()){
            initServer();
            
            //Paso 1) crear el inicio del tablero
            HashMap<String, Integer> wordCount= new HashMap<String,Integer>();
            for (String s:wordList){
                wordCount.put(s,0);
                
            }
            
            board=new String[2*wordList.length];
            for (int i=0; i<board.length; i++){
                String word= wordList[Math.random()*wordList.length];
                while(wordCount.get(word)>=2){
                    word= wordList[(int) (Math.random() * wordList.length)];
                    
                }
                wordCount.put(word,wordCount.get(word)+1);
                board[i]=word;
                
            }
            
            //Paso 2) esperar que el cliente se una y enviar el estado del tablero
            
        }else{
            
            //Si no somos el servidor, entonces ocupamos iniciar el tablero para el estado del servidor
            fetchBoardStateFromServer();
            
            
        }
        
        thread=new Thread(this,"prueba");
        thread.start();
    }

    /*******************************************************************************************************
     * Metodos para el Network
     */
    private boolean connectToServer(){
        System.out.println("Connecting to server...");
        try{
            socket=new Socket(ip,port);
            outputTurn=new DataOutputStream(socket.getOutputStream());
            inputTurn=new DataInputStream(socket.getInputStream());
            
        }catch(IOException e){
            System.out.println("Unable to connect to server at adress"+ip+":"+port);
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        Prueba prueba=new Prueba();
    }

    @Override
    public void run() {
        
    }    

    @Override
    public void start(Stage stage) throws Exception {
    }
}


