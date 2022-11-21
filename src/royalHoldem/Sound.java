package royalHoldem;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

// this class use for play sound 
public class Sound {
	public static boolean isSound=true;
	
	public static void playtada(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playtadadata();
		    }
		});
		}
		}
	private static void playtadadata(){
		 try {	
			 File f=new File(".\\res\\sound\\tada.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
		            System.out.println("play");
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	public static void playClick(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playClickdata();
		    }
		});
		}
		}
	private static void playClickdata(){
		 try {	
			 File f=new File(".\\res\\sound\\clik.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
		            System.out.println("play");
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}

	public static void playExit(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playExitdata();
		    }
		});
		}
		}
	private static void playExitdata(){
		 try {	
			 File f=new File(".\\res\\sound\\exit.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
		            System.out.println("play");
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	
	public static void playCall(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	 playCalldata();
		    }
		});
		}
		}
	private static void playCalldata(){
		 try {	
			 File f=new File(".\\res\\sound\\call.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
		            System.out.println("play");
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}

	public static void playBid(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playBiddata();
		    }
		});
		}
		}
	private static void playBiddata(){
		 try {	
			 File f=new File(".\\res\\sound\\bid.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	public static void playFold(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playFolddata();
		    }
		});
		}
		}
	private static void playFolddata(){
		 try {	
			 File f=new File(".\\res\\sound\\bid.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}

	public static void playRais(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playRaisedata();
		    }
		});
		}
		}
	private static void playRaisedata(){
		 try {	
			 File f=new File(".\\res\\sound\\rais.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
		
	public static void playCardGv(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playCardGvdata();
		    }
		});
		}
		}
	private static void playCardGvdata(){
		 try {	
			 File f=new File(".\\res\\sound\\crdgv.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	public static void playShfl(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playShflata();
		    }
		});
		}
		}
	private static void playShflata(){
		 try {	
			 File f=new File(".\\res\\sound\\crdshfl.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	public static void playStcrd(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playStCrddata();
		    }
		});
		}
		}
	private static void playStCrddata(){
		 try {	
			 File f=new File(".\\res\\sound\\stcrd.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	public static void playchk(){
		if(isSound){			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	playchkdata();
		    }
		});
		}
		}
	private static void playchkdata(){
		 try {	
			 File f=new File(".\\res\\sound\\chk.wav");
			 if(f.exists()){
				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
		            Clip clip = AudioSystem.getClip( );
		            clip.open(audioInputStream);
		            clip.start();
			 }
	            
	        }
	        catch(Exception e)  {
	        }
		 
		}
	
}
