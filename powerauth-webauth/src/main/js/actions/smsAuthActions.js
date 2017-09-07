/*
 * Copyright 2017 Lime - HighTech Solutions s.r.o.
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
import axios from "axios";
import {dispatchAction, dispatchError} from "../dispatcher/dispatcher";

export function getOperationData() {
    return function (dispatch) {
        axios.get("./api/auth/operation/detail").then((response) => {
            dispatch({
                type: "SHOW_SCREEN_SMS",
                payload: response.data
            });
        }).catch((error) => {
            dispatchError(dispatch, error);
        })
    }
}

export function init() {
    return function (dispatch) {
        axios.post("./api/auth/sms/init", {}).then((response) => {
            dispatch({
                type: "SHOW_SCREEN_SMS",
                payload: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }
}

export function authenticate(callback) {
    return function (dispatch) {
        axios.post("./api/auth/sms/authenticate", {}).then((response) => {
            switch (response.data.result) {
                case 'CONFIRMED': {
                    callback(false);
                    dispatchAction(dispatch, response);
                    break;
                }
                case 'CANCELED': {
                    dispatch({
                        type: "SHOW_SCREEN_ERROR",
                        payload: {
                            message: response.data.message
                        }
                    });
                    break;
                }
                case 'AUTH_FAILED': {
                    // handle timeout - action can not succeed anymore, show error
                    if (response.data.message === "authentication.timeout") {
                        dispatchAction(dispatch, response);
                        break;
                    }
                    // if there is no supported auth method, show error, there is no point in continuing
                    if (response.data.message === "error.noAuthMethod") {
                        dispatchAction(dispatch, response);
                        break;
                    }
                    callback(true);
                    dispatch({
                        type: "SHOW_SCREEN_SMS",
                        payload: {
                            info: "reload"
                        }
                    });
                    break;
                }
            }
        }).catch((error) => {
            callback(false);
            dispatchError(dispatch, error);
        })
    }
}

export function cancel() {
    return function (dispatch) {
        axios.post("./api/auth/sms/cancel", {}).then((response) => {
            dispatch({
                type: "SHOW_SCREEN_ERROR",
                payload: {
                    message: response.data.message
                }
            });
        }).catch((error) => {
            dispatchError(dispatch, error);
        })
    }
}
