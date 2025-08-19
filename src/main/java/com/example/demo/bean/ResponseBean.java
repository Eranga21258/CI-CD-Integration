package com.example.demo.bean;

import com.example.demo.util.MessageVarList;
import lombok.Data;

@Data
public class ResponseBean {
    private String status;
    private String message;
    private Object content;

    public void setResponse(String status) {
        this.status = status;
        switch (status) {
            case MessageVarList.RSP_SUCCESS:
                this.message = "Success";
                break;
            case MessageVarList.RSP_NO_DATA_FOUND:
                this.message = "No Data Found";
                break;
            case MessageVarList.RSP_NOT_AUTHORISED:
                this.message = "Unauthorised Action";
                break;
            case MessageVarList.RSP_TOKEN_EXPIRED:
                this.message = "Token Expired";
                break;
            case MessageVarList.RSP_TOKEN_INVALID:
                this.message = "Token Invalid";
                break;
            case MessageVarList.RSP_ERROR:
                this.message = "Unknown Error";
                break;
            case MessageVarList.RSP_FAIL:
                this.message = "Fail";
                break;
            case MessageVarList.RSP_REQUEST_INVALID:
                this.message = "Invalid Request Parameters";
                break;
        }
    }

}
