package com.dog.challenge.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author sfe
 */
public class ModelApplication {

	public static final Logger log =  LoggerFactory.getLogger(ModelApplication.class);


	public static void main(String[] args) {
		List<Model> models = ModelConverter.convertDataToModelList(new ModelApplication().dogString());

		models.forEach(m -> log.info(m.toString()));
	}

	//Convert the dogString below to a model list
	//Each line in a dog string can be converted to a Model except
	//    - A line with more than 2 fields(e.g. "dog05;dog06;dog07\n")
	//    - A line with null values (e.g. ";;\n")
	private String dogString() {
		return """
					dog01;dog02\n
					dog03;dog04\n
					dog05;dog06;dog07\n
					;;\n
				""";
	}

}
