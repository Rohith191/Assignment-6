package com.icecreamnation.week6.states;

import com.icecreamnation.week6.*;

public class SatisfiedIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public SatisfiedIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		System.out.println("Satisfied! for now..");
		addict.calcCalories();
		return true;
	}

	@Override
	public void doThingsToSatisfy() {
		System.out.println("No need to do anything for now..");
	}
	
}
