import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {
	
	static JFrame frame;
	static JLabel text;
	static JLabel timerlabel;
	static JPanel panel;
	static File file;
	static FileWriter fw;
	static PrintWriter pw;
	
	//AUDIO
	static AudioFormat format;
	static DataLine.Info info;
	static TargetDataLine targetLine;
	static AudioInputStream audioStream;
	static File audioFile;
			
	static SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");
	static Color active = new Color(124, 252, 0);
	static ArrayList<String> numbers = new ArrayList<String>();
	static String labeltext = "A te digitális assiztensed munkára kész. Ha meguntál vagy eleged van belõlem nyomj F1-et." ;

	public static void main(String[] args) throws Exception{
		setWriters();
		setFrameAndAudio();
	}
	
	private static void writeALine(){
		if (!numbers.isEmpty()) {
			for (int i = 0; i < numbers.size(); i++) {
				pw.println(numbers.get(i));
			}
		}
		pw.close();
	}
	
	public static void setFrameAndAudio() {		
		try {
			format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
			info = new DataLine.Info(TargetDataLine.class, format);
			if (!AudioSystem.isLineSupported(info)) {System.err.println("Line not supported");}
			
			targetLine = (TargetDataLine)AudioSystem.getLine(info);
			targetLine.open();
			
		} catch (Exception e) {
			
		}
		
		//FRAME SETTINGS
		
		frame = new JFrame();
		panel = new JPanel();
		text = new JLabel(labeltext);
		timerlabel = new JLabel();
		
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.getContentPane();
		
		//JPanel's settings
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.setBackground(Color.black);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.addKeyListener(new KeyListener() {
			
			@Override public void keyTyped(KeyEvent arg0) {
				timerlabel.setForeground(Color.GREEN);
				timerlabel.setText("REC STARTED"); 
				timerlabel.repaint();
				
				}
			
			@Override
			public void keyReleased(KeyEvent ke) {
				if (ke.getKeyCode() == java.awt.event.KeyEvent.VK_F1) {
					targetLine.close();
					writeALine();
					System.exit(1);
				}
				
				if (ke.getKeyCode() != java.awt.event.KeyEvent.VK_F1) {
					numbers.add(sdf.format(new Timestamp(System.currentTimeMillis())));
				}
				if (ke.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {

					try {
						Thread thread = new Thread() 
						{
							@Override
							public void run()
								{
									audioStream = new AudioInputStream(targetLine);
									audioFile = new File("" + sdf.format(new Timestamp(System.currentTimeMillis())) + ".wav");
								try {
									AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
									timerlabel.setForeground(Color.RED);
									timerlabel.setText("REC STOPPED");
									timerlabel.repaint();
								} catch (Exception e) {
									System.out.println(e);
								}
							}
						};
						targetLine.start();
						thread.start();
						Thread.sleep(5000);
						targetLine.stop();
						
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
			
			@Override public void keyPressed(KeyEvent arg0) {}
		});
		
		//JLabel's settings

		Dimension size = text.getPreferredSize();
		
		text.setBounds(50, 100, size.width, size.height);
		text.setForeground(Color.GREEN);

		timerlabel.setBounds(150, 150, 400, 60);
		timerlabel.setForeground(Color.GREEN);
		timerlabel.setFont(new Font("Arial", Font.ITALIC, 40));
		
		panel.add(text);
		panel.add(timerlabel);
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		
	}

	private static void setWriters() throws Exception{
		try {
			file = new File("TimeCodesOutput.txt");
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
