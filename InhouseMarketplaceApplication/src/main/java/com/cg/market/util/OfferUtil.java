package com.cg.market.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.market.dto.OfferDetails;
import com.cg.market.entities.Offer;

@Component
public class OfferUtil {

	public OfferDetails toDetails(Offer off) {
		return new OfferDetails(off.getOfferId(), off.isAvailable(), off.getAvailableUpto(), off.getProd());
	}

	public List<OfferDetails> toDetails(List<Offer> offers) {
		List<OfferDetails> detailList = new ArrayList<>();
		for (Offer off : offers) {
			OfferDetails details = toDetails(off);
			System.out.println(details);
			detailList.add(details);
		}

		return detailList;
	}

}
