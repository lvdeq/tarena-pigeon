/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tarena.test.mnmp.admin.service;

import com.tarena.mnmp.admin.AdminApplication;
import com.tarena.mnmp.app.AppDO;
import com.tarena.mnmp.app.AppSaveParam;
import com.tarena.mnmp.app.AppService;
import com.tarena.mnmp.commons.utils.Asserts;
import com.tarena.mnmp.constant.ErrorCode;
import com.tarena.mnmp.protocol.BusinessException;
import com.tarena.test.mnmp.admin.sql.app.AppSqlScript;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = {AdminApplication.class})
public class AppServiceTest {
    Logger logger = LoggerFactory.getLogger(AppServiceTest.class);
    @Autowired
    private AppService appService;

    @Test
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE, AppSqlScript.INSERT_TEST_DATA},
        config = @SqlConfig(encoding = "UTF-8")
    )
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void queryAllAppsTest() throws BusinessException {
        List<AppDO> apps =
            appService.queryList();
        logger.info("查询app总数:{}", apps.size());
        Asserts.isTrue(apps.size() != 22, new BusinessException(ErrorCode.SYSTEM_ERROR, "查询所有app列表测试持久层mapper失败"));
    }

    @Test
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void saveAppTest() throws BusinessException {
        AppSaveParam appSaveParam = new AppSaveParam();
        appSaveParam.setTeamMembers("wang,li,zhang,zhao");
        appSaveParam.setStatus(1);
        appSaveParam.setRemarks("测试程序");
        appSaveParam.setName("达内测试");
        appSaveParam.setLeader("ceshiwang");
        appSaveParam.setCode("CODE_TEST_001");
        assertDoesNotThrow(() -> {
                appService.addApp(appSaveParam);
            }
        );
        logger.info("新增app应用测试业务层service成功");
    }

    @Test
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE, AppSqlScript.INSERT_TEST_DATA},
        config = @SqlConfig(encoding = "UTF-8")
    )
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void openAndCloseTest() throws BusinessException {

        AppDO appDO1 = appService.queryAppDetail(1L);
        AppDO appDO2 = appService.queryAppDetail(2L);
        Asserts.isTrue(appDO1 == null || appDO2 == null, new BusinessException(ErrorCode.SYSTEM_ERROR, "id查询app应用测试持久层mapper失败"));
        Integer status1 = appDO1.getStatus();
        Integer status2 = appDO2.getStatus();
        Asserts.isTrue(status1 == 1 || status2 == 0, new BusinessException(ErrorCode.SYSTEM_ERROR, "测试app数据有误,请检查前两条status属性是否是0,1"));
        appService.openApp(appDO1.getId());
        appService.closeApp(appDO2.getId());
        appDO1 = appService.queryAppDetail(1L);
        appDO2 = appService.queryAppDetail(2L);
        status1 = appDO1.getStatus();
        status2 = appDO2.getStatus();
        Asserts.isTrue(status1 == 0 || status2 == 1, new BusinessException(ErrorCode.SYSTEM_ERROR, "开启关闭app应用测试持久层mapper失败"));
        logger.info("开启关闭app应用测试业务层service成功");
    }

    @Test
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE, AppSqlScript.INSERT_TEST_DATA},
        config = @SqlConfig(encoding = "UTF-8")
    )
    @Sql(
        scripts = {AppSqlScript.TRUNCATE_APP_TABLE},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void modifyAppTest() throws BusinessException {
        AppSaveParam appSaveParam = new AppSaveParam();
        appSaveParam.setId(1L);
        appSaveParam.setTeamMembers("wang,li,zhang,zhao");
        appSaveParam.setStatus(1);
        appSaveParam.setRemarks("测试程序");
        appSaveParam.setName("达内测试");
        appSaveParam.setLeader("ceshiwang");
        appSaveParam.setCode("CODE_TEST_001");
        assertDoesNotThrow(() -> {
            appService.editApp(appSaveParam);
        });
        logger.info("更新app应用测试业务层service成功");
    }
}
