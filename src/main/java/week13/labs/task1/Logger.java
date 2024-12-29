package week13.labs.task1;

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    public void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    public void logError(String message) {
        System.out.println("ERROR: " + message);
    }

    public void logWarning(String message) {
        System.out.println("WARNING: " + message);
    }
}

class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Application started");
        logger.logInfo("This is an informational message");
        logger.logWarning("This is a warning message");
        logger.logError("This is an error message");
        logger.log("Application ended");
    }
}
