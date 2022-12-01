package in.spdev.enity;

import in.spdev.generators.ChessGameId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_chess_game")
@IdClass(ChessGameId.class)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ChessGame {
    @Id
    @SequenceGenerator(name = "chess_players_gen", sequenceName = "chess_players_gen", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chess_players_gen")
    private Long id;
    @Id
    private String country;
    @CreationTimestamp
    private LocalDate date;
    private int round;
}
