package com.autotest.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.autotest.data.mode.TestScheduled;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liangzhilin
 * @since 2020-11-11
 */
@Mapper
@Component
public interface TestScheduledMapper extends BaseMapper<TestScheduled> {

}
