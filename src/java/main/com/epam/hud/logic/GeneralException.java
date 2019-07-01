package java.main.com.epam.hud.logic;

public class GeneralException extends Exception {
    private String message;

    public GeneralException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
