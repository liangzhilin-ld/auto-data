package com.autotest.data.service.impl;

import com.autotest.data.mode.ProjectManage;
import com.autotest.data.mode.SyetemDb;
import com.autotest.data.mode.SyetemDictionary;
import com.autotest.data.mapper.SyetemDictionaryMapper;
import com.autotest.data.service.ISyetemDictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangzhilin
 * @since 2020-11-11
 */
@Service
public class SyetemDictionaryServiceImpl extends ServiceImpl<SyetemDictionaryMapper, SyetemDictionary> implements ISyetemDictionaryService {

	public List<SyetemDictionary>  listDic(Integer page,Integer size,LambdaQueryWrapper<SyetemDictionary> wrapper) { 
		wrapper.eq(SyetemDictionary::getStatus, 1);
		IPage<SyetemDictionary> pages = new Page<>(page, size);
		pages=this.page(pages,wrapper);
		List<SyetemDictionary> gg=pages.getRecords();
		return gg;
	}
	public List<SyetemDictionary>  getDic(Integer id) { 
		QueryWrapper<SyetemDictionary> queryWrapper=new QueryWrapper<>();
		queryWrapper.lambda().eq(SyetemDictionary::getFunctionalId, id);
		return this.list(queryWrapper);
	}
	public Boolean  updateDic(List<SyetemDictionary> dic) { 
		LambdaQueryWrapper<SyetemDictionary> queryWrapper=new QueryWrapper<SyetemDictionary>().lambda();
		queryWrapper.eq(SyetemDictionary::getFunctionalId, dic.get(0).getFunctionalId());
		try {
			this.remove(queryWrapper);
			List<SyetemDictionary> isexist=this.list(queryWrapper);
			while(isexist.size()>0) {
				Thread.sleep(20000);
				isexist=this.list(queryWrapper);
			}
		} catch (Exception e) {
			new Exception("系统异常，修改字典表出错");
			return false;
		}
	
		return this.saveBatch(dic);
	}
	
	public Boolean  removeDic(Integer id) { 
		LambdaUpdateWrapper<SyetemDictionary> wrapper=new UpdateWrapper<SyetemDictionary>().lambda();
		wrapper.set(SyetemDictionary::getStatus, 0);
		wrapper.eq(SyetemDictionary::getFunctionalId,id);
		try {
			return this.update(wrapper);
		} catch (Exception e) {
			new Exception("系统异常，修改字典表出错");
			return false;
		}
	}
}
