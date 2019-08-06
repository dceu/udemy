class Student {
	// variable declarations
	int id;
	String name;
	String gender = "male";
	char[] grades;

	Student(int id, String name) {
		this(name);
		this.id = id;
	}

	Student(int id, String name, char[] grades) {
		this(name);
		this.id = id;
		this.grades = grades;
	}

	Student(String name) {
		this.name = name;
	}

	// method definitions
	String updateProfile(String name) {
		String oldVal = this.name;
		this.name= name;
		return oldVal;
	}
}
