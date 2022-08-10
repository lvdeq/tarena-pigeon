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
package com.tarena.mnmp.domain.provider.controller;

import com.tarena.mnmp.api.NoticeDTO;
import com.tarena.mnmp.api.NoticeService;
import com.tarena.mnmp.domain.provider.DefaultNoticeService;
import com.tarena.mnmp.enums.NoticeType;
import com.tarena.mnmp.enums.SendType;
import com.tarena.mnmp.protocol.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    private static NoticeService noticeService = null;

    static {
        noticeService = new DefaultNoticeService();
    }

    @PostMapping("send")
    public void send(@RequestBody SendParam param) {
        NoticeDTO dto = new NoticeDTO();
        BeanUtils.copyProperties(param, dto);
        dto.setSendType(SendType.IMMEDIATELY);
        dto.setNoticeType(NoticeType.SMS);
        try {
            noticeService.send(dto);
        } catch (BusinessException e) {
            log.error("send error", e);
        }
    }


}