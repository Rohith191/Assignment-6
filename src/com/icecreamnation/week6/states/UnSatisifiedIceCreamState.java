package com.icecreamnation.week6.states;

import com.icecreamnation.week6.*;

public class UnSatisifiedIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public UnSatisifiedIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		return false;
	}

	@Override
	public void doThingsToSatisfy() {
		System.out.println("Unsatisifed, will eat more ice cream");
		addict.transitionTo(AddictStates.Eating);
	}
	
}
