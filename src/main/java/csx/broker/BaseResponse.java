package csx.broker;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Integer resCode;

    private Integer resMsg;

    private Object Data;

}
