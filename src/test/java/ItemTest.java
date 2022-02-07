import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Restaurant restaurant;
    @BeforeEach
    public void setThis(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>Order value<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    void get_Order_Value() {

        restaurant.addToCart("Sweet corn soup", 119);
        int total = restaurant.getOrderValue();
        assertEquals(total, 119);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>Order Value<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //>>>>>>>>>>>>>>>>>>>>>>>>>fail case<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() throws itemNotFoundException {

        assertThrows(itemNotFoundException.class,()->restaurant.searchFromMenu("cake"));
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>fail case<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}