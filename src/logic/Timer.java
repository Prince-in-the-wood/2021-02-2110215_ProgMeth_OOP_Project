package logic;

public class Timer {
	private int minute;
	private int seconds;
	private int ms;
	
	public Timer(int m,int s, int ms) {
		setMinute(m);
		setSeconds(s);
		setMs(ms);
	}

	
	public void decrementTimer(int amount) { //Decrease the timer by specified amount (milliseconds)
		
		if(isTimerOver()) {return;}
		
		ms -= amount;

		while(ms < 0) {
			if(isTimerOver()) {ms = 0; return;}
			ms+=100;
			seconds -= 1;	
			while(seconds < 0) {
				seconds+=60;	
				minute -=1;
			}
		}

	}
	
	public boolean isTimerOver() {
		return minute<=0 && seconds<=0 && ms<=0;
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d",minute, seconds, ms);
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public void setMs(int ms) {
		this.ms = ms;
	}


}
