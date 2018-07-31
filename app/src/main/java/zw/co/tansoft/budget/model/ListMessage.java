package zw.co.tansoft.budget.model;

public class ListMessage {
    // Number from witch the sms was send
    private String number;
    // SMS text body
    private String body;

    private String message;

    private String date_recievied;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate_recievied() {
        return date_recievied;
    }

    public void setDate_recievied(String date_recievied) {
        this.date_recievied = date_recievied;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
