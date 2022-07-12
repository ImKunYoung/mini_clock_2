package miniClock;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Time extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel timeLabel = new JLabel();
	private String text="00:00:00";
	private Timer timer = new Timer();
	private TimerTask task=new TimerTask(){
		@Override
		public void run() {
			text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			initialize();
		}
	};
	public Time() {
		this.setBackground(Color.BLACK);
		timeLabel.setForeground(Color.YELLOW);
		timer.schedule(task, 1000, 1000);
		initialize();
		this.add(timeLabel);
	}
	public void initialize() {timeLabel.setText(text);}
}
