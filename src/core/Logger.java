package core;

/**
 * The logger class represents an object that handles Log objects (send the Logs
 * to the database or to some other storage).
 */
public class Logger {

	private String driverName;

	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}

	/**
	 * The log method get a Log object as a parameter and print it to screen (in
	 * the future will send it to some storage)
	 */
	//Phase3 change to static
	public static void log(Log log) {
		System.out.println(log);
	}

	/**
	 * returns all logs - history of clients transactions in the system
	 */
	public Log[] getLogs() {
		return null;
	}

}
