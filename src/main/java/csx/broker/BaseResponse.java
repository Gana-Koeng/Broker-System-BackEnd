package csx.broker;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Object resCode;

    private String resMsg;

    private Object Data;

}
