package main;
import java.util.List;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class Search extends JUnitStory {

	
	  @Override 
	    public Configuration configuration(){
	        return new MostUsefulConfiguration().useStoryLoader(
	            new LoadFromClasspath(this.getClass()))
	            .useStoryReporterBuilder(
	                new StoryReporterBuilder().withCodeLocation(
	                    CodeLocations.codeLocationFromClass(this
	                        .getClass())).withFormats(    
	                    Format.CONSOLE, Format.TXT, Format.HTML, Format.STATS))
	                    ;    
	    }
	    
	    @Override 
	    public List<CandidateSteps> candidateSteps(){
	        return new InstanceStepsFactory(configuration(), 
	            new SearchSteps()) //can put in a comma separated list of Step implementers here
	            .createCandidateSteps();
	    }

	    protected List<String> storyPaths(){
	        return new StoryFinder().findPaths(
	            CodeLocations.codeLocationFromClass(this.getClass()), 
	            "*.story", "");
	    }
	
}



