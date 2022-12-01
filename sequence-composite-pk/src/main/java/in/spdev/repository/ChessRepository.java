package in.spdev.repository;

import in.spdev.enity.ChessGame;
import in.spdev.generators.ChessGameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessRepository extends JpaRepository<ChessGame, ChessGameId> {
}