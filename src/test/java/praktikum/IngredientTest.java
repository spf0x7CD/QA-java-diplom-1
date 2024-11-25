package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    private String name;
    private float price;

    @Before
    public void setUp() {
        Faker faker = new Faker();
        name = faker.food().ingredient();
        price = (float) faker.number().randomDouble(2, 0, 999);
        ingredient = new Ingredient(null, name, price);
    }

    @Test
    public void testGetName() {
        assertEquals("Название не соотвествует переданному в конструктор", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Цена не соотвествует переданной в конструктор", price, ingredient.getPrice(), 0.01f);
    }
}
