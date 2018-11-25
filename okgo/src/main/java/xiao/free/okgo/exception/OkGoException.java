/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xiao.free.okgo.exception;

import xiao.free.okgo.model.ErrorCode;

/**
 * ================================================
 * 作    者：
 * 版    本：1.0
 * 创建日期：16/8/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class OkGoException extends Exception {
    private static final long serialVersionUID = -8641198158155821498L;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public OkGoException(int code, String message) {
        super(message);
        this.code = code;
    }

    public static OkGoException REQUEST_ALREADY_EXECUTED() {
        return new OkGoException(ErrorCode.CODE_REQUEST_ALREADY_EXECUTED, "Request Already executed!");
    }
}
