package in.spdev.boot.springbootdatajpacustomgenerators;

import in.spdev.boot.springbootdatajpacustomgenerators.entities.OrderDetailsEntity;
import in.spdev.boot.springbootdatajpacustomgenerators.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDatajpaCustomGeneratorsApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveOrder(){
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity("sp");
        orderRepository.save(orderDetailsEntity);
    }
}
