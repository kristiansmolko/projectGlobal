package global.log;

public class Log {
    public void error(String msg){
        System.out.println("[ERROR] : " + msg);
    }

    public void ok(String msg){
        System.out.println("[OK] : " + msg);
    }

    public void info(String msg){
        System.out.println("[INFO] : " + msg);
    }
}
