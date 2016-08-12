package cn.com.pubinfo.ecp.cw.mapper.uab;

import cn.com.pubinfo.ecp.cw.model.uab.EabContact;

public interface EabContactMapper {
    int deleteByPrimaryKey(String contactid);

    int insert(EabContact record);

    int insertSelective(EabContact record);

    EabContact selectByPrimaryKey(String contactid);

    int updateByPrimaryKeySelective(EabContact record);

    int updateByPrimaryKey(EabContact record);
}