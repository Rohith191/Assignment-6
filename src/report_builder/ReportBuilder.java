package report_builder;

public interface ReportBuilder {
	public ReportBuilder addSugarIntake(int sugar);
	public ReportBuilder removeSugarIntake(int sugar);
	public ReportBuilder addCalories(int cals);
	public ReportBuilder calcLifeExpectancy();
	public ReportBuilder calcChanceOfHeartDisease();
	public String buildReport();
}
