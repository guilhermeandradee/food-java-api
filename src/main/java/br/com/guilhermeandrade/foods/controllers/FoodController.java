package br.com.guilhermeandrade.foods.controllers;

import br.com.guilhermeandrade.foods.exceptions.ResourceNotFoundException;
import br.com.guilhermeandrade.foods.food.Food;
import br.com.guilhermeandrade.foods.food.FoodRepository;
import br.com.guilhermeandrade.foods.food.FoodRequestDTO;
import br.com.guilhermeandrade.foods.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "x", allowedHeaders = "x")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll()
                .stream()
                .map(FoodResponseDTO::new)
                .toList();
        return foodList;
    }

    @CrossOrigin(origins = "x", allowedHeaders = "x")
    @PostMapping("/criar")
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);

        if (data == null || foodData.getTitle() == null || foodData.getPrice() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos ou incompletos");
        }

        repository.save(foodData);
        System.out.println("criado");

        return ResponseEntity.ok("Post succes");
    }

    @CrossOrigin(origins = "x", allowedHeaders = "x")
    @PutMapping("{id}")
    public ResponseEntity<?> updateFood(@PathVariable Long id, @RequestBody FoodRequestDTO data){
        Optional<Food> optionalFood = repository.findById(id);

        if(optionalFood.isPresent()){
            Food foodToUpdate = optionalFood.get();

            foodToUpdate.setTitle(Objects.requireNonNullElse(data.title(), foodToUpdate.getTitle()));
            foodToUpdate.setImage(Objects.requireNonNullElse(data.image(), foodToUpdate.getImage()));
            foodToUpdate.setPrice(Objects.requireNonNullElse(data.price(), foodToUpdate.getPrice()));

            repository.save(foodToUpdate);
            System.out.println("ok");
            return ResponseEntity.ok(new FoodResponseDTO(foodToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comida não encontrada");
        }
    }

    @CrossOrigin(origins = "x", allowedHeaders = "x")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id){
        Optional<Food> optionalFood = repository.findById(id);

        if(optionalFood.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("Delete succes");
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comida não encontrada");
        }
    }


}
