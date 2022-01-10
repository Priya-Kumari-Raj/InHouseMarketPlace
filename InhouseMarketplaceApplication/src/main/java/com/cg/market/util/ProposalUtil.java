package com.cg.market.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.market.dto.ProposalDetails;
import com.cg.market.entities.Proposal;

@Component
public class ProposalUtil {

	public ProposalDetails toDetails(Proposal prop) {

		return new ProposalDetails(prop.getPropId(), prop.getProposal(), prop.getAmount(), prop.getProposalDate(),
				prop.getIsAccepted(), prop.getEmp(), prop.getProd());
	}

	public List<ProposalDetails> toDetails(List<Proposal> proposals) {
		List<ProposalDetails> detailList = new ArrayList<>();
		for (Proposal proposal : proposals) {
			ProposalDetails details = toDetails(proposal);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}

}
