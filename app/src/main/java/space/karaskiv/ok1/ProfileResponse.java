package space.karaskiv.ok1;

public class ProfileResponse {

    private Integer returnValue;
    private String message;

    public Integer getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Integer returnValue) {
        this.returnValue = returnValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return
                "Object{}";
    }

}
