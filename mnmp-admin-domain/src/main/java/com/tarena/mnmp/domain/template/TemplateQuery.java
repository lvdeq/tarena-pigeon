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

package com.tarena.mnmp.domain.template;

import com.tarena.mnmp.commons.pager.SimplePager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "模板查询入参")
public class TemplateQuery extends SimplePager {
    @ApiModelProperty(
        value = "应用编码",
        name = "appCode"
    )
    private String appCode;
    @ApiModelProperty(
        value = "审核状态",
        name = "auditStatus"
    )
    private Integer auditStatus;

    @ApiModelProperty(
        value = "是否可用 (0否 1是）",
        name = "enabled"
    )
    private Integer enabled;

    @ApiModelProperty(
        value = "模板编码",
        name = "templateCode"
    )
    private String templateCode;

    @ApiModelProperty(
        value = "模板名称",
        name = "templateName"
    )
    private String templateName;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}