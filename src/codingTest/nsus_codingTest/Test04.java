package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test04 {

	/**
	 * [문제원본]
	 * 주어진 코드는 논리 흐름상 문제가 없는 코드이지만 처리 요청이 많은 경우 은행에 남아있는 잔고가 맞아 떨어지지 않습니다.
		문제를 일으키고 있는 부분을 찾아 수정해주세요.
		일단 문제를 수정하고 난 뒤에 해당 코드가 성능 저하를 일으킬 수 있다고 생각되시면 이를 최소화 할 수 있는 방법도 함께 고민해주세요.
		제시된 코드가 입출력을 모두 처리하고 있지만, 디버깅을 위해 입력값 분석이 필요하시다면 아래 내용을 참고해 주세요.
		입력은 각 계좌에 요청할 거래를 나타냅니다. "계좌:거래금액" 형식의 문자열로 표시된 요청이 comma (,) 로 구분된 한 줄의 목록이 표준 입력으로 주어집니다.
		예를 들면 다음과 같은 입력을 처리한다면,
		
		A:10,A:-10
		결과는 다음과 같아야 합니다. (A 계좌에 10 입금, 10 출금 = 0)
		A:0
		또는 다음과 같은 입력이 있다면
		A:10,A:-5,B:5,B:5
		결과는 다음과 같아야 합니다.
		A:5
		B:10
		 
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();

			Bank bank = new Bank();
			bank.open(Arrays.stream(input.split(",")).map(TransactionRequest::new).collect(Collectors.toList()));

			if (bank.peakRequests <= 1) {
				System.err.println("WARN: Only one thread is used for processing. It can be a reason of low performance issues.");
			}

			System.out.println(bank.getCurrentAccountReport());

		} catch (Exception e) {

		}
	}
	
	 static class TransactionRequest {
	        String accountId;
	        Integer amount;

	        TransactionRequest(String order) {
	            String[] tokens = order.split(":", 2);
	            this.accountId = tokens[0].trim();
	            this.amount = Integer.valueOf(tokens[1].trim());
	        }
	    }

	    static class Account {
	        Integer balance = 0;
	        Integer transact(Integer amount) {
	            balance = balance + amount;
	            notifyAll();
	            return balance;
	        }
	    }

	    public static class Bank {
	        Map<String, Account> accounts = new HashMap<>();
	        Map<String, Integer> accountAccess = new HashMap<>();

	        private AtomicInteger currentRequestCount = new AtomicInteger();
	        private AtomicInteger accuntRequestCount = new AtomicInteger();
	        
	        int peakRequests = 0;

	        // synchronized 를 추가하여 계좌 입출금의 동시 처리를 제어한다. 
	        synchronized Integer request(TransactionRequest request) throws InterruptedException {
	        	
	        	accountAccess.put(request.accountId, accuntRequestCount.incrementAndGet());
	        	
	        	int accessCnt = accountAccess.get(request.accountId);
	        	
	        	while( accessCnt > 1 ) wait();
	        	
	        	if(accessCnt == 0 ){
	        		
	        	}
	        	
	            int newPeak = currentRequestCount.incrementAndGet();
	            if(peakRequests < newPeak) {
	                peakRequests = newPeak;
	            }
	            
	            Account account = accounts.get(request.accountId);
	            if(account == null) {
	                account = new Account();
	                accounts.put(request.accountId, account);
	            }

	            Integer remain = account.transact(request.amount);
	            Thread.sleep(5000);
	            currentRequestCount.decrementAndGet();
	            accountAccess.put(request.accountId, accuntRequestCount.incrementAndGet());
	            
	            return remain;
	        }

	        void open(List<TransactionRequest> requests) {
	            /* Parallel processing is intended. It's not a reason of the problem. */
	            // requests.parallelStream().forEach(this::request);
	        }

	        String getCurrentAccountReport() {
	            return accounts.entrySet().stream()
	                    .map(e -> String.format("%s:%d", e.getKey(), e.getValue().balance))
	                    .collect(Collectors.joining("\n"));
	        }
	    }
}
