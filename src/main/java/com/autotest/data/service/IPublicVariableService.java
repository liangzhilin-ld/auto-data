package com.autotest.data.service;

import com.autotest.data.mode.PublicVariable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liangzhilin
 * @since 2021-03-03
 */
public interface IPublicVariableService extends IService<PublicVariable> {
	public String getKeyValue(String varName);
}
