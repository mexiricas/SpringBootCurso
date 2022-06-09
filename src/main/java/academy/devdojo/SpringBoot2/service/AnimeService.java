package academy.devdojo.SpringBoot2.service;

import academy.devdojo.SpringBoot2.domain.Anime;
import academy.devdojo.SpringBoot2.exception.BadRequestException;
import academy.devdojo.SpringBoot2.mapper.AnimeMapper;
import academy.devdojo.SpringBoot2.repository.AnimeRepository;
import academy.devdojo.SpringBoot2.resquest.AnimePostRequestBody;
import academy.devdojo.SpringBoot2.resquest.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> lisAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }
    public Anime findByIdOrException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime ID not Found"));

    }

    /*
    @Transactional(rollbackFor = Exception.class ) Essa linha considera a transação caso acha uma exceção e o dado nao possa ser gravado
    o @Transactions da rollback na transação, lembrando que o Exception nao entra nessa exceção por isso a rollbackFor
    */
    public Anime save(AnimePostRequestBody animePostRequestBody)  {
//        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build()); linha como estava sem o Mapper
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());

//        Anime anime = Anime.builder()
//                .id(animePutRequestBody.getId())
//                .name(animePutRequestBody.getName()).build();
        animeRepository.save(anime);

    }
}
