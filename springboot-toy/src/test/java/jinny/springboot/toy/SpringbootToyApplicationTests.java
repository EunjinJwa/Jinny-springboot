package jinny.springboot.toy;

import jinny.springboot.toy.config.TestProperties;
import jinny.springboot.toy.config.TestProperties2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootToyApplicationTests {

	@Autowired
	TestProperties2 testProperties2;
	@Test
	void contextLoads() {


		System.out.println(TestProperties.value1);
		System.out.println(TestProperties.value3);
		System.out.println();

		System.out.println("========================");

		System.out.println(testProperties2.getValue1());
		System.out.println(testProperties2.getValue2());



	}

}
