package com.santivallejo.utils;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import com.santivallejo.pojo.Descuento;
import com.santivallejo.pojo.Usuario;

public class CargaReglaDescuento {
	
	public static final String RUTA = "D:/DATOS/svallejs/Desktop/ProyBRMS/workspaceDrools/reglasDrools/";
	
	public static void Load(Usuario usu, Descuento des, String regla){
		
		
		KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();
        
//        kfs.write(ResourceFactory.newClassPathResource("../reglas/SetCiudad.drl", this.getClass()));
        kfs.write(ResourceFactory.newFileResource(RUTA+regla));

        KieBuilder kb = ks.newKieBuilder(kfs);

        kb.buildAll(); // kieModule is automatically deployed to KieRepository if successfully built.
        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());

        KieSession kSession = kContainer.newKieSession();

        kSession.insert( usu );
        kSession.insert( des );

        kSession.fireAllRules();
        kSession.dispose();
        
	}
	


}
