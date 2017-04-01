/*
 * Copyright 2016 Lime - HighTech Solutions s.r.o.
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
package io.lime.webauth.model.entity;

/**
 * @author Roman Strobl
 */
public class RegistrationMessage {

    private String action;
    private boolean performUITest;

    public RegistrationMessage() {
    }

    public RegistrationMessage(String action, boolean performUITest) {
        this.action = action;
        this.performUITest = performUITest;
    }

    public String getAction() {
        return action;
    }

    public boolean getPerformUITest() {
        return performUITest;
    }

    public String toString() {
        return "action: " + action + ", performUITest: " + performUITest;
    }
}
