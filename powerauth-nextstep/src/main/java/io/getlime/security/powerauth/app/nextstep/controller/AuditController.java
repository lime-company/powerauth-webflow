/*
 * Copyright 2021 Wultra s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.getlime.security.powerauth.app.nextstep.controller;

import io.getlime.core.rest.model.base.request.ObjectRequest;
import io.getlime.core.rest.model.base.response.ObjectResponse;
import io.getlime.security.powerauth.lib.nextstep.model.request.CreateAuditRequest;
import io.getlime.security.powerauth.lib.nextstep.model.request.GetAuditListRequest;
import io.getlime.security.powerauth.lib.nextstep.model.response.CreateAuditResponse;
import io.getlime.security.powerauth.lib.nextstep.model.response.GetAuditListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for auditing.
 *
 * @author Roman Strobl, roman.strobl@wultra.com
 */
@RestController
@RequestMapping("audit")
public class AuditController {

    private static final Logger logger = LoggerFactory.getLogger(AuditController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ObjectResponse<CreateAuditResponse> createAudit(@RequestBody ObjectRequest<CreateAuditRequest> request) {
        return new ObjectResponse<>(new CreateAuditResponse());
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ObjectResponse<GetAuditListResponse> getAuditList(@RequestBody ObjectRequest<GetAuditListRequest> request) {
        return new ObjectResponse<>(new GetAuditListResponse());
    }

}
