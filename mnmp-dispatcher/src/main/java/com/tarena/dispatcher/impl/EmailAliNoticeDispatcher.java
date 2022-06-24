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

package com.tarena.dispatcher.impl;

import com.tarena.dispatcher.EmailNoticeTarget;
import com.tarena.mnmp.commons.enums.NoticeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailAliNoticeDispatcher extends AbstractNoticeDispatcher<EmailNoticeTarget> {
    private static Logger logger = LoggerFactory.getLogger(SmsAliNoticeDispatcher.class);

    public String getNoticeType() {
        return NoticeType.EMAIL.name().toLowerCase() + "Ali";
    }

    @Override
    public void dispatcher(EmailNoticeTarget notice) {
        logger.info("email-ali dispatcher");
    }
}