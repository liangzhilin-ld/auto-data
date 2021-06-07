package com.autotest.data.mapper;

import org.apache.ibatis.annotations.Select;
import com.autotest.data.mode.ApiSwagger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liangzhilin
 * @since 2021-03-03
 */
public interface ApiSwaggerMapper extends BaseMapper<ApiSwagger> {
	@Select("SELECT max(ID) FROM api_swagger")
	int selectMaxId();
}
