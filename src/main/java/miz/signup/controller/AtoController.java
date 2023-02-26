package miz.signup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import miz.signup.dto.ATO;
import miz.signup.entities.AtoEntity;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import miz.signup.repos.AtoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("api/ato")
@RestController
@Slf4j
public class AtoController {

    final AtoRepository atoRepository;
    final ObjectMapper objectMapper;




    public AtoController(AtoRepository atoRepository,ObjectMapper om) {
        this.atoRepository = atoRepository;
        this.objectMapper = om;


    }

    /**
     * Create a *new* ATO from a JSON Payload POSTED to the /api/ato endp;oint.
     * @param requestDto
     * @return
     */
    @PostMapping
    @ResponseBody
    public ATO post(@RequestBody ATO requestDto) {
        // Check to see if this already exists.
        Optional<AtoEntity> entity = atoRepository.findAtoEntityByIdentifier(requestDto.getHeader().getId());
        return DtoMapper.map(atoRepository.save(EntityMapper.map(requestDto)));
    }

    /**
     * Returns a list of *all* ATO's currently in the database. This operation could become slow if data volume grows very large.
     * @return
     */
    @GetMapping
    @ResponseBody
    public Collection<ATO> getAll() {
        Collection<AtoEntity> atoEntities = atoRepository.findAll();
        return DtoMapper.map(atoEntities);
    }

    /**
     * Get ATO by ID value.
     * Verbose error handling will tell you more than you want about what's broken if it fails.
     * @param id
     * @return an ATO Json if successful, Exception if the value is not present.
     */
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
       try {
           Optional<AtoEntity> entity = atoRepository.findById(id);
           if (entity.isPresent()) {
               return ResponseEntity.ok(DtoMapper.map(entity.get()));
           } else {
               return ResponseEntity.notFound().build();
           }
       }catch (Exception e){
           log.error(String.format("Error Occurred while looking up ATO with ID %s",id),e);
           return ResponseEntity.internalServerError().body(e);
       }
    }


}
