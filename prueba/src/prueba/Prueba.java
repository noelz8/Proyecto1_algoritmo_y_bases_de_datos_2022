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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
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
    private int numErrors=0;
    

    
    //Logica del juego
    private boolean myTurn=false;
    private final String[] wordList; //Tablero para nombre no imagenes
    private String[] board;
    
    private ToggleButton selected1;
    private ToggleButton selected2;
    private int myMatches =0; //control de parejas hechas
    private int opMatches =0;//control de parejas hechas por el otro jugador
    
    private boolean gameOver=false;
    private boolean gameStateUpdated=false;
    private ToggleButton ultimoSeleccionado;
    
    
    //GUI
    private final int numCols;
    private final int numRows;
    private TilePane tilePane;
    private Stage stage;
    private final double TILE_SIZE=100;
    
    
    
    
    public Prueba() throws IOException{
        //recordar que la lista de palabras ocupa ser un numero par
        wordList=new String[]{"A,B,C;D;E;F;G;H"};
        
        numCols=(int)Math.ceil(Math.sqrt(wordList.length*2));
        numRows=numCols;
        
        
        //Buscar servidor a conectarse, sino volverse el server
        if (!connectToServer()){
            initServer();
            
            //Paso 1) crear el inicio del tablero
            HashMap<String, Integer> wordCount= new HashMap<String,Integer>();
            for (String s:wordList){
                wordCount.put(s,0);
                
            }
            
            board=new String[2*wordList.length];
            for (int i=0; i<board.length; i++){
                String word= wordList[(int) (Math.random()*wordList.length)];
                while(wordCount.get(word)>=2){
                    word= wordList[(int) (wordList.length * Math.random())];
                    
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
            
            outputBoard= new ObjectOutputStream(socket.getOutputStream());
            inputBoard=new ObjectInputStream(socket.getInputStream());
            
            
            ClientConnected=true;//revisar
            isServer=false;
            System.out.println("Successfulyy connected to server");
            
        }catch(IOException e){
            System.out.println("Unable to connect to server at adress"+ip+":"+port);
            return false;
        }
        return true;
    }
    
    private void initServer(){
        System.out.println("Iniciando server");
        try{
            serverSocket= new ServerSocket(port,8,InetAddress.getByName(ip));
            
            myTurn=true;
            isServer=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    private void listenForServerRequest(){
        Socket socket=null;
        try{
            //Bloquea el programa hasta recibir una solicitud
            socket= serverSocket.accept();
            outputTurn=new DataOutputStream(socket.getOutputStream());
            inputTurn=new DataInputStream(socket.getInputStream());
            
            outputBoard= new ObjectOutputStream(socket.getOutputStream());
            inputBoard=new ObjectInputStream(socket.getInputStream());
            
            ClientConnected=true;
            isServer=true;
            myTurn=true;
            
            //ya que el cliente este conectado, se enviara el tablero inicial
            sendClientBoardState();
            
            //Permite inciar al servidor iniciar turno
            disableTiles(false);
            
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    private void sendClientBoardState(){
        try{
            outputBoard.writeObject(board);
            outputBoard.flush();
        }catch (IOException e){
            e.printStackTrace();
            numErrors++;
        }
        
    }
    private void fetchBoardStateFromServer(){
        board= new String[2*wordList.length];
        try{
            String[] fromServer = (String[]) inputBoard.readObject();
            board= fromServer.clone();
        } catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    /****************************************
    *GUI de la aplicacion
    */
    @Override
    public void start(Stage primaryStage)  {
        this.stage=primaryStage;
        
        tilePane= new TilePane();
        tilePane.setPrefColumns(numCols);
        tilePane.setPrefColumns(numRows);
        
        //se crea un boton para cada carta
        for (int i=0;i<board.length;i++){
            tilePane.getChildren().add(createButton(i));
            
        }
        
        disableTiles(true);
        
        StackPane root=new StackPane();
        root.getChildren().add(tilePane);
        
        Scene scene= new Scene(root, numCols*TILE_SIZE, numRows*TILE_SIZE);
        scene.getStylesheets().add(this.getClass().getResource("Style.css").toExternalForm());
        
        if(isServer){
            addStringToTitle("Esperando cliente para conectar");
            
        }else{
            addStringToTitle("Conectado al servidor");
        }
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    private ToggleButton createButton(int index){
        ToggleButton btn= new ToggleButton(board[index]);
        btn.setPrefHeight(TILE_SIZE);
        btn.setPrefWidth(TILE_SIZE);
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                ToggleButton source=(ToggleButton) e.getSource();//guardando como referencia al ultimo movimiento hecho
                ultimoSeleccionado=source;
                gameStateUpdated=true;//avisando que el juego fue actualizado
            }    
        });
        return btn;
        
    }
    
    private void addStringToTitle(String s){
        String clientServer="Server";
        if (!isServer){
            clientServer="Client";
        }
        if (this.stage !=null){
            this.stage.setTitle(clientServer+":"+s);
        
    }
    }
    
    private void highlightMatch(boolean myMatch){
        selected1.getStyleClass().clear();
        selected2.getStyleClass().clear();
        if (myMatch){
            selected1.getStyleClass().add("my-match");
            selected2.getStyleClass().add("my-match");
            myMatches++;
        }else{
            selected1.getStyleClass().add("op-match");
            selected2.getStyleClass().add("op-match");
            opMatches++;
            
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {//REVISAR
        launch(args);
        
        Prueba prueba=new Prueba();
    }
/**************************
 * Logica del juego
 */
    @Override
    public void run() {
        while (!gameOver){
            gameTick();
            
            if (isServer && !ClientConnected){
                listenForServerRequest();
            }
        }
    }    

    private void gameTick(){
        //revisar que haya conexion entre cliente y servidor
        if (numErrors>10){
            lostConnection=true;
            addStringToTitle("List connection");
            
            
            //Intentar reconectar
        }
        
        //Asegurar que los turnos se actualizen
        if (myTurn){
            addStringToTitle("Mi turno");
        }else{
            addStringToTitle("Turno del rival");
        }
        
        //Ver si se ha escogido algo
        //actualizar los datos del tablero
        updateBoardStateOnTileSelection();
    }
    
    private void updateBoardStateOnTileSelection(){
        ToggleButton selectedTile=null;
        
        //A. Mi turno
        if (myTurn && gameStateUpdated){
            gameStateUpdated=false;
            
            selectedTile=ultimoSeleccionado;
            
            //no permitir que el usuario escoga una carta ya escogida
            selectedTile.setDisable(true);
            
            //enviar la accion hecha al oponente
            try{
                outputTurn.writeInt(getIndexOfTile(selectedTile));
                outputTurn.flush();
            }catch (IOException e){
                e.printStackTrace();
                numErrors++;
            }
        }
        
        //B. turno rival
        if(!myTurn){
            try{
                int tileIndex=inputTurn.readInt();
                selectedTile=(ToggleButton) tilePane.getChildren().get(tileIndex);
                
                
                //Simular la seleccion del oponente
                selectedTile.setSelected(true);
                
            }catch(IOException e){
                e.printStackTrace();
                numErrors++;
            }
            
        }
        
        //Asignar las cartas elegidas apra comparar la pareja
        if (selected1==null){
            selected1=selectedTile;
        }else{
            selected2=selectedTile;
        }
        
        //Si se escogieron 2 cartas ver si son pareja
        if (selected1 !=null && selected2 !=null){
            checkForMatch();
        }
        
    }
    private int getIndexOfTile(ToggleButton b){
        int index=0;
        for (Node n:tilePane.getChildren()){
            if (n.equals(b)){
                return index;
            }
            index++;
        }
        return -1;//╰（‵□′）╯
    }
    
    private void checkForMatch(){
        disableTiles(true);
        
        if (selected1.getText().equals(selected2.getText())){
            //Si es nuestro turno vuelve habilitar las cartas para el siguiente turno
            if (myTurn){
                disableTiles(false);
            }
            highlightMatch(myTurn);
            
            checkGameOver();
        }else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //esconder cartas
            selected1.setSelected(false);
            selected2.setSelected(false);
            
            //cambiar jugador
            myTurn=!myTurn;
            disableTiles(!myTurn);
            if (myTurn){
                addStringToTitle("Mi turno");
            }else{
                addStringToTitle("Turno Rival");
            }
        }
        //Reiniciar para el siguiente turno
        selected1=null;
        selected2=null;
                }
    
    
    private void checkGameOver(){
        if ((myMatches+opMatches) !=wordList.length){
            gameOver=false;
        }else{
            gameOver=true;
            
            if (myMatches>opMatches){
                addStringToTitle("Ganador");
            }else if(myMatches==opMatches){
                addStringToTitle("empate");
            }else{
                addStringToTitle("Perdedor");
            }
        }
    }
    
    
    private void disableTiles(boolean disableOrNot){
        for (Node child: tilePane.getChildren()){
            if (child instanceof ToggleButton){
                ToggleButton tile=(ToggleButton)child;
                
                if(tile.isSelected()==false){
                    tile.setDisable(disableOrNot);
                }
            }
        }
    }
}


