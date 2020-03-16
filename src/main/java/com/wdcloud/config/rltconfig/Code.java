package com.wdcloud.config.rltconfig;


import java.util.HashMap;
import java.util.Map;

public enum Code {

    OK(200, "common.success"),
    ERROR(500, "common.error"),
    TOKEN_TIMEOUT(204, "common.token.timeout"),
    TOKEN_INVALID(205, "common.token.invalid"),
    REDIRECT(301, "common.redirect"),
    ACCOUNT_OTHER_DEVICE_LOGIN(302, "common.other.device.login"),
    DUPLICATE_NAME(430, "common.name.exists"),
    NOTHING(404, "common.name.is.not.exists")
    ;

    public final int code;
    public final String name;

    Code(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private final static Map<Integer, Code> valueMap = new HashMap<>();

    static {
        for (Code err : Code.values()) {
            valueMap.put(err.code, err);
        }
    }

    public static Code valueOf(int code) {
        Code err = valueMap.get(code);
        if (err != null) {
            return err;
        }
        return NOTHING;
    }
}
