package com.information.portfolio.handle;

import com.information.portfolio.constant.Constant;
import com.information.portfolio.model.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HandleSql {
    private static final Logger logger = LoggerFactory.getLogger(HandleSql.class);
    public void handleExecuteSqlSuccess(Result result)
    {
        logger.info("Ejecucion de consulta exitosa");
        result.setCode(Constant.CODE_OK);
        result.setMessage(Constant.MSG_OK);
        result.setEntry("{}");
    }

    public void handleExecuteSqlSuccess(Result result,Object entry)
    {
        logger.info("Ejecucion de consulta exitosa");
        result.setCode(Constant.CODE_OK);
        result.setMessage(Constant.MSG_OK);
        result.setEntry(entry);
    }
    public void handleExecuteSqlFail(Result result,Exception e)
    {
        logger.info(Constant.MSG_ERROR_SQL + " - " + e.getMessage());
        result.setCode(Constant.CODE_ERROR);
        result.setMessage(Constant.MSG_ERROR_SQL);
        result.setEntry("{}");
    }



}
