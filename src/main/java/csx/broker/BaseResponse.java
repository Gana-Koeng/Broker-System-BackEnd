package csx.broker;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Integer resCode;

    private String resMsg;

    private Object Data;

    public void doSth(){
        System.out.println("haha");
    }

}
