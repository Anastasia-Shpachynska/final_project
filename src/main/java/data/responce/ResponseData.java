package data.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public record ResponseData<DATA>(DATA data) { }
