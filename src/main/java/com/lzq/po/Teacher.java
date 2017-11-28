package com.lzq.po;

public class Teacher {
    private Integer id;

    private String name;

    private Integer type;

    private String workid;
    private Teatype teatype;
    private Login login;

    public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Teatype getTeatype() {
		return teatype;
	}

	public void setTeatype(Teatype teatype) {
		this.teatype = teatype;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }
}