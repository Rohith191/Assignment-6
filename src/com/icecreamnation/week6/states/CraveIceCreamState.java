package com.icecreamnation.week6.states;

import com.icecreamnation.week6.*;

public class CraveIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public CraveIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		return false;
	}

	@Override
	public void doThingsToSatisfy() {
		System.out.println("Craving icecream...");
		addict.transitionTo(AddictStates.Eating);
	}
	
}
