package com.uniedp.modules.job.runner;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * @Description:job runner 配置
 * @Param:
 * @return:
 * @Author: songchen
 * @Date: 2018/11/28
 */
@JobHandler(value = "testJobRunner")
@Component
public class TestJobRunner extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("开始处理成功日志分析任务");
        return SUCCESS;
    }

}