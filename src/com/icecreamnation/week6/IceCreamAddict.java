package com.icecreamnation.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.icecreamnation.week6.states.*;

public class IceCreamAddict {
	HashMap<AddictStates, AddictState> states = new HashMap<AddictStates, AddictState>();
	public List<ReportStep> report_steps = new ArrayList<ReportStep>();
	
	public int totalSugarInBody = 0;
	public int sugarLimit = 0;
	AddictState state;
	
	public IceCreamAddict(int sugarLimit)
	{
		this.sugarLimit = sugarLimit;
		buildStates();
	}
	
	void buildStates()
	{
		states.put(AddictStates.Craving, new CraveIceCreamState(this));
		states.put(AddictStates.Eating, new EatingIceCreamState(this));
		states.put(AddictStates.Satisfied, new SatisfiedIceCreamState(this));
		states.put(AddictStates.UnSatisfied, new UnSatisifiedIceCreamState(this));
		states.put(AddictStates.SugarRush, new SugarRushIceCreamState(this));
		states.put(AddictStates.WalkItOff, new WalkItOffIceCreamState(this));
		transitionTo(AddictStates.Craving);
	}
	
	public void transitionTo(AddictStates addictsState) 
	{
		state = states.get(addictsState);
	}
	
	public boolean isSatisfied()
	{
		return state.isSatisfied();
	}
	
	public void doThingsToSatisfy()
	{
		state.doThingsToSatisfy();
	}
	
	public void addSugarIntoBody(int sugar) 
	{
		totalSugarInBody = totalSugarInBody + sugar;
		var step = new ReportStep();
		step.step = ReportStepsEnum.SUGAR_ADDED;
		step.value = sugar;
		report_steps.add(step);
	}
	
	public void removeSugarFromBody(int sugar) 
	{
		totalSugarInBody = totalSugarInBody - sugar;
		var step = new ReportStep();
		step.step = ReportStepsEnum.SUGAR_EXPENDED;
		step.value = sugar;
		report_steps.add(step);
	}
	
	public void calcCalories()
	{
		var step = new ReportStep();
		step.step = ReportStepsEnum.WEIGHT_GAINED;
		step.value = (totalSugarInBody * 95);
		report_steps.add(step);
	}
	
	public boolean hasExcess()
	{
		return totalSugarInBody > sugarLimit;
	}
	
	
}
