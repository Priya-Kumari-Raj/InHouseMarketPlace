package com.cg.market.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.market.dto.RequirementDetails;
import com.cg.market.entities.Requirement;

@Component
public class RequirementUtil {

	public RequirementDetails toDetails(Requirement requ) {

		return new RequirementDetails(requ.getReqId(), requ.isFulfilled(), requ.getFulfilledOn(), requ.getProd());
	}

	public List<RequirementDetails> toDetails(List<Requirement> requirements) {
		List<RequirementDetails> detailList = new ArrayList<>();
		for (Requirement requirement : requirements) {
			RequirementDetails details = toDetails(requirement);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}

}
