package pl.tesseract.stan.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tesseract.stan.domain.BitBayHistory;

public interface BitBayHistoryRepository extends CrudRepository<BitBayHistory, Long> {
}
