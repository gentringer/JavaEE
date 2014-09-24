package com.gestion.model.tdb;
import com.hp.hpl.jena.query.Dataset ;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.store.DatasetGraphTDB;

import java.util.*;

import com.hp.hpl.jena.util.FileManager;

public class CreationDepartements
{
	public static final String rdf_departement= "departement.rdf";


    public void createmodel()
    {
        // Make a TDB-back Jena model in the named directory.
        String directory = "/home/gentringer/universite/Master2-Aigle/gestion-donnees-complexes/ProjetJEE/WebContent/tdb/departements-database" ;
        Dataset ds = TDBFactory.createDataset(directory) ;
        Model reg = ds.getNamedModel( "departements" );  

        FileManager.get().readModel( reg, "/home/gentringer/universite/Master2-Aigle/gestion-donnees-complexes/ProjetJEE/WebContent/rdf-data/"+rdf_departement );        

        Model	model = null;     
        Iterator<String> graphNames = ds.listNames();
        while (graphNames.hasNext()) {
            String graphName = graphNames.next();       
            model = ds.getNamedModel(graphName);
      		System.out.println("Named graph with Ontology " + graphName + " size: " + model.size());
       	}
        model.close();
        ds.close();
    }
    
}