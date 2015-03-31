package fancyfoods.offers.impl;

import java.util.List;

import fancyfoods.offers.SpecialOffer;

 
public interface OfferListAdjuster {
	public List<SpecialOffer> adjust(List<SpecialOffer> offers);
}

