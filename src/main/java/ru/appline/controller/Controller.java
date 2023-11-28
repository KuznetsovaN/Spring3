package ru.appline.controller;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.DegreeRequest;
import ru.appline.logic.SideResponse;
import ru.appline.logic.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    public static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

//    @PostMapping(value = "/createPet", consumes = "application/json")
//    public String createPet(@RequestBody Pet pet) {
//
//        if (petModel.getAll().isEmpty()) {
//            petModel.add(pet, newId.getAndIncrement());
//            return "Вы создали своего первого домашнего питомца! \nБудьте ответствены!";
//        } else {
//            petModel.add(pet, newId.getAndIncrement());
//            return "Вы создали домашнего питомца! \nВы на верном пути!)";
//        }
//    }

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageResponse> createPet(@RequestBody Pet pet) {
        if (petModel.getAll().isEmpty()) {
            petModel.add(pet, newId.getAndIncrement());
            return ResponseEntity.ok(new MessageResponse("Вы создали своего первого домашнего питомца! \nБудьте ответствены!"));
        } else {
            petModel.add(pet, newId.getAndIncrement());
            return ResponseEntity.ok(new MessageResponse("Вы создали домашнего питомца! \nВы на верном пути!)"));
        }
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }


//    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
//    public Pet getPet(@RequestBody Map<String, Integer> id) {
//        return petModel.getFromList(id.get("id"));
//    }




//    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<PetResponse> getPet(@RequestBody PetRequest petRequest) {
//        Pet pet = petModel.getFromList(petRequest.getId());
//
//        if (pet != null) {
//            return new ResponseEntity<>(new PetResponse("Питомец найден", pet), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(new PetResponse("Питомец не найден", null), HttpStatus.NOT_FOUND);
//        }
//    }


//    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<MessageResponse> getPet(@RequestBody Map<String, Integer> id) {
//        int requestId = id.get("id");
//        Pet pet = petModel.getFromList(requestId);
//
//        if (pet != null) {
//            return ResponseEntity.ok(new MessageResponse("Питомец найден"));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Питомец не найден"));
//        }
//    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getPet(@RequestBody Map<String, Integer> id) {
        int requestId = id.get("id");
        Pet pet = petModel.getFromList(requestId);

        if (pet != null) {
            return ResponseEntity.ok(pet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Питомец не найден"));
        }
    }

//    @PutMapping(value = "/editPet", consumes = "application/json")
//    public String editPet(@RequestBody Map<String, String> pet) {
//        int requestId = Integer.parseInt(pet.get("id"));
//        if (petModel.getAll().containsKey(requestId)) {
//            String name = pet.get("name");
//            String type = pet.get("type");
//            int age = Integer.parseInt(pet.get("age"));
//
//            petModel.editPet(requestId, name, type, age);
//            return "Вы изменили данные о своем питомце!";
//        } else {
//            return "Питомца с таким ID у вас еще нет";
//        }
//    }

    @PutMapping(value = "/editPet", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageResponse> editPet(@RequestBody Map<String, String> pet) {
        int requestId = Integer.parseInt(pet.get("id"));
        if (petModel.getAll().containsKey(requestId)) {
            String name = pet.get("name");
            String type = pet.get("type");
            int age = Integer.parseInt(pet.get("age"));

            petModel.editPet(requestId, name, type, age);
            return ResponseEntity.ok(new MessageResponse("Вы изменили данные о своем питомце!"));
        } else {
            return ResponseEntity.ok(new MessageResponse("Питомца с таким ID у вас еще нет"));
        }
    }


//    @DeleteMapping(value = "/deletePet", consumes = "application/json")
//    public String deletePet(@RequestBody Map<String, Integer> id) {
//        int requestId = id.get("id");
//
//        if (petModel.getAll().containsKey(requestId)) {
//            petModel.deletePet(requestId);
//
//            return "Питомец успешно удален";
//        } else {
//            return "Питомца с таким ID нет!";
//        }
//    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageResponse> deletePet(@RequestBody Map<String, Integer> id) {
        int requestId = id.get("id");

        if (petModel.getAll().containsKey(requestId)) {
            petModel.deletePet(requestId);

            return ResponseEntity.ok(new MessageResponse("Питомец успешно удален"));
        } else {
            return ResponseEntity.ok(new MessageResponse("Питомца с таким ID нет!"));
        }
    }

    //Вторая часть задания
    //  private Map<String, String> ranges = new HashMap<>();

//    @PostMapping("/ranges")
//    public void setRanges(@RequestBody Map<String, String> ranges) {
//        this.ranges = ranges;
//    }
//
//
//    @RestController
//    public class SideController {
//
//        @GetMapping("/side")
//        public SideResponse getSide(@RequestBody DegreeRequest request) {
//            int degree = request.getDegree();
//
//            for (Map.Entry<String, String> entry : ranges.entrySet()) {
//                String[] range = entry.getValue().split("-");
//                int start = Integer.parseInt(range[0]);
//                int end = Integer.parseInt(range[1]);
//
//                if (degree >= start && degree <= end) {
//                    return new SideResponse(entry.getKey());
//                }
//            }
//
//            return new SideResponse("Unknown");
//        }
//    }

    //Вторая часть задания
    @RestController
    public class CompassController {

        private Map<String, String> ranges = new HashMap<>();

        @PostMapping("/ranges")
        public void setRanges(@RequestBody Map<String, String> ranges) {
            this.ranges = ranges;
        }
//
//        @GetMapping(value = "/side", consumes = "application/json", produces = "application/json")
//        @ResponseBody
//        public SideResponse getSide(@RequestBody String json) {
//            Gson gson = new Gson();
//            DegreeRequest request = gson.fromJson(json, DegreeRequest.class);
//
//            if (ranges.isEmpty()) {
//                // обработка случая, когда ranges пустой или не инициализирован
//                return new SideResponse("Unknown");
//            }
//
//            int degree = request.getDegree() % 360;
//
//            for (Map.Entry<String, String> entry : ranges.entrySet()) {
//                String[] range = entry.getValue().split("-");
//                int start = Integer.parseInt(range[0]);
//                int end = Integer.parseInt(range[1]);
//
//                if (end > start) {
//                    if (start <= degree && degree <= end) {
//                        return new SideResponse(entry.getKey());
//                    }
//                } else { // переход промежутка через 0
//                    if((start <= degree && degree <= end + 360) || (start - 360 <= degree && degree <= end)) {
//                        return new SideResponse(entry.getKey());
//                    }
//                }
//            }
//
//            return new SideResponse("Unknown");
//        }
//
//    }

    @GetMapping(value = "/side", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public SideResponse getSide(@RequestBody String json) {
        Gson gson = new Gson();
        DegreeRequest request = gson.fromJson(json, DegreeRequest.class);

        if (ranges.isEmpty()) {
            // обработка случая, когда ranges пустой или не инициализирован
            return new SideResponse("Unknown");
        }

        int degree = request.getDegree() % 360;

        for (Map.Entry<String, String> entry : ranges.entrySet()) {
            String[] range = entry.getValue().split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            if (end >= start) {
                if (start <= degree && degree <= end) {
                    return new SideResponse(entry.getKey());
                }
            } else { // переход промежутка через 0
                if((start <= degree && degree <= 360) || (0 <= degree && degree <= end)) {
                    return new SideResponse(entry.getKey());
                }
            }
        }

        return new SideResponse("Unknown");
    }
}
