package adzarei.loe.server.api.bootstrap;

import adzarei.loe.server.api.domain.*;
import adzarei.loe.server.api.domain.tipos.TipoActa;
import adzarei.loe.server.api.domain.tipos.TipoAgente;
import adzarei.loe.server.api.respositories.*;
import adzarei.loe.server.security.model.LoginUser;
import adzarei.loe.server.security.repositories.LoginUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private LibroRepository libroRepository;
    private ActaRepository actaRepository;
    private OrdenRepository ordenRepository;
    private AdjuntoRepository adjuntoRepository;
    private AgenteRepository agenteRepository;
    private AsistenteRepository asistenteRepository;
    private FirmaRepository firmaRepository;
    private LoginUserRepository loginUserRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //initData();
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

        Asistente asistente = new Asistente();
        asistente.setCargo("Constructor");
        asistente.setNombre("Maria Brull MArtinez");
        asistente.setTipoAgente(TipoAgente.CONSTRUCTOR);

        Acta acta = new Acta();
        acta.setNumHoja(1);
        acta.setTipoActa(TipoActa.INICIO);
        acta.setFActa(LocalDateTime.now());
        acta.setDescTipoActa("Acta de Inicio");
        acta.setNumlibro("VLC-00012");
        acta.addOrden(orden);
        acta.addAsistente(asistente);

        Firma firma = new Firma();
        firma.setCertificado("043049678964967937");
        firma.setDescipcionAgente("Arquitecto Director");
        firma.setEmail("AdrianZapater@gmail.com");
        firma.setSello("sfd6g4n3dh4n3xg4n3djhm4s3m43gh4n3ghmchg3nf3hj43th43st7hs4gb34gn34gnb3xd4gb");
        firma.setTipoAgente(TipoAgente.DO);
        acta.addFirma(firma);

        Agente agente = new Agente();
        agente.setFFin(LocalDateTime.now());
        agente.setFInicio(LocalDateTime.now());
        agente.setIdFiscal("21804947G");
        agente.setNombre("José Zapater");
        agente.setTitulo("Ingeniero Informático");
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

        LoginUser usuario = new LoginUser();
        usuario.setUsername("admin");
        usuario.setPassword("pw");
        libro1.setPropietario(usuario);

        loginUserRepository.save(usuario);
        firmaRepository.save(firma);
        libroRepository.save(libro1);
        actaRepository.save(acta);
        agenteRepository.save(agente);
        ordenRepository.save(orden);
        adjuntoRepository.save(adjunto);
        asistenteRepository.save(asistente);

    }
}
