package pindorama.utils;

public class ErrorInfo {

    public final String path;
    public final String method;
    public final String message;

    public ErrorInfo(String path, String method, String message) {
        this.path = path;
        this.method = method;
        this.message = message;
    }
}
