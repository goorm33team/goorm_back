package goorm_3team.company;

import goorm_3team.company.models.Company;
import goorm_3team.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CompanyApplication {
	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
//		String[] regions = {"서울시", "경기도 성남시", "경기도 파주시", "부산", "대구", "대전"};
//		String[] types = {"대기업", "유니콘", "벤쳐", "중견기업", "소기업", "스타트업"};
//		for (int i = 1; i <= 100; i++) {
//			String companyName = "Company " + i;
//			String address = regions[(int) (Math.random() * regions.length)];
//			String type = types[(int) (Math.random() * types.length)];
//			Company company = new Company(companyName, address, type);
//			companyRepository.save(company);
//		}
	}

}
