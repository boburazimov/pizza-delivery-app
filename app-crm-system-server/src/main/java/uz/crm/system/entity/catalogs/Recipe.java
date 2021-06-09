package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.Duration;
import java.util.List;

/**
 * Вариант комплектации - рецептура, можно использовать для шаблонизации готовый блюд. TODO - нужно сделать сделать документ для Комплектации номенклатуры
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe extends AbsEntity {

    private String name; // Наименование Рецептуры

    @OneToOne
    private Product endProduct; // Конечный готовая блюда

    private Double amount;  // Кол-во ингредиента

    private Duration cookTime;  // Время приготовление

    @OneToMany
    private List<Product> ingredients; // Комплектующие продукты для блюдо.
}
