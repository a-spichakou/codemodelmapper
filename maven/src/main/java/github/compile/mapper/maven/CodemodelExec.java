package github.compile.mapper.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

public class CodemodelExec {

	/**
	 * @param args
	 * @throws MojoFailureException 
	 * @throws MojoExecutionException 
	 */
	public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
		if(args==null || args.length==0)
		{
			System.out.print("Please, specify path to generate mappers");			
		}
		
		final String path2generate = args[0];
		final String package2scan = args[1];
		
		final Codemodel model = new Codemodel();
		model.execute(path2generate, package2scan);		
	}

}
