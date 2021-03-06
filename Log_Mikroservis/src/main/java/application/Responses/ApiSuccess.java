package application.Responses;

import java.time.LocalDateTime;

public class ApiSuccess {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Object responseObject;

    public ApiSuccess() {}

    public ApiSuccess(int status, String message, Object responseObject) {
        this.timestamp = LocalDateTime.now();;
        this.status = status;
        this.message = message;
        this.responseObject = responseObject;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
