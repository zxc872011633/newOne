package com.mapper;

import com.pojo.deleteLog;
import org.apache.ibatis.annotations.Param;

public interface DelMapper {
    void insertIntoDatabase(@Param("delete") deleteLog del,@Param("delid") int DelId,@Param("info") String s1);
}
