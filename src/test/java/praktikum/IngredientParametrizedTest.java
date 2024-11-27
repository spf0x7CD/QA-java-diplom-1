package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, null, 0.0f);
        assertEquals("Тип не соотвествует переданному в конструктор", ingredientType, ingredient.getType());
    }
}
