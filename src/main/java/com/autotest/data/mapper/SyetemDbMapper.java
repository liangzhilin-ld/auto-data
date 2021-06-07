package com.autotest.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.autotest.data.mode.SyetemDb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liangzhilin
 * @since 2020-10-23
 */
@Mapper
@Component
public interface SyetemDbMapper extends BaseMapper<SyetemDb> {

}
