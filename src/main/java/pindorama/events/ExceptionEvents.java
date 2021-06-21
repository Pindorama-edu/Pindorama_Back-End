package pindorama.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pindorama.utils.ErrorInfo;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionEvents {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public String onBadRequest(Exception ex) {
        return "Request Error: " + ex.getMessage();
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ErrorInfo onSupportedMethod(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURI(), request.getMethod(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo onNotFound(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURI(), request.getMethod(), ex.getMessage());
    }

}
