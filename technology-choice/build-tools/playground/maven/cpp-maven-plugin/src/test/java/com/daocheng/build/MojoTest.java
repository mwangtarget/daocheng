package com.daocheng.build;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.CommandLineUtils.StringStreamConsumer;
import org.codehaus.plexus.util.cli.Commandline;

public class MojoTest {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("MojoTest");
		// Customized variables checking
		File cppOutputFolder = new File("/tmp/output");
		if (!cppOutputFolder.exists()) {
			log.info("cppOutputLocation does not exist, create first by default");
			cppOutputFolder.mkdirs();
		}

		List<Path> cppSourceList = new ArrayList();

		File cppSourceFolder = new File(
				"/home/mwang/projects/daocheng/technology-choice/build-tools/playground/maven/cpp-maven-plugin/src/test/");
		if (!cppSourceFolder.exists()) {
			throw new RuntimeException("cppSourceLocation does not exist, abort the operation");
		} else {
			Path cppSourcePath = cppSourceFolder.toPath();
			try {
				Files.walk(cppSourcePath).filter(x -> x.getFileName().toString().endsWith("cpp"))
						.forEach(x -> cppSourceList.add(x));
			} catch (IOException e) {
				// Can Ignorename
				e.printStackTrace();
			}

		}

		Map<String, String> cppOutputMap = new HashMap<>();
		cppSourceList.stream().forEach(x -> {

			cppOutputMap.put(x.toFile().getAbsolutePath(),
					 cppOutputFolder.getAbsolutePath() + "/" + x.getFileName().toString().replace("cpp", "o"));
		});

		
		StringStreamConsumer output = (StringStreamConsumer) new CommandLineUtils.StringStreamConsumer();
		StringStreamConsumer error = (StringStreamConsumer) new CommandLineUtils.StringStreamConsumer();
		 
		File gcc = new File("/usr/bin/cpp");
		if (!gcc.exists()) {
			throw new RuntimeException("CPPCompiler does not exist, abort the operation");
		} else {
			log.info("CPP compiler found");

			Commandline cl = new Commandline();
			cl.setExecutable(gcc.getAbsolutePath());
			cl.addArguments(new String[] {"--version"});
			
			try {
				final int result = CommandLineUtils.executeCommandLine(cl, null, output, error);
				log.info(output.getOutput());
				log.warning(error.getOutput());
			} catch (CommandLineException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		// Compile CPP files now
		log.info("Star to complie CPP files ");
		log.info("Source Location: " + cppSourceFolder.getAbsolutePath());
		log.info("Output Location: " + cppOutputFolder.getAbsolutePath());
		log.info("Compiler: " + gcc.getAbsolutePath());
		// log.info("Compiler flags: " + cppCompilerFlags);

		cppOutputMap.entrySet().stream().forEach(e -> {
			
			Commandline cl = new Commandline();
			cl.setExecutable(gcc.getAbsolutePath());
			cl.addArguments(new String[] {e.getKey(), "-o", e.getValue()});
			
			try {
				final int result = CommandLineUtils.executeCommandLine(cl, null, output, error);
				log.info(output.getOutput());
				log.warning(error.getOutput());
			} catch (CommandLineException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
