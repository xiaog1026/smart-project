package jp.co.project.smart.model;

public class HeroesDto {

    private int id;
    private String name;
    private int age;
    private int orderlin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderlin() {
		return orderlin;
	}

	public void setOrderlin(int orderlin) {
		this.orderlin = orderlin;
	}

}
