package adzarei.loe.server.bootstrap;

import adzarei.loe.server.domain.*;
import adzarei.loe.server.respositories.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private LibroRepository libroRepository;
    private ActaRepository actaRepository;
    private OrdenRepository ordenRepository;
    private AdjuntoRepository adjuntoRepository;
    private AgenteRepository agenteRepository;
    private AsistenteRepository asistenteRepository;
    private FirmaRepository firmaRepository;

    public Bootstrap(LibroRepository libroRepository, ActaRepository actaRepository, OrdenRepository ordenRepository, AdjuntoRepository adjuntoRepository, AgenteRepository agenteRepository, AsistenteRepository asistenteRepository, FirmaRepository firmaRepository) {
        this.libroRepository = libroRepository;
        this.actaRepository = actaRepository;
        this.ordenRepository = ordenRepository;
        this.adjuntoRepository = adjuntoRepository;
        this.agenteRepository = agenteRepository;
        this.asistenteRepository = asistenteRepository;
        this.firmaRepository = firmaRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Adjunto adjunto = new Adjunto();
        adjunto.setNombre("adjunto1.txt");
        adjunto.setContenido("ADASDFSGNSFGNSDFARH");
        adjunto.setMediaType(MediaType.IMAGE_PNG_VALUE);


        Orden orden = new Orden();
        orden.setNumOrden(1);
        orden.setTituloOrden("Primera Orden");
        orden.setContenido("Este es el contenido de la orden numero uno.");
        orden.addAdjunto(adjunto);
        /*List<Adjunto> adjuntos = new ArrayList<>();
        adjuntos.add(adjunto);
        orden.setAdjuntos(adjuntos);
        adjunto.setOrden(orden);*/

        Acta acta = new Acta();
        acta.setNumHoja(1);
        acta.setTipoActa(TipoActa.INICIO);
        acta.setFActa(LocalDateTime.now());
        acta.setDescTipoActa("Acta de Inicio");
        acta.setNumlibro("VLC-00012");
        acta.addOrden(orden);

        adjuntoRepository.save(adjunto);
        ordenRepository.save(orden);


        Firma firma = new Firma();
        firma.setCertificado("043049678964967937");
        firma.setDescipcionAgente("Arquitecto Director");
        firma.setEmail("AdrianZapater@gmail.com");
        firma.setSello("sfd6g4n3dh4n3xg4n3djhm4s3m43gh4n3ghmchg3nf3hj43th43st7hs4gb34gn34gnb3xd4gb");
        firma.setTipoAgente(TipoAgente.DO);
        acta.addFirma(firma);

        firmaRepository.save(firma);
        actaRepository.save(acta);

        Agente agente = new Agente();
        agente.setFFin(LocalDateTime.now());
        agente.setFInicio(LocalDateTime.now());
        agente.setIdFiscal("21804947G");
        agente.setNombre("José Zapater");
        agente.setTipoAgente(TipoAgente.DO);

        Libro libro1 = new Libro();
        libro1.setNumlibro("VLC-00012");
        libro1.setAyto("AYTO VLC");
        libro1.setCAE("CAE001");
        libro1.setFAutorizacion(LocalDateTime.now());
        libro1.setFFinObra(LocalDateTime.now());
        libro1.setFInicioObra(LocalDateTime.now());
        libro1.setFCAE(LocalDateTime.now());
        libro1.setFLicencia(LocalDateTime.now());
        libro1.setNumExpColegio("NUM_EXP_1");
        libro1.setNumLicencia("Num_Licnecia_001");
        libro1.setObra("Nombre de Obra 01");
        libro1.setSituacion("Calle Lope  de Rueda 15, 7");
        libro1.addAgente(agente);

        libro1.addActa(acta);
        libro1.addFirma(firma);
        libro1.addAgente(agente);


        agenteRepository.save(agente);
        libroRepository.save(libro1);


    }
}
