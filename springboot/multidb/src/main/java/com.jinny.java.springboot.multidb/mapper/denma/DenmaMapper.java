package com.jinny.java.springboot.multidb.mapper.denma;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Mapper
public interface DenmaMapper {


    void insertEmoji(HashMap paramMap);

    String selectEmoji(HashMap paramMap);
}
