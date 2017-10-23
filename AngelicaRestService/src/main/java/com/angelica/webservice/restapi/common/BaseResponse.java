package com.angelica.webservice.restapi.common;

import lombok.Data;

@Data
public class BaseResponse {

    public Integer returnCode;
    public String returnMessage;

}
