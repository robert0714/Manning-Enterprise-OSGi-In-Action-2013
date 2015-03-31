package fancyfoods.chocolate;

import java.util.Calendar;

import fancyfoods.food.Food;
import fancyfoods.offers.SpecialOffer;

public class RomanticChocolateOffer implements SpecialOffer {

    
    public String getDescription() {
        return "A wonderful surprise for someone you want to impress.";
    }

    
    public Food getOfferFood() {
        if (isNearValentinesDay()) { 
            return new HeartShapedChocolates();
        } else {
            return new SquareChocolates();
        }
    }

    private boolean isNearValentinesDay() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.MONTH) == Calendar.FEBRUARY
            && today.get(Calendar.DAY_OF_MONTH) <= 14;
    }
}
