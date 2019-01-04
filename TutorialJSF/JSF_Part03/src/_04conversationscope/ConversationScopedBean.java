package _04conversationscope;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "conversationScopedBean") // javax.inject.Named
@ConversationScoped
// CDI bean yapıyoruz.
public class ConversationScopedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// inject bizim için bu objeyi oluşturacak.
	@Inject // DI (dependency injection)
	private Conversation conversation;

	private Employee employee;

	@PostConstruct // ilgili obje olustuktan sonra calısır.
	public void init() {
		System.out.println("initing...");
		employee = new Employee();
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	// getStart, getFinish olmayacak cünkü action yapıyoruz.
	public String start() {
		conversation.begin();
		return "02.loginConversationScoped.xhtml?faces-redirect=true";
	}

	public String finish() {
		conversation.end();
		return "05.afterEndConversation.xhtml?faces-redirect=true";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
