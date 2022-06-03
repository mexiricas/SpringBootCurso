package academy.devdojo.SpringBoot2.resquest;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
	@NotEmpty(message = "O nome do anime nao pode ser vazio")
	@NotNull(message = "O nome do anime nao pode ser nulo")
	private String name;
/*	@URL(message = "url not valid")//Teste mais de um field no retorno do handler
	@NotEmpty(message = "a url nao pode ser vazia")
	private String url;*/
}
