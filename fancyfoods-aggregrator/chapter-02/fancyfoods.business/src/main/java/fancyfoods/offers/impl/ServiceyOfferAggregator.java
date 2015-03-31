package fancyfoods.offers.impl;

import java.util.List;

import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

public class ServiceyOfferAggregator implements CurrentOffers {

    private static final int MAX_OFFERS = 4;
    private List<SpecialOffer> offers;

    public void setOffers(List<SpecialOffer> offers) {
        this.offers = offers;
    }

    
    
    public List<SpecialOffer> getCurrentOffers() {
        OfferListAdjuster[] adjusters = new OfferListAdjuster[] {
            new OfferSorter(), new OfferTrimmer() };
        for (OfferListAdjuster adjuster : adjusters) {
            offers = adjuster.adjust(offers);
        }
        return offers;
    }

}
