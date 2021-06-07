package com.autotest.data.service.impl;

import com.autotest.data.mode.PublicVariable;
import com.autotest.data.mapper.PublicVariableMapper;
import com.autotest.data.service.IPublicVariableService;
import com.autotest.data.utils.PubliVariable;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.StrUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
@Primary
public class PublicVariableServiceImpl extends ServiceImpl<PublicVariableMapper, PublicVariable> implements IPublicVariableService {
	List<PublicVariable> list;
	@Autowired
	private PublicVariableMapper baseDao;
	
//	@Autowired
//	private IPublicVariableService gggd;
//	@PostConstruct
	public List<PublicVariable> SelectPublicVariable() {
		if(list!=null)return list;
    	QueryWrapper<PublicVariable> queryWrapper = new QueryWrapper<>();
    	queryWrapper.select("VAR_KEY","VAR_VALUE");
    	list =baseDao.selectList(queryWrapper);
    	//List<PublicVariable> list2=this.list(queryWrapper);
    	//List<PublicVariable> list2=gggd.list(queryWrapper);
    	return list;
	}
	/**
	 * 获取引用变量值 
	 * @param varName 如${__randomNum()}
	 * @return 如为自定义方法则返回计算结果，否则返回原值  
	 */
	@Override
	public String getKeyValue(String varName) {
		String funcName=StrUtil.subBetween(varName,"${","()}");
		if(StrUtil.isNotEmpty(funcName)) {
			Map<String,String> map=new HashMap<String,String>();
			List<PublicVariable> list=SelectPublicVariable();
			for (PublicVariable row : list) {
				map.put(row.getVarKey(), row.getVarValue());
			}
			if(map.containsKey(funcName)) {
				varName=new PubliVariable().execute(funcName, map.get(funcName));
			}
		}
		return varName;
	}
	
	
	public List<PublicVariable>  listParam(Integer page,Integer size,LambdaQueryWrapper<PublicVariable> wrapper) { 
	
		IPage<PublicVariable> pages = new Page<>(page, size);
		pages=this.page(pages,wrapper);
		return pages.getRecords();
	}
	public Boolean  updateParam(PublicVariable dic) { 
		LambdaUpdateWrapper<PublicVariable> queryWrapper=new UpdateWrapper<PublicVariable>().lambda();
		queryWrapper.eq(PublicVariable::getVarId, dic.getVarId());
		try {
			return this.update(dic,queryWrapper);
		} catch (Exception e) {
			new Exception("系统异常，修改参数表出错");
			return false;
		}
	}
	
	public Boolean  removeParam(Integer id) { 
		LambdaQueryWrapper<PublicVariable> wrapper=new QueryWrapper<PublicVariable>().lambda();
		wrapper.eq(PublicVariable::getVarId,id);
		try {
			return this.remove(wrapper);
		} catch (Exception e) {
			new Exception("系统异常，删除公共参数出错");
			return false;
		}
	}
}
