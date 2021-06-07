package com.autotest.data.service.impl;

import com.autotest.data.mode.ApiSwagger;
import com.autotest.data.mapper.ApiSwaggerMapper;
import com.autotest.data.service.IApiSwaggerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangzhilin
 * @since 2021-03-03
 */
@Service
public class ApiSwaggerServiceImpl extends ServiceImpl<ApiSwaggerMapper, ApiSwagger> implements IApiSwaggerService {

}
