package com.autotest.data;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
@Component
public class MyMetaObjectHandler implements MetaObjectHandler{
	/**
     * 插入数据自动填充时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 第一个参数fieldName对应实体类属性值
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新数据自动更新时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
