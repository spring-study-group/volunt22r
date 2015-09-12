package study.spring.todo.constant;

public enum UserStatus {
	L("Live"), R("Rest"), D("Delete");
	
	private String description;
	
	private UserStatus(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return description;
	}
}
