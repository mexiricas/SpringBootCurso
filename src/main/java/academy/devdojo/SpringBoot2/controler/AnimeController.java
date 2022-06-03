package academy.devdojo.SpringBoot2.controler;

import academy.devdojo.SpringBoot2.domain.Anime;
import academy.devdojo.SpringBoot2.resquest.AnimePostRequestBody;
import academy.devdojo.SpringBoot2.resquest.AnimePutRequestBody;
import academy.devdojo.SpringBoot2.service.AnimeService;
import academy.devdojo.SpringBoot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final  DateUtil dateUtil = new DateUtil();
    @Autowired
    private  AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>( animeService.lisAll() , HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity< Anime> findbyID(@PathVariable long id){
        return ResponseEntity.ok(animeService.findByIdOrException(id));
    }
    @GetMapping(path = "/find")
    public ResponseEntity< List<Anime>> findByName(@RequestParam String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }
    @PostMapping
    public ResponseEntity<Anime>  save(@RequestBody  @Valid AnimePostRequestBody animePostRequestBody){
        return  new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity< Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity< Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
