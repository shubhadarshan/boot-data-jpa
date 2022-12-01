package in.spdev;

import in.spdev.entity.Order;
import in.spdev.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class H2DbApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrder() {
        Order order = Order.builder().product(Product.builder().productName("sku").productPrice(1122).build()).build();
        orderRepository.save(order);
    }

    
}
