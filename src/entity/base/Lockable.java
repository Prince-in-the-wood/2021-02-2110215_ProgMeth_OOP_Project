package entity.base;

public interface Lockable {
	public void lock();
	public boolean isLocked();
	public void unlock();

}
