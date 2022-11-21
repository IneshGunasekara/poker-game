package royalHoldem.multiplay.server;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server implements Runnable {
	
	private Socket localSocket;
	private BufferedReader br;
	private DataInputStream inStream;
	private DataOutputStream outStream;
	private String clientIP="";
	private String serverMsgIN="0",serverMsgOUT="0";
	private ServerOperator sOperator = new ServerOperator();
	
	public Server(Socket tempSocket){
		
		try{		
			this.localSocket=tempSocket;
			this.clientIP=this.localSocket.getRemoteSocketAddress().toString();
			
			br=new BufferedReader(new InputStreamReader(System.in));		//read console input&put in buffered reader 
			inStream = new DataInputStream(localSocket.getInputStream());	//get data(text)comes from client
			outStream = new DataOutputStream(localSocket.getOutputStream());	//send data to the client
		}
		catch(IOException ex){
			System.out.println("Error occured when initiating new Server Object");
			System.out.println("Caught at Server Class's constructor");
		}
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				/*System.out.println("Client " + clientIP + " Says :"+ inStream.readUTF()); //print string received from client							
				outStream.writeUTF(br.readLine()); //send data to the client	
*/				this.setServerMsgIN(inStream.readUTF());				
				this.serverMsgINinterpreter();
				this.setServerMsgOUT(br.readLine());
				outStream.writeUTF(this.getServerMsgOUT());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					Thread.sleep(300);
				} catch (InterruptedException e2) {
					// TODO: handle exception
					Thread.currentThread().interrupt();
					try {			
						clearResources();
					} catch (IOException e1) {
						System.out.println("Clearing resources failed!");
					}				
				}
			}	
		}
	}
	
	public void clearResources() throws IOException{
		//closing resources
			br.close();
			inStream.close();
			outStream.close();
	}

	public String getServerMsgIN() {
		return serverMsgIN;
	}

	private void setServerMsgIN(String serverMsgIN) {
		this.serverMsgIN = serverMsgIN;
	}

	private String getServerMsgOUT() {
		return serverMsgOUT;
	}

	public void setServerMsgOUT(String serverMsgOUT) {
		this.serverMsgOUT = serverMsgOUT;
	}

	public String getClientIP() {
		return clientIP;
	}
	
	private void serverMsgINinterpreter() {
		//Call Server side methods based on the user input, received message must be an Integer.
		int actionKey;	//Integer which has the number of the required method to be executed
		try {
			actionKey=Integer.parseInt(this.getServerMsgIN().trim());	//Convert received String message to Integer
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Client has sent Character for actionKey, Wrong data type!");
			actionKey=0;
		}
		
		if (actionKey<5) {
			sOperator.serverMethodOne();
		}else if (actionKey<10) {
			sOperator.serverMethodTwo();
		}else {
			System.out.println("Wrong action selected!");
		}
			
	}
}

