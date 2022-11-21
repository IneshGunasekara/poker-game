package royalHoldem.multiplay.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
	
	private ServerSocket serverSocket;	//server type socket needed only in server side
	private Socket localSocket;			//normal socket accepting any client requesting from same port
	
	public ServerThread(){
		try{
			serverSocket = new ServerSocket(7605);
			
			for (int i = 0; i < 6; i++) {			
				localSocket = serverSocket.accept(); 
				Server srvr=new Server(localSocket);
				Thread t=new Thread(srvr);
				t.start();
			}
			
		}
		
		catch(java.net.BindException e){
			System.out.println("Server Port/Socket address already in use! Server can't startup");
		}
		catch(IOException e){
			System.out.println("Error occured when creating a new thread");
			System.out.println("Caught at ServerThread class Constructor");
		}
	}
}
