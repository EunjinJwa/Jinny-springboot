package com.jinny.java.springboot.lottery.controller;

import com.google.gson.Gson;
import com.jinny.java.springboot.lottery.common.Constants;
import com.jinny.java.springboot.lottery.common.LuckyNumberType;
import com.jinny.java.springboot.lottery.dto.LottoNumber;
import com.jinny.java.springboot.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController()
public class LotteryController {

    private RestTemplate restTemplate;

    @Autowired
    private LotteryService lotteryService;

    @GetMapping(path = "/lotto/test")
    public String testr(){
        return "Number is 999";
    }

    /**
     * 로또 당첨번호 등록
     * @param number
     * @return
     */
    @GetMapping(path = "/lotto/put/{number}")
    public String putLottoNumber(@PathVariable String number) {

        restTemplate = new RestTemplate();

        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+number;
        HttpHeaders headers01 = new HttpHeaders();
        headers01.setContentType(MediaType.APPLICATION_JSON);

        URI uri = UriComponentsBuilder.fromHttpUrl(url).build(true).toUri();
        HttpEntity request = new HttpEntity(headers01);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        Gson gson = new Gson();
        LottoNumber result = gson.fromJson(responseEntity.getBody(), LottoNumber.class);

        List numList = Arrays.asList(result.getDrwtNo1(), result.getDrwtNo2(), result.getDrwtNo3(), result.getDrwtNo4(), result.getDrwtNo5(), result.getDrwtNo6());

        HashMap paramMap = new HashMap<>();
        paramMap.put("date", result.getDrwNoDate());
        paramMap.put("drwNo", result.getDrwNo());
        for (int i = 0; i < numList.size(); i++) {

           paramMap.put("numberType", "DRWT");
           paramMap.put("drwtNo", numList.get(i));
            lotteryService.insertLottoNumber(paramMap);
        }

        paramMap.put("numberType", "BONUS");
        paramMap.put("drwtNo", result.getBnusNo());
        lotteryService.insertLottoNumber(paramMap);


        return result.toString();
    }

    @GetMapping(path = "/lotto/get/{count}", produces = "application/json")
    public String getLottoNumber(@PathVariable Integer count,
                                                          @RequestParam String key){
        LuckyNumberType luckyNumberType;
        count = count > 5 ? 5 : count;
        if (!Constants.LOTTO_AUTHORITY_KEY.getAsList().contains(key)) {
            luckyNumberType = new LuckyNumberType(key, count);
            lotteryService.getLottoNumber(luckyNumberType);
            return luckyNumberType.toString();
        } else {
            return "[ " + key + " ] is not an authenticated key.";
        }


    }



}
