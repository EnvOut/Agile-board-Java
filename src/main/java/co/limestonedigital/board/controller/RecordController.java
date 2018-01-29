package co.limestonedigital.board.controller;

import co.limestonedigital.board.model.RecordModel;
import co.limestonedigital.board.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Record controller
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/record")
public class RecordController {
    @Autowired
    @Qualifier("recordService")
    private RecordService recordService;

    /**
     * GET
     *
     * @return
     */
    @GetMapping(path = "/all")
    public List<RecordModel> getAllRecords() {
        return recordService.getAll();
    }

    /**
     * POST
     *
     * @param recordModel
     * @return
     */
    @PostMapping(path = "/")
    public RecordModel createRecord(@RequestBody RecordModel recordModel) {
        log.trace(": {}", recordModel);
        return recordService.createRecord(recordModel);
    }

    /**
     * PATCH
     *
     * @param id
     * @param recordModel
     * @return
     */
    @PatchMapping(path = "/{id}")
    public RecordModel changeRecord(@PathVariable("id") String id, @RequestBody RecordModel recordModel) {
        return recordService.changeById(id, recordModel);
    }

    /**
     * DELETE
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/{id}")
    public RecordModel deleteRecord(@PathVariable("id") String id) {
        return recordService.removeByID(id);
    }
}
