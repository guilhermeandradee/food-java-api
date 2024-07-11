package br.com.guilhermeandrade.foods.food;

import java.math.BigDecimal;

public record FoodRequestDTO(String title, String image, BigDecimal price) {

}
