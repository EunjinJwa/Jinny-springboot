# lottery service
로또 번호 생성기

> API

* 로또 당첨번호 등록 (회차 지정)
  * PUT /lotto/put/{number} 
  * number : 회차번호
* 로또 당첨번호 추천
  * GET /lotto/get/{count}?key={key}
  * count : 당첨번호 출력할 셋트 count
  * key : 허용 키 


