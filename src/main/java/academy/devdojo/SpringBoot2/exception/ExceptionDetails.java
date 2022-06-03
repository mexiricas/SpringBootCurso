package academy.devdojo.SpringBoot2.exception;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String tittle;
    protected int status;
    protected String detail;
    protected String developerMessage;
    protected LocalDateTime timestamp;
}
