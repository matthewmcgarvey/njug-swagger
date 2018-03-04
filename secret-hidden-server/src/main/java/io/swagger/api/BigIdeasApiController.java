package io.swagger.api;

import io.swagger.Database;
import io.swagger.model.BigIdea;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-03T14:05:28.679-06:00")

@Controller
public class BigIdeasApiController implements BigIdeasApi {
    private final Database database;

    @org.springframework.beans.factory.annotation.Autowired
    public BigIdeasApiController(Database database) {
        this.database = database;

        BigIdea bi1 = new BigIdea();
        bi1.setRating(2);
        bi1.setName("Rule the World");
        bi1.setDetails("Step 1: Rule the world.");
        database.save(bi1);

        BigIdea bi2 = new BigIdea();
        bi2.setRating(8);
        bi2.setName("Pillow that combs your hair while you sleep");
        bi2.setDetails("I watch too much Psych");
        database.save(bi2);
    }

    public ResponseEntity<BigIdea> create(@ApiParam(value = "", required = true) @Valid @RequestBody BigIdea bigIdea) {
        Optional<BigIdea> save = database.save(bigIdea);
        if (save.isPresent()) {
            return new ResponseEntity<>(save.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<BigIdea>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<BigIdea> delete(@Min(1) @ApiParam(value = "ID of specific Big Idea", required = true) @PathVariable("id") Integer id) {
        Optional<BigIdea> delete = database.delete(id);
        if (delete.isPresent()) {
            return new ResponseEntity<>(delete.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BigIdea> get(@Min(1) @ApiParam(value = "ID of specific Big Idea", required = true) @PathVariable("id") Integer id) {
        Optional<BigIdea> bigIdea = database.get(id);
        if (bigIdea.isPresent()) {
            return new ResponseEntity<>(bigIdea.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<BigIdea>> getAll(@Min(1) @ApiParam(value = "Choose how many big ideas you want back (if not specified, all will be returned)") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        List<BigIdea> bigIdeas = limit != null
                ? database.getAll(limit)
                : database.getAll();
        return new ResponseEntity<>(bigIdeas, HttpStatus.OK);
    }

    public ResponseEntity<BigIdea> update(@Min(1) @ApiParam(value = "ID of specific Big Idea", required = true) @PathVariable("id") Integer id, @ApiParam(value = "", required = true) @Valid @RequestBody BigIdea updatedBigIdea) {
        Optional<BigIdea> update = database.update(id, updatedBigIdea);
        if (update.isPresent()) {
            return new ResponseEntity<>(update.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(Exception exception) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
