package royalHoldem.multiplay.client;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
	
	private Socket localSocket;
	private BufferedReader br;
	private DataOutputStream outStream;	
	private DataInputStream inStream;
	private boolean isServerOK=true;
	private String clientMsgIN="0",clientMsgOUT="0";
	private ClientOperator cOperator = new ClientOperator();
	
	public Client(){
		
		try{
			localSocket=new Socket("localhost",7605); //normal socket requesting to the server
			
			br=new BufferedReader(new InputStreamReader(System.in));			//read console input&put in buffered reader
			outStream = new DataOutputStream(localSocket.getOutputStream());	//send data to the Server			
			inStream = new DataInputStream(localSocket.getInputStream());		//get data(text)comes from server
			
			while(this.isServerOK()){	//loop works until server or client stops/terminate/raise exception		
				try {
					//outStream.writeUTF(br.readLine());		//send data to the server					
					//System.out.println("Server Says:"+inStream.readUTF());					//print string received from server
					//this.setClientMsgOUT(br.readLine());
					this.setClientMsgOUT(br.readLine());
					outStream.writeUTF(this.getClientMsgOUT());
					this.setClientMsgIN(inStream.readUTF());
					this.clientMsgINinterpreter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Read or Write to server failed!");
					this.setServerOK(false);
				}
			}
		}
		catch(java.net.BindException ex){
			System.out.println("Port/Socket in use. Can't run on the same port");
		}
		catch(IOException e) {
			// TODO: handle exception;
			System.out.println("Error occured when read/write data from server");
			System.out.println("caught at Client class constructor");
		}
		finally{
			//closing resources		
			try {
				br.close();
				inStream.close();
				outStream.close();
				localSocket.close();
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println("Error occured when clear resources by client constructor");
			}
		}
	}

	public boolean isServerOK() {
		return isServerOK;
	}

	public void setServerOK(boolean isServerOK) {
		this.isServerOK = isServerOK;
	}

	
	private void setClientMsgIN(String clientMsgIN) {
		this.clientMsgIN = clientMsgIN;
	}

	public String getClientMsgIN() {
		return clientMsgIN;
	}

	public void setClientMsgOUT(String clientMsgOUT) {
		this.clientMsgOUT = clientMsgOUT;
	}

	private String getClientMsgOUT() {
		return clientMsgOUT;
	}
	
	private void clientMsgINinterpreter() {
		//Call client side method based on the message received from server. received message must have an integer value only
		int actionKey;	//Integer which has the number of the required method to be executed
		try {
			actionKey = Integer.parseInt(getClientMsgIN().trim());	//Convert received String message to Integer
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block

			System.out.println("Server has sent Character for actionKey, Wrong data type!");
			actionKey=0;
		}
		
		if (actionKey<5) {
			cOperator.clientMethodOne();
		}else if (actionKey<10) {
			cOperator.clientMethodTwo();
		}else {
			System.out.println("Wrong action key!");
		}
	}

	
}
