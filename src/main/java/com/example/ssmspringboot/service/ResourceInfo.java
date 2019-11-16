package com.example.ssmspringboot.service;

import java.lang.annotation.*;

/**
 * Table表格:
 * staff-5
 * client-10
 * expired_food-15
 * export_record-20
 * manufacture_design-25
 * manufacture_result-30
 * order_details-35
 * order_form-40
 * payment-45
 * product_criteria-50
 * raw_materials_criteria-55
 * product_warehouse-60
 * raw_materials_warehouse-65
 * refund_application-70
 *
 *View视图:
 *
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ResourceInfo {
    String value();
    int type();
}
