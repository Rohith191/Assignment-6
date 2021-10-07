package report_builder;

import java.util.ArrayList;
import java.util.List;


public class BestCaseReportBuilder implements ReportBuilder {
	List<String> report_lines = new ArrayList<String>();
	int cals;
	
	@Override
	public ReportBuilder addSugarIntake(int sugar) {
		report_lines.add("Sugar		|	Added		|	"+sugar+" oz.");
		return this;
	}

	@Override
	public ReportBuilder removeSugarIntake(int sugar) {
		report_lines.add("Sugar		|	Removed		|	"+sugar+" oz.");
		return this;
	}

	@Override
	public ReportBuilder addCalories(int cals) {
		this.cals = cals;
		report_lines.add("Calories	|	Consumed	|	"+cals+" k.cal");
		return this;
	}

	@Override
	public ReportBuilder calcLifeExpectancy() {
		var l = cals/100;
		report_lines.add("Life Exp.	|	Reduced		|	"+(l-100)+" minutes");
		return this;
	}

	@Override
	public ReportBuilder calcChanceOfHeartDisease() {
		var l = cals/100;
		report_lines.add("Heart Disease	|	IncreasedBy	|	"+(l-140)+"%");
		return this;
	}

	@Override
	public String buildReport() {
		StringBuilder str
        = new StringBuilder();
		str.append("==================Final Report (Best Case)===================").append(System.getProperty("line.separator"));
		str.append("Activity	|	Result		|	Amount	").append(System.getProperty("line.separator"));
		str.append("-------------------------------------------------------------").append(System.getProperty("line.separator"));
		for(var line : report_lines) {
			str.append(line).append(System.getProperty("line.separator"));
		}
		str.append("=============================================================").append(System.getProperty("line.separator"));
		return str.toString();
	}
}
