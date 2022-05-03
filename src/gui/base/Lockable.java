package gui.base;

public interface Lockable {
	public abstract void lock();
	public abstract boolean isLocked();
	public abstract void unlock();

}
