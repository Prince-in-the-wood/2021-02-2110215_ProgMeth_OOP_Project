package logic;

public class Timer {
	private int minute;
	private int second;
	private int ms;
	
	public Timer(int m,int s, int ms) {
		setMinute(m);
		setSecond(s);
		setMs(ms);
	}

	// getter and setter
	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getMs() {
		return ms;
	}

	public void setMs(int ms) {
		this.ms = ms;
	}

}
