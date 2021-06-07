package com.autotest.data.service.impl;

import com.autotest.data.mode.ApiMock;
import com.autotest.data.mapper.ApiMockMapper;
import com.autotest.data.service.IApiMockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangzhilin
 * @since 2021-01-25
 */
@Service
public class ApiMockServiceImpl extends ServiceImpl<ApiMockMapper, ApiMock> implements IApiMockService {

}
