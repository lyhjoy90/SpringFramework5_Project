package OrderSpringTest;

import static org.junit.jupiter.api.Assertions.*;

import mylab.order.di.xml.OrderService;
import mylab.order.di.xml.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class StudnetSpringTest {

	@Autowired
	private ShoppingCart shoppingCart;

	@Autowired
	private OrderService orderService;

	@Test
	void testShoppingCart() {
		// 1. shoppingCart 객체 Null 여부 검증
		assertNotNull(shoppingCart);

		// 2. 상품 개수(2개) 검증
		assertEquals(2, shoppingCart.getProducts().size());

		// 3. 첫 번째 상품 이름 ("노트북") 검증
		assertEquals("노트북", shoppingCart.getProducts().get(0).getName());

		// 4. 두 번째 상품 이름 ("스마트폰") 검증
		assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
	}

	@Test
	void testOrderService() {
		// 1. orderService 및 주입된 shoppingCart Null 여부 검증
		assertNotNull(orderService);
		assertNotNull(orderService.getShoppingCart());

		// 2. 총 주문 금액 계산 검증 (150,000 + 800,000 = 950,000)
		assertEquals(950000.0, orderService.calculateOrderTotal());
	}
}