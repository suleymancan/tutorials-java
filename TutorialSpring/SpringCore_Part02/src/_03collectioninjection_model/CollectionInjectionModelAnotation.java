package _03collectioninjection_model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//buraya controller, component, repository, service verebilirim.
// bu isimler aynı isi yapıyor. katmana göre farklı isimler alıyor.
@Service("collectionInjectionModelAnnotation1")
public class CollectionInjectionModelAnotation {

	@Resource(name = "utilAnnotationList")
	// collection typeları inject ederken @Autowired yerine @Resource ya da @Value
	// (spring'te yer alır.) kullanırız.
	private List<String> nameList;

	// expression language ile vermeliyiz.
	@Value(value = "#{utilAnnotationMap}")
	private Map<String, Integer> keyValueMap;

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Map<String, Integer> getKeyValueMap() {
		return keyValueMap;
	}

	public void setKeyValueMap(Map<String, Integer> keyValueMap) {
		this.keyValueMap = keyValueMap;
	}

	@Override
	public String toString() {
		return "CollectionInjectionModelAnotation [nameList=" + nameList + ", keyValueMap=" + keyValueMap + "]";
	}

}
