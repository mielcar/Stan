package pl.tesseract.stan.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BitBayHistory {

    @Id
    private Long id;
}
