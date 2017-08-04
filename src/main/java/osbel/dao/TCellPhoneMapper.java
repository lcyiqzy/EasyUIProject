package osbel.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import osbel.bean.TCellPhone;
import osbel.bean.TCellPhoneExample;

public interface TCellPhoneMapper {
    long countByExample(TCellPhoneExample example);

    int deleteByExample(TCellPhoneExample example);

    int deleteByPrimaryKey(Integer phoneId);

    int insert(TCellPhone record);

    int insertSelective(TCellPhone record);

    List<TCellPhone> selectByExample(TCellPhoneExample example);

    TCellPhone selectByPrimaryKey(Integer phoneId);

    int updateByExampleSelective(@Param("record") TCellPhone record, @Param("example") TCellPhoneExample example);

    int updateByExample(@Param("record") TCellPhone record, @Param("example") TCellPhoneExample example);

    int updateByPrimaryKeySelective(TCellPhone record);

    int updateByPrimaryKey(TCellPhone record);
}