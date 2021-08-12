
import org.apache.log4j.*;


public class Main {

    private  static  final Logger logger = LogManager.getLogger(Main.class);

    public static int add(int a, int b) {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%c{1}]"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        logger.debug("Hello this is a debug message");
        logger.info("Hello this is a info message");

        try{

        }catch (Exception e){
            logger.warn(e.getMessage(),e );
        }

        logger.debug("Hello this is a debug message");
        logger.info("Hello this is a info message");
        int c = a + b;
        return c;
    }


    public static void main(String[] args) {
        add(100, 200);
    }
}
