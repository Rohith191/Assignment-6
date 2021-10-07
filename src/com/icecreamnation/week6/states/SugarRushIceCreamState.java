package com.icecreamnation.week6.states;

import com.icecreamnation.week6.*;

public class SugarRushIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public SugarRushIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		return false;
	}

	@Override
	public void doThingsToSatisfy() {
		System.out.println("Having Sugar Rush !!");
		addict.transitionTo(AddictStates.WalkItOff);
	}
	
}
