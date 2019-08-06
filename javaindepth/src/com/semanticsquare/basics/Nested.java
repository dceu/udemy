import java.util.Arrays;
public class Nested { public static double [] calculateGPA(int[] studentIdList, char[][] studentsGrades){
	double[] GPA = new double[studentIdList.length] ;
	for (int i=0 ;i< studentIdList.length; i++){
		int gradePoints = 0;
		for (int j=0; j < studentsGrades[i].length; j++){
			char grade = studentsGrades[i][j];
			switch (grade){
				case 'A': gradePoints +=4;
					 break;
				case 'B': gradePoints +=3;
					 break;
				case 'C' : gradePoints +=2;
					  break;
				default: break;
			}
			System.out.println(studentIdList[i]+" points: " + gradePoints);
		}
		System.out.println(studentIdList[i] + ": " + gradePoints);
		System.out.println("GPA before: " + GPA[i]);
		GPA[i] =(double) gradePoints /(double) studentsGrades[i].length;
		System.out.println("GPA after: " + GPA[i]);
		System.out.println(gradePoints + " / " + studentsGrades[i].length);
		System.out.println(studentIdList[i] + ": " + GPA[i]);
		System.out.println("GPA[i] = " + GPA[i]);
	}
	return GPA;
	}


//begin StudentsbyGPA Method
public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char [][] studentsGrades) {
if (higher < 0 || lower < 0 || lower > higher){
	return null;
} else {
	double[] GPA = calculateGPA(studentIdList, studentsGrades);
	System.out.println("GPA Array for StubyGPA: " + Arrays.toString(GPA));
	int[] listGPA = new int[studentIdList.length];
	System.out.println("ListGPA before loop: " + Arrays.toString(listGPA));
		for (int i=0; i < studentIdList.length; i++){
		System.out.println("Checking GPA: " + GPA[i] + ", Pushing listGPA[i]: " + listGPA[i]);	
			if (GPA[i] >= lower && GPA[i] <= higher) {
			listGPA[i]=studentIdList[i];
			}

			System.out.println("ListGPA[i]: " + listGPA[i]);
		}
		System.out.println(Arrays.toString(listGPA));
		return listGPA;
}
}



	public static void main(String args[]){
	int[] studs = new int[] {1001,1002};
	char [][] grados = new char [][] {{'A','B','C'},{'A','B','A'}};	
	System.out.println("begin CalculateGPA");
	calculateGPA(studs, grados);
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("begin StudentsbyGPA");
	getStudentsByGPA(2.5,4.0,studs,grados);
	}	
}
