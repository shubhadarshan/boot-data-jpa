package in.spdev;

import in.spdev.enity.ChessGame;
import in.spdev.repository.ChessRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SequenceCompositePkApplicationTests {

    @Autowired
    private ChessRepository chessRepository;

    @Test
    public void gameSave(){
        chessRepository.save(ChessGame.builder()
                        .country("japan")
                        .round(1)
                        .build());
    }

}
