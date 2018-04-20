package com.xiaobai.rpass.rememberpass.utils;

import com.xiaobai.rpass.rememberpass.model.Remember;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MessageEvent {
    private Remember message;

    public MessageEvent(Remember message) {
        this.message = message;
    }

    public Remember getMessage() {
        return message;
    }

    public void setMessage(Remember message) {
        this.message = message;
    }
}
