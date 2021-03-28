import com.jinny.java.springboot.multidb.proxy.PayProxy;
import com.jinny.java.springboot.multidb.proxy.Payment;
import com.jinny.java.springboot.multidb.proxy.Store;
import org.junit.Test;

public class StoreTest {

    @Test
    public void testPay() {
        Payment payProx = new PayProxy();
        Store store = new Store(payProx);
        store.buySomthing(200);
    }


}
