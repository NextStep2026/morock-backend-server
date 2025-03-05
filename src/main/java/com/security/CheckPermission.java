package com.security;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckPermission {

    /**
     * 체크할 권한 키 (ex: "POST_DELETE")
     */
    String permissionKey();
}
