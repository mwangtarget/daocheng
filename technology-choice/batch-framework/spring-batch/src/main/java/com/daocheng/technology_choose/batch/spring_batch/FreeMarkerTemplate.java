package com.daocheng.technology_choose.batch.spring_batch;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTemplate {

	private Resource ftlPath;
	private String ftlName;

	public void setFtlPath(Resource ftlPath) {
		this.ftlPath = ftlPath;
	}

	public void setFtlName(String ftlName) {
		this.ftlName = ftlName;
	}

	public Template getTemplate() {

		Configuration conf = new Configuration();
		Template template = null;

		try {
			conf.setDirectoryForTemplateLoading(ftlPath.getFile());

			template = conf.getTemplate(ftlName);
		} catch (IOException e) {
			// Ignore for now
			e.printStackTrace();
		}

		return template;
	}
}
