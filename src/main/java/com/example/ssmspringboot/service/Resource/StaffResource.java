package com.example.ssmspringboot.service.Resource;

import com.example.ssmspringboot.service.ResourceInfo;
import java.lang.annotation.*;

@ResourceInfo(value = "staff", type = 5)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StaffResource {
}

