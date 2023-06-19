package com.he.commons.controller;

import org.springframework.context.annotation.Import;

import com.he.commons.exception.BaseException;
import com.he.commons.result.JsonResult;
import com.he.commons.service.BaseServer;
import com.he.commons.utils.SpringContextUtil;

@Import(SpringContextUtil.class)
public class BaseController {

    public JsonResult request(String interCode, Object data){
        try{
            BaseServer<JsonResult> baseServer = (BaseServer) SpringContextUtil.getBean(interCode);
            return baseServer.deal(data);
        }catch(BaseException e){
            e.printStackTrace();
            return JsonResult.failed(e);
        }
    }
}
