package application;


import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import application.models.Lokacija;
import application.models.Putovanje;
import application.repository.LokacijaRepository;
import application.repository.PutovanjeRepository;

@EnableDiscoveryClient
@ComponentScan()
@SpringBootApplication
public class PutovanjeMikroservisApplication {

	private static final Logger log = LoggerFactory.getLogger(PutovanjeMikroservisApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(PutovanjeMikroservisApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(PutovanjeRepository putovanjeRepository, LokacijaRepository lokacijaRepo) {
		return (args) -> {
			log.info("INICIJALIZACIJA TESTNIH PODATAKA");
			Timestamp ts1 = new Timestamp(1521579640*1000L);
			Timestamp ts2 = new Timestamp(1521579641*1000L);
			Timestamp ts3 = new Timestamp(1521579642*1000L);
			Timestamp ts4 = new Timestamp(1521579643*1000L);
			

			putovanjeRepository.save(new Putovanje("P1", 1521579640L ,  1));
			putovanjeRepository.save(new Putovanje("P2", 1521579659L , 1521581659L , 2));
			putovanjeRepository.save(new Putovanje("P3", 1521579659L , 1521581659L , 3));
			putovanjeRepository.save(new Putovanje("P4", 1521579936L  , 1521581659L , 1));
			
			lokacijaRepo.save(new Lokacija(ts1, 47.232345, 19.23332, putovanjeRepository.findById(1)));
			lokacijaRepo.save(new Lokacija(ts2, 47.232445, 19.23352, putovanjeRepository.findById(1)));
			lokacijaRepo.save(new Lokacija(ts3, 47.232545, 19.23532, putovanjeRepository.findById(1)));
			lokacijaRepo.save(new Lokacija(ts4, 47.252445, 19.26352, putovanjeRepository.findById(1)));
			
			List<Lokacija> listaLokacija = lokacijaRepo.findAll();
			
			
			
			List<Putovanje> putovanja = putovanjeRepository.findAll();
			for (Putovanje p : putovanja) {
				log.info(p.getNaziv());
				log.info("=====================");
				List<Lokacija> lokacije = p.getListaLokacija();
				if(lokacije == null || lokacije.isEmpty()) {
					log.info("Nema lokacija.");
				} else {
					log.info("Lokacije");
					for(Lokacija l : lokacije) {
						log.info("LAT: " + l.getLatitude() + "LNG: " + l.getLongitude());
						log.info("Timestamp: " + l.getTimestamp().toLocalDateTime());
					}
				}
				
			}
		};
	}
}