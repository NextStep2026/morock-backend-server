package com.security;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClubPermissionCheck {

    /**
     * 체크할 권한 키 (ex: "POST_DELETE")
     */
    String permission() default "";
}
