package in.ibm.beans;

import lombok.Setter;

//using this to use the DI with Setter injection of FortuneService
@Setter
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		
		return "Run 5KM today";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
