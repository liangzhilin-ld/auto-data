package com.autotest.data.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import lombok.extern.apachecommons.CommonsLog;

/**
 * 自定义TypeHandler    
 * <p>
 * 其他自定义方式https://blog.csdn.net/qq_31775377/article/details/108117337,
 * 对象、列表、数组与数据库字段映射可用FastjsonTypeHandler,
 * FastjsonTypeHandler使用参考https://www.cnblogs.com/liangweiping/p/12835377.html
 * @author Techstar
 *
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({List.class})  
@CommonsLog

//extends BaseTypeHandler 
public class CustomTypeHandler implements TypeHandler<List<String>>{
	@Override
    public void setParameter(PreparedStatement ps, int i,
                             List<String> parameter, JdbcType jdbcType) throws SQLException {
        log.info("method ====>>> setParameter");
        String hobbys = dealListToOneStr(parameter);
        ps.setString(i , hobbys);
    }
 
    /**
     * 集合拼接字符串
     * @param parameter
     * @return
     */
    private String dealListToOneStr(List<String> parameter){
        if(parameter == null || parameter.size() <=0)
            return null;
        String res = "";
        for (int i = 0 ;i < parameter.size(); i++) {
            if(i == parameter.size()-1){
                res+=parameter.get(i);
                return res;
            }
            res+=parameter.get(i)+".separator";
        }
        return null;
    }
     
    @Override
    public List<String> getResult(ResultSet rs, String columnName)
            throws SQLException {
        log.info("method ====>>> getResult(ResultSet rs, String columnName)");
       
        String resString=rs.getString(columnName);
        if(resString==null||resString.length()==0)
        	return new ArrayList<String>();
        return Arrays.asList(resString.split(".separator"));
    }
 
    @Override
    public List<String> getResult(ResultSet rs, int columnIndex)
            throws SQLException {
        log.info("method ====>>> getResult(ResultSet rs, int columnIndex)");
        String resString=rs.getString(columnIndex);
        if(resString==null||resString.length()==0)
        	return new ArrayList<String>();
        return Arrays.asList(resString.split(".separator"));
    }
 
    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException{
        log.info("method ====>>> getResult(CallableStatement cs, int columnIndex)");
        
        String hobbys = cs.getString(columnIndex);
        if(hobbys==null||hobbys.length()==0)
        	return new ArrayList<String>();
        return Arrays.asList(hobbys.split(".separator"));
    }
}
