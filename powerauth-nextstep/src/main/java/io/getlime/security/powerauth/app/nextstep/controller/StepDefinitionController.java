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
import io.getlime.security.powerauth.lib.nextstep.model.request.CreateStepDefinitionRequest;
import io.getlime.security.powerauth.lib.nextstep.model.request.DeleteStepDefinitionRequest;
import io.getlime.security.powerauth.lib.nextstep.model.response.CreateStepDefinitionResponse;
import io.getlime.security.powerauth.lib.nextstep.model.response.DeleteStepDefinitionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller class related to step definitions.
 *
 * @author Roman Strobl, roman.strobl@wultra.com
 */
@RestController
@RequestMapping(value = "step/definition")
public class StepDefinitionController {

    private static final Logger logger = LoggerFactory.getLogger(StepDefinitionController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ObjectResponse<CreateStepDefinitionResponse> createStepDefinition(@RequestBody ObjectRequest<CreateStepDefinitionRequest> request) {
        return new ObjectResponse<>(new CreateStepDefinitionResponse());
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ObjectResponse<DeleteStepDefinitionResponse> deleteStepDefinition(@RequestBody ObjectRequest<DeleteStepDefinitionRequest> request) {
        return new ObjectResponse<>(new DeleteStepDefinitionResponse());
    }

}
