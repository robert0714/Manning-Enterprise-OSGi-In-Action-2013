package fancyfoods.offers.impl;

import java.util.*;

import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

public class OfferAggregator implements CurrentOffers {

	private static final int MAX_OFFERS = 4;
	private List<SpecialOffer> offers;
	private List<SpecialOffer> sortedOffers;

	 
	public void setOffers(List<SpecialOffer> offers) {
		this.offers = offers;
		sortOfferList();
	} 

	
	private synchronized void sortOfferList() {
		if (offers != null) {
			sortedOffers = new ArrayList<SpecialOffer>(offers);
			Collections.sort(sortedOffers, new OfferComparator());
			int offerCount = Math.min(MAX_OFFERS, sortedOffers.size());
			sortedOffers = sortedOffers.subList(0, offerCount);
		}
	}

	
	public synchronized List<SpecialOffer> getCurrentOffers() {
		return new ArrayList(sortedOffers);
	}

	
	public void bind(SpecialOffer offer) {
		sortOfferList();
	} 

	
	public synchronized void unbind(SpecialOffer offer) {
		if (sortedOffers != null) {
			sortedOffers.remove(offer);
		}
	}

	private class OfferComparator implements Comparator<SpecialOffer> {
		
		public int compare(fancyfoods.offers.SpecialOffer offer1,
				SpecialOffer offer2) {
			Double price = (Double) offer2.getOfferFood().getPrice();
			return price.compareTo(offer1.getOfferFood().getPrice());
		}
	}

}
