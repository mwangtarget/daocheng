package com.daocheng.build;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;
import org.codehaus.plexus.util.cli.CommandLineUtils.StringStreamConsumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Goal which can Compile CPP files
 * 
 */
@Mojo(name = "cpp", defaultPhase = LifecyclePhase.COMPILE)
public class CPPCompileMojo extends AbstractMojo {
	/**
	 * Location of CPP source file location
	 */
	@Parameter(property = "cpp.source.location")
	private File cppSourceLocation;

	/**
	 * Location of CPP output after compile file location
	 */
	@Parameter(defaultValue = "${project.build.directory}", property = "cpp.output.location", required = true)
	private File cppOutputLocation;



	// The GCC location.
	@Parameter(defaultValue = "/usr/bin/gcc", property = "cpp.compiler.path", required = true)
	private File CPPCompiler;

	public void execute() throws MojoExecutionException {

		// Customized variables checking
		File cppOutputFolder = cppOutputLocation;
		if (!cppOutputFolder.exists()) {
			getLog().info("cppOutputLocation does not exist, create first by default");
			cppOutputFolder.mkdirs();
		}

		List<Path> cppSourceList = new ArrayList();

		File cppSourceFolder = cppSourceLocation;
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
	
		File gcc = CPPCompiler;
		if (!gcc.exists()) {
			throw new RuntimeException("CPPCompiler does not exist, abort the operation");
		} else {
			getLog().info("CPP compiler found");

			Commandline cl = new Commandline();
			cl.setExecutable(gcc.getAbsolutePath());
			cl.addArguments(new String[] { "--version" });

			try {
				final int result = CommandLineUtils.executeCommandLine(cl, null, output, error);
				getLog().info(output.getOutput());
				getLog().error(error.getOutput());
			} catch (CommandLineException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// Compile CPP files now
		getLog().info("Star to complie CPP files ");
		getLog().info("Source Location: " + cppSourceFolder.getAbsolutePath());
		getLog().info("Output Location: " + cppOutputFolder.getAbsolutePath());
		getLog().info("Compiler: " + gcc.getAbsolutePath());
		// getLog().info("Compiler flags: " + cppCompilerFlags);

		cppOutputMap.entrySet().stream().forEach(e -> {

			Commandline cl = new Commandline();
			cl.setExecutable(gcc.getAbsolutePath());
			cl.addArguments(new String[] { e.getKey(), "-o", e.getValue() });

			try {
				final int result = CommandLineUtils.executeCommandLine(cl, null, output, error);
				getLog().info(output.getOutput());
				getLog().error(error.getOutput());
			} catch (CommandLineException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
