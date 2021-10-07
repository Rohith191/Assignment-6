package com.icecreamnation.week6;
import report_builder.BestCaseReportBuilder;
import report_builder.ReportBuilder;

public class Main {

	public static void main(String[] args) {
		IceCreamAddict addict = new IceCreamAddict(500);
		while(!addict.isSatisfied()) {
			addict.doThingsToSatisfy();
		}
		
		 ReportBuilder reportBuilder = new BestCaseReportBuilder();
		 for (var step : addict.report_steps) {
			 
			 if(ReportStepsEnum.SUGAR_ADDED == step.step) {
				 reportBuilder.addSugarIntake(step.value);
			 }
			 else if(ReportStepsEnum.SUGAR_EXPENDED == step.step) {
				 reportBuilder.removeSugarIntake(step.value);
			 }
			 else if(ReportStepsEnum.WEIGHT_GAINED == step.step) {
				 reportBuilder.addCalories(step.value);
			 }
		 }
		 var final_report = reportBuilder
		 	.calcLifeExpectancy()
		 	.calcChanceOfHeartDisease()
		 	.buildReport();
		 
		 System.out.println(final_report);
	}

}
