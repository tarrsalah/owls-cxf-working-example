package org.tarrsalah.owls.working.examples.mindswap.examples;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.InfGraph;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class Remove
{

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		OntModel m =
		ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC);
		String s1 = "http://example.org/r1", s2 = "http://example.org/r2";
		OntClass c1 = m.createClass("http://example.org/c1");
		OntResource r1 = m.createIndividual(s1, c1);
		OntResource r2 = m.createIndividual(s2, c1);
		ObjectProperty op = m.createObjectProperty("http://example.org/p1");

		// add some triples involving r1
		m.add(r1, op, r2);
		m.add(r2, op, r1);

		// iterate over all statements to make sure that model is realized
		StmtIterator stit = m.listStatements();
		while (stit.hasNext())
		{
		  stit.next();
		}
		InfGraph ig = (InfGraph) m.getGraph();
		Graph rg = ig.getRawGraph();

		// remove all raw triples involving r1
		ExtendedIterator<Triple> it = rg.find(r1.asNode(), null, null).andThen(
		  rg.find(null, null, r1.asNode()));
		while (it.hasNext())
		{
		  it.removeNext();
		}

		// rebind and check if r1 is gone
		ig.rebind();

		stit = m.listStatements();
		while (stit.hasNext())
		{
		  Statement s = stit.next();
		  if (s.getSubject().getURI().equals(s1) || s.getResource().getURI().equals(s1))
		     System.out.println("Peng! Some triple in model still mentiones " + s1 + ", statement " + s);
		}

	}

}
