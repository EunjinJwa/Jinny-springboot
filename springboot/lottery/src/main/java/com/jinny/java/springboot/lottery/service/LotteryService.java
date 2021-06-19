package com.jinny.java.springboot.lottery.service;

import com.google.gson.Gson;
import com.jinny.java.springboot.lottery.common.LottoParam;
import com.jinny.java.springboot.lottery.common.LuckyNumberType;
import com.jinny.java.springboot.lottery.mapper.LotteryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;

@Service
public class LotteryService {

    @Autowired
    private LotteryMapper lotteryMapper;

    private static final Logger logger = LoggerFactory.getLogger(LotteryService.class);
    Gson gson = new Gson();

    public void insertLottoNumber(HashMap paramMap) {
        lotteryMapper.insertLottoNumber(paramMap);
    }

    public LuckyNumberType getLottoNumber(LuckyNumberType luckyNumberType) {

        HashMap<Integer, List<Integer>> result = new HashMap<>();

        // 마지막 회차 번호
        final int lastDrwNo = lotteryMapper.selectLastDrwNo();

        for (int i = 0; i < luckyNumberType.getCount(); i++) {
            List<Integer> numberList = new ArrayList<>();

            // number 1
            getLottoNumberToList(() -> getLottoNumber6(lastDrwNo), numberList);

            // number 2
            getLottoNumberToList(() -> getLottoNumber7(lastDrwNo), numberList);

            // number 3
            getLottoNumberToList(() -> getLottoNumberA(lastDrwNo, 10, 1), numberList);

            // number 4
            getLottoNumberToList(() -> getLottoNumberA(lastDrwNo, 7, 1), numberList);

            // number 5
            getLottoNumberToList(() -> getLottoNumberA(lastDrwNo, 15, 2), numberList);

            // number 6
            getLottoNumberToList(() -> getLottoNumber1(lastDrwNo), numberList);

            Collections.sort(numberList);
            result.put(i+1, numberList);
        }
        luckyNumberType.setNumberMap(result);
        logger.info("Number : {}", gson.toJson(luckyNumberType));

        return luckyNumberType;
    }

    private List<Integer> getLottoNumberToList(Supplier<List> s, List<Integer> numberList) {
        List<Integer> list = s.get();

        int number;
        int randomNum;
        do {
            randomNum = getRandomNum(list.size());
            number = list.get(randomNum);
        } while (numberList.contains(number));

        numberList.add(number);
        return numberList;
    }


    /**
     * 최근 20회 중 최다 당첨 숫자 10개
     * @return
     */
    private List<Integer> getLottoNumber1(int LastDrwNo) {
        int lastNum = LastDrwNo - 20;
        return lotteryMapper.getLottoNumber1(lastNum);
    }

    /**
     * 최근 10회 중 2회 이하
     * @return
     */
    private List<Integer> getLottoNumber2(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 10;
        return lotteryMapper.getLottoNumber2(lastNum);
    }

    /**
     * 최근 15회 중 4회 이상 당첨 숫자
     * @return
     */
    private List<Integer> getLottoNumber3(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 15;
        return  lotteryMapper.getLottoNumber3(lastNum);
    }

    /**
     * 최근 10회 중 2~3회 당첨 숫자
     * @return
     */
    private List<Integer> getLottoNumber4(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 10;
        return  lotteryMapper.getLottoNumber4(lastNum);
    }

    /**
     * 최근 10회 중 2회 이하 당첨 숫자 중 최근 3회 내에 당첨 숫자가 있는 숫자
     * @return
     */
    private List<Integer> getLottoNumber5(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 10;
        return lotteryMapper.getLottoNumber5(lastNum);
    }

    /**
     * 최근 10회 중 2회 이하 당첨 숫자 중 10보다 작은 수
     * @return
     */
    private List<Integer> getLottoNumber6(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 10;
        return lotteryMapper.getLottoNumber6(lastNum);
    }

    /**
     * 최근 10회 1회 당첨 숫자 중 10과 같거나 큰 수
     * @return
     */
    private List<Integer> getLottoNumber7(Integer lastDrwNo) {
        int lastNum = lastDrwNo - 10;
        return lotteryMapper.getLottoNumber7(lastNum);
    }


    /**
     * 최근 n회차 중 c번 당첨 번호
     * @param lastDrwNo
     * @param lastCnt
     * @param cnt
     * @return
     */
    private List<Integer> getLottoNumberA(Integer lastDrwNo, Integer lastCnt, Integer cnt) {
        LottoParam param = new LottoParam(lastDrwNo, lastDrwNo - lastCnt, cnt);
        return lotteryMapper.getLottoNumberA(param);
    }



    private int getRandomNum(int numberBound) {
        Random random = new Random();
        Date today = new Date();
        int randomNumber = random.nextInt(numberBound);
        return randomNumber;
    }


    private List<Integer> addNumberList(List<Integer> numberList, Supplier<Integer> f) {
        int number = f.get();
        while (numberList.contains(number)) {
            number = f.get();
        }
        numberList.add(number);
        return numberList;
    }




}
