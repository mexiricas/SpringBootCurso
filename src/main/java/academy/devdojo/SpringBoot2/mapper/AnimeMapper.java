package academy.devdojo.SpringBoot2.mapper;

import academy.devdojo.SpringBoot2.domain.Anime;
import academy.devdojo.SpringBoot2.resquest.AnimePostRequestBody;
import academy.devdojo.SpringBoot2.resquest.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class AnimeMapper {


    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBodytRequestBody);
}
