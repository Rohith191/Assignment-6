package com.icecreamnation.week6.states;

import com.icecreamnation.week6.*;

public class WalkItOffIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public WalkItOffIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		return false;
	}

	@Override
	public void doThingsToSatisfy() {
		while(addict.hasExcess()) {
			System.out.println("Walking It Off..");
			addict.removeSugarFromBody(100);
		}
		addict.transitionTo(AddictStates.Satisfied);
	}
	
}
