package _04javabased.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import _04javabased.model.Adress;
import _04javabased.model.Brother;

//2-)
//@Configuration ekledigimizde  bu sınıf bir veya daha fazla @Bean tanımı var 
//anlamına gelir.
@Configuration
// brother.properties'i baska source folder altında package'ye koyarsak / ile
// path belirtmeliyiz.
@PropertySource(value = "brother.properties")

// 3-)
//@ComponentScan(basePackages = "_04javabased.model")
public class SpringConfiguration {

	// 4-)
	// @Lazy'de kullanılabilir. Lazy, ilk istek yaptıgında olusturulur.
	// eagerly ise proje ayaga kalkarken olusturulur.
	// xml'de lazy-init=true attribute kullanabiliriz.
	// büyük projelerde her seyin eagerly'de olusturması projenin ayaga kalkmasını
	// geciktirir.
	// annotation ile de @Lazy

	// 2-)
	@Autowired

	// properties okumak için enviroment'i kullanabiliriz.
	private Environment enviroment;

	// xml konfigurasyonundaki bean'e karsilik gelir.
	// birden fazla olabilir.
	// getBrother gibi bir zorunluluk yok, baska isimlendirme de olabilir.
	@Bean
	// 4-)
	@Lazy
	public Brother getBrother() {
		Brother bro = new Brother();
		// bro.setName("Nazlisu");
		// bro.setSurname("Can");
		// 2-)
		String name = enviroment.getProperty("name");
		String surname = enviroment.getProperty("surname");
		bro.setName(name);
		bro.setSurname(surname);
		
		return bro;
	}

	// 2-)
	 @Bean
	 public Adress getAdress() {
	 Adress adress = new Adress();
	 adress.setCity("Gaziantep");
	 adress.setCountry("Turkey");
	 return adress;
	 }

}
