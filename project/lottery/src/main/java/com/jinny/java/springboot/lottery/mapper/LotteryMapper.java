package com.jinny.java.springboot.lottery.mapper;

import com.jinny.java.springboot.lottery.common.LottoParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface LotteryMapper {
    void insertLottoNumber(HashMap paramMap);

    List<Integer> getLottoNumber1(int lastNum);

    List<Integer> getLottoNumber2(int lastNum);

    List<Integer> getLottoNumber3(int lastNum);

    List<Integer> getLottoNumber4(int lastNum);

    List<Integer> getLottoNumber5(int lastNum);

    int selectLastDrwNo();

    List<Integer> getLottoNumber6(int lastNum);

    List<Integer> getLottoNumber7(int lastNum);

    List<Integer> getLottoNumber8(int lastNum);

    List<Integer> getLottoNumber9(int lastNum);

    List<Integer> getLottoNumberA(LottoParam param);
}
