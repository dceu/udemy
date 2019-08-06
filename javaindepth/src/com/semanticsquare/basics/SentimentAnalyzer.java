import java.util.Arrays;

public class SentimentAnalyzer {
	public static int[] detectProsAndCons (String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords){
		int[] featureOpinions = new int[featureSet.length]; //output
		//invoke getOpinionOnFeature iterate through each element of featureSet to check for a +ve , -ve or no opinion
featureTest:for (int i = 0; i < featureSet.length;  i++){ 
			System.out.println();
			System.out.println("Getting opinion on \"" + featureSet[i][0] + "\"");

			for (int j = 0; j <  featureSet[i].length ; j++){
				String feature = featureSet[i][j];
				featureOpinions[i]=getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
				if (featureOpinions[i] != 0){
					continue featureTest;
				}
			}
		}
		return featureOpinions; // featureOpinions will be an array of 5 bytes, e.g. 1,0,1,1,0
	}

	//first invoke checkForWasPhrasePattern if no opinion,
	//then invoke checkForOpinionFirstPattern
	
	private static int getOpinionOnFeature (String review, String feature, String[] posOpinionWords, String[] negOpinionWords){
		//return -1, 1, or 0 for -ve, +ve, or no opinion
		System.out.println("Testing feature: " + feature);
		int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords); 
		if (opinion == 0){
			return checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		}
		return opinion;
	}
	
	private static int checkForWasPhrasePattern (String review, String feature, String[] posOpinionWords, String[] negOpinionWords){
		int opinion = 0;
		String pattern = feature + " was " ;
		if (review.contains(pattern)){
			for (String posOpinion : posOpinionWords){			 //Check for positiveOpinions
			System.out.println("Checking instances of \"" + pattern + posOpinion +"\"");
				if (review.contains(pattern + posOpinion)) {
					System.out.println("\t\"" + pattern + posOpinion + "\"");
					opinion = 1;
					break;
				}		
			}	

				
			for (String negOpinion : negOpinionWords){			// then negative opinion	
				if (review.contains(pattern + negOpinion)){
					System.out.println("\t\"" + pattern + negOpinion + "\"");
					opinion = -1;
					break;
				}
			}

			return opinion; // returns +1 or -1
		} else {
			// System.out.println("Pattern: \"" + pattern + "\" was not found. Checking Opinion First.");
			return opinion;} //returns 0 and proceeds to checkForOpinionFirstPattern
	}
	
	
	private static int checkForOpinionFirstPattern (String review, String feature, String[] posOpinionWords, String[] negOpinionWords){
		//Extract sentences as feature might appear multiple times
		//split() takes a regular expression and "." is a special char
		//for regular expression. So, escape it to make it work!!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
		for (String sentence : sentences){ 		//process each sentence
			if (sentence.contains(feature)){	//at each instance of feature
				sentence = sentence.trim();
				System.out.println("\tAbout \"" + feature + ":\"");
				System.out.println("\t\"" + sentence + "\"");
				for (String posOpinion : posOpinionWords){
					String expression = posOpinion + " " + feature;
					if (sentence.contains(expression)){
						System.out.println("\t\""+ expression + "\" was found!!");
						opinion = 1;
						break;
					}
				}
				for (String negOpinion : negOpinionWords){
					String expression = negOpinion + " " + feature;
					if (sentence.contains(expression)){
						System.out.println("\t\""+ expression + "\" was found!!");
						opinion =  -1;
						break;

					}
				}
			return opinion;	
			}
		}
		System.out.println("Nothing was said about: "  + feature);
		return opinion;

	}

	public static void main (String[] args){
		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
	//	String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		review = review.toLowerCase(); // set review to lowercase for ez comparisons
		String[][] featureSet = {
			{"ambiance","ambience","atmosphere","decor"},
			{"dessert","ice cream","desert"},
			{"food"},
			{"appetizer","appetizers","breadsticks","soup","salad"},
			{"service","management","waiter","waitress","bartender","staff","server"}
		};

		String[] posOpinionWords = {"good","fantastic","friendly","excellent","amazing","awesome","delicious"};
		String[] negOpinionWords = {"slow","bad","horrible","awful","unprofessional","poor","cold","burnt"};
		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}
