package ru.appline.sides;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sides")
public class SidesController {

    private final SideService sideService;

    public SidesController(SideService sideService) {
        this.sideService = sideService;
    }

    @PostMapping(value = "/config")
    public Map<String, IntervalDegree> addSides(@RequestBody Map<String, String> sides) throws JsonProcessingException {
        for (Map.Entry<String, String> entry : sides.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sideService.addSide(key, value);
        }
        return sideService.getSides();
    }

    @GetMapping(value ="/whatSide",consumes = "application/json")
    public Side whatSide(@RequestBody Degree degree){
        return sideService.whatSide(degree);
    }

}