package com.example.ssmspringboot.service.Resource;

import com.example.ssmspringboot.service.ResourceInfo;
import java.lang.annotation.*;

@ResourceInfo(value = "client", type = 10)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientResource {
}
