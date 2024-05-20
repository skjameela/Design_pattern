package com.designpatterns;

class Logger {
    private static Logger single_instance = null;

    private String logMessage;

    private Logger() {
        logMessage = "";
    }

    public static Logger getInstance() {
        if (single_instance == null) {
            single_instance = new Logger();
        }
        return single_instance;
    }

    public void log(String message) {
        logMessage += message + "\n";
    }

    public String getLog() {
        return logMessage;
    }
}

public class SingletonClass {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();

        logger1.log("First log message");
        logger1.log("Second log message");

        Logger logger2 = Logger.getInstance();

        System.out.println(logger2.getLog());

        System.out.println(logger1 == logger2);
    }
}
