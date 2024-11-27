package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 0);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(25f, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        String expectedReceipt = String.format("(==== Булочка ====)%n= sauce Соус =%n(==== Булочка ====)%n%nPrice: %5f%n", 25f);
        assertEquals("Чек не соотвествует ожидаемому", expectedReceipt, burger.getReceipt());
    }
}
