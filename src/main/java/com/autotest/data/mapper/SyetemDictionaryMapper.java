package com.autotest.data.mapper;

import org.apache.ibatis.annotations.Select;

import com.autotest.data.mode.SyetemDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liangzhilin
 * @since 2020-11-11
 */
public interface SyetemDictionaryMapper extends BaseMapper<SyetemDictionary> {
	@Select("SELECT max(FUNCTIONAL_ID) FROM syetem_dictionary")
	int selectMaxId();
}
