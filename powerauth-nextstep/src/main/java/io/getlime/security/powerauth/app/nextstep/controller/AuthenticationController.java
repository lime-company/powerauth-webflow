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
import io.getlime.security.powerauth.lib.nextstep.model.request.CombinedAuthenticationRequest;
import io.getlime.security.powerauth.lib.nextstep.model.request.CredentialAuthenticationRequest;
import io.getlime.security.powerauth.lib.nextstep.model.request.OtpAuthenticationRequest;
import io.getlime.security.powerauth.lib.nextstep.model.response.CombinedAuthenticationResponse;
import io.getlime.security.powerauth.lib.nextstep.model.response.CredentialAuthenticationResponse;
import io.getlime.security.powerauth.lib.nextstep.model.response.OtpAuthenticationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for user authentication.
 *
 * @author Roman Strobl, roman.strobl@wultra.com
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @RequestMapping(value = "credential", method = RequestMethod.POST)
    public ObjectResponse<CredentialAuthenticationResponse> authenticateWithCredential(@RequestBody ObjectRequest<CredentialAuthenticationRequest> request) {
        return new ObjectResponse<>(new CredentialAuthenticationResponse());
    }

    @RequestMapping(value = "otp", method = RequestMethod.POST)
    public ObjectResponse<OtpAuthenticationResponse> authenticateWithOtp(@RequestBody ObjectRequest<OtpAuthenticationRequest> request) {
        return new ObjectResponse<>(new OtpAuthenticationResponse());
    }

    @RequestMapping(value = "combined", method = RequestMethod.POST)
    public ObjectResponse<CombinedAuthenticationResponse> authenticateCombined(@RequestBody ObjectRequest<CombinedAuthenticationRequest> request) {
        return new ObjectResponse<>(new CombinedAuthenticationResponse());
    }


}
