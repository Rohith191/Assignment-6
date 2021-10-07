package com.icecreamnation.week6.states;

import java.util.Random;

import com.icecreamnation.week6.*;

public class EatingIceCreamState implements AddictState{
	
	IceCreamAddict addict;
	public EatingIceCreamState(IceCreamAddict addict)
	{
		this.addict = addict;
	}
	
	@Override
	public boolean isSatisfied() {
		return false;
	}

	@Override
	public void doThingsToSatisfy() {
		System.out.println("Eating icecream...");
		addict.addSugarIntoBody(100);
		if(addict.hasExcess()) {
			addict.transitionTo(AddictStates.SugarRush);
			return;
		}
		Random r = new Random();
		var mood = r.nextInt(5);
		if(mood == 4) {
			System.out.println("Well, i am in good mood, stopping for now");
			addict.transitionTo(AddictStates.Satisfied);
		}else {
			//System.out.println("Nope, i want more..");
			addict.transitionTo(AddictStates.UnSatisfied);
		}
	}
	
}
