package edu.isi.karma.modeling;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.isi.karma.modeling.alignment.Alignment;
import edu.isi.karma.modeling.alignment.GraphUtil;
import edu.isi.karma.modeling.ontology.OntologyManager;
import edu.isi.karma.rep.semantictypes.SemanticType;

public class Test {

	private static void loadOntologies(OntologyManager ontManager) {

		int size = 5;
		File[] f = new File[size];
		
		
		f[0] = new File("D:\\Academic\\ISI\\_GIT\\Web-Karma\\test\\vivo1.4-protege.owl");
		f[1] = new File("D:\\Academic\\ISI\\_GIT\\Web-Karma\\test\\sample.owl");
		f[2] = new File("D:\\Academic\\ISI\\_GIT\\Web-Karma\\test\\Wiki.owl");
		f[3] = new File("D:\\Academic\\ISI\\_GIT\\Web-Karma\\test\\DoveTailOntoRDF.owl");
		f[4] = new File("D:\\Academic\\ISI\\_GIT\\Web-Karma\\test\\Dovetail_ISI_mod.owl");
		
		for (int i = 0; i < 1; i++) {
			ontManager.doImport(f[i]);
		}
	}
	
	private static List<SemanticType> createTestInput1() {
		
		List<SemanticType> semanticTypes = new ArrayList<SemanticType>();
		
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#City", null, 0.0, false) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#hasCode", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#zipCode", null, 0.0, false) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#hasModel", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Country", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Country", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#zipCode", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#City", null, 0.0) );
		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#hasName", "http://mohsen.isi.edu/sample.owl#Person", null, 0.0, false) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#hasName", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#hasName", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#live", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Place", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Plant", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Person", null, 0.0, false) );
//		semanticTypes.add( new SemanticType(null, "http://mohsen.isi.edu/sample.owl#Animal", null, 0.0, false) );
//		semanticTypes.add( new SemanticType(null, "http://www.w3.org/2002/07/owl#Thing", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://www.w3.org/2002/07/owl#Thing", null, 0.0) );
		
		return semanticTypes;
	}

	private static List<SemanticType> createTestInput2() {
		
		List<SemanticType> semanticTypes = new ArrayList<SemanticType>();
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#PharmGKBId", 
				"http://halowiki/ob/category#Gene", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#PharmGKBId", 
				"http://halowiki/ob/category#Pathway", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#PharmGKBId", 
				"http://halowiki/ob/category#Disease", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#PharmGKBId", 
				"http://halowiki/ob/category#Drug", null, 0.0, false) );
		
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#Label", 
				"http://halowiki/ob/category#Gene", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#Label", 
				"http://halowiki/ob/category#Pathway", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#Label", 
				"http://halowiki/ob/category#Disease", null, 0.0, false) );
		
		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/property#Label", 
				"http://halowiki/ob/category#Drug", null, 0.0, false) );
		
//		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/category#Disease", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/category#Drug", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/category#Gene", null, 0.0) );
//		semanticTypes.add( new SemanticType(null, "http://halowiki/ob/category#Pathway", null, 0.0) );
		
		return semanticTypes;
	}
	
	private static List<SemanticType> createTestInput3() {
		
		List<SemanticType> semanticTypes = new ArrayList<SemanticType>();
		
		semanticTypes.add( new SemanticType(null, "http://www.sri.com/ontologies/DovetailOnto.owl#Attack", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://www.sri.com/ontologies/DovetailOnto.owl#Nation", null, 0.0, false) );
		
		return semanticTypes;
	}
	
	private static List<SemanticType> createTestInput4() {
		
		List<SemanticType> semanticTypes = new ArrayList<SemanticType>();
		
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#email", 
				"http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#phoneNumber", 
				"http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#faxNumber", 
				"http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://xmlns.com/foaf/0.1/firstName", 
				"http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://xmlns.com/foaf/0.1/lastName", 
				"http://vivoweb.org/ontology/core#FacultyMember", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#Position", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#Department", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#Department", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#Department", null, 0.0, false) );
		semanticTypes.add( new SemanticType(null, "http://vivoweb.org/ontology/core#Department", null, 0.0, false) );
		
		return semanticTypes;
	}
	
	public static void main(String[] args) {
		
		OntologyManager ontManagar = new OntologyManager();
		loadOntologies(ontManagar);
//		System.out.println(ontManagar.getOntModel().getNsURIPrefix("http://vivoweb.org/ontology/core#"));
//		System.out.println(ontManagar.getOntModel().getNsPrefixURI("vivo"));
//		System.out.println(ontManagar.getOntModel().get("vivo"));
//		if (true) return;

//		List<SemanticType> semTypes1 = createTestInput1();
//		List<SemanticType> semTypes2 = createTestInput2();
//		List<SemanticType> semTypes3 = createTestInput3();
		List<SemanticType> semTypes4 = createTestInput4();

		Alignment alignment = null;
//		alignment = new Alignment(ontManagar, semTypes1);
//		alignment = new Alignment(ontManagar, semTypes2);
//		alignment = new Alignment(ontManagar, semTypes3);
		alignment = new Alignment(ontManagar, semTypes4);
		
		
//		alignment.getSteinerTree();
//		GraphUtil.printGraph(alignment.getAlignmentGraph());
		GraphUtil.printGraph(alignment.getSteinerTree());
//		GraphUtil.printGraphSimple(alignment.getSteinerTree());

//		Alignment alignment2 = new Alignment(ontManagar, semTypes4);
//		GraphUtil.printGraphSimple(alignment2.getSteinerTree());
//		Alignment alignment3 = new Alignment(ontManagar, semTypes4);
//		GraphUtil.printGraphSimple(alignment3.getSteinerTree());


//		alignment.addUserLink("http://halowiki/ob/property#involves1");
//		GraphUtil.printGraph(alignment.getSteinerTree());
//		alignment.addUserLink("http://halowiki/ob/property#IsInvolvedIn1");
//		GraphUtil.printGraph(alignment.getSteinerTree());

		
//		alignment.getSteinerTree();
//		GraphUtil.printGraph(alignment.getSteinerTree());
		
//		alignment.addUILink("http://halowiki/ob/property#Causes1");
//		GraphUtil.printGraph(alignment.getSteinerTree());



	}
}
