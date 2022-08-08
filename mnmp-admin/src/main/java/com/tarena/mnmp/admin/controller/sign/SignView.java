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

package com.tarena.mnmp.admin.controller.sign;

import com.tarena.mnmp.domain.SignDO;
import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@ApiModel(value = "签名模型")
@Data
public class SignView {

    private Long id;

    private String code;

    private String name;

    private Long appId;
    private String appCode;

    private String remarks;

    private String creator;

    private Integer enabled;
    private Integer auditStatus;
    private Date createTime;
    private Date updateTime;

    public static List<SignView> convert(List<SignDO> sources) {
        List<SignView> list = new ArrayList<>();
        for (SignDO sign : sources) {
            SignView signView = new SignView();
            BeanUtils.copyProperties(list, signView);
            list.add(signView);
        }
        return list;
    }
}
